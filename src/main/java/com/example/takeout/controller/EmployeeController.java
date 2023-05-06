package com.example.takeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.takeout.common.R;
import com.example.takeout.entity.Employee;
import com.example.takeout.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.dsig.DigestMethod;

//@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    /*
    @Autowired可以标注在属性上、方法上和构造器上，来完成自动装配。默认是根据属性类型，spring自动将匹配到的属性值进行注入
    ，然后就可以使用这个属性（对Springboot02WebApplicationTests类来说）autoWiredBean对象的方法。
     */
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) { //请求是json，包括username and password，用requestbody封装一下
        //httpServlet 将信息存到session，便于后续查看

        String password = employee.getPassword();
        // md5 加密
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());

        /*
            LambdaQueryWrapper<BannerItem> wrapper = new QueryWrapper<BannerItem>().lambda();
            wrapper.eq(BannerItem::getBannerId, id);
            List<BannerItem> bannerItems = bannerItemMapper.selectList(wrapper);
         */
        LambdaQueryWrapper<Employee> queryMapper = new LambdaQueryWrapper<>();
        queryMapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryMapper);

        if (emp == null || !emp.getPassword().equals(passwordMd5)) {
            return R.error("登录失败");
        }
        if (!emp.getStatus().equals(1)) {
            return R.error("用户状态锁定");
        }

        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
//        return null;
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        // 这里牵扯到两块信息存储，一块存到了session中，用途未知，大概是后端用的
        // 一块存到local本地，用于页面展示，前端用的

        //所以后端只去掉session就行
        request.getSession().removeAttribute("employee");
        return R.success("log out success");
    }
}
