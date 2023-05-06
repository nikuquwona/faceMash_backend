package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.entity.Employee;
import com.example.takeout.mapper.EmployeeMapper;
import com.example.takeout.service.EmployeeService;
import org.springframework.stereotype.Service;

// 添加service注解由 spring 来管理
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
