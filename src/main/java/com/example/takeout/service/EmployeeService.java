package com.example.takeout.impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeout.entity.Employee;

// 接口 继承自Iservice，需要指定一个实体
public interface EmployeeService  extends IService<Employee> {
}
