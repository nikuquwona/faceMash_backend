package com.example.takeout.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeout.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

// 补充一下，mapper是为了与数据库交互的
// mybatisplus 提供了一些基本的方法
@Mapper  //数据库里select delete
public interface EmployeeMapper extends BaseMapper<Employee> {

}
