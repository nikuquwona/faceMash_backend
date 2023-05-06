package com.example.takeout.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeout.entity.Employee;

// 接口 继承自Iservice，需要指定一个实体
/*
IService位于 com.baomidou.mybatisplus.extension.service包下的一个接口规范，接口中包含的一系列的dao层交互操作，一般在服务层进行继承操作。
 */

public interface EmployeeService extends IService<Employee> { //IService 有 lamdaquery等 高级查询方法
}
