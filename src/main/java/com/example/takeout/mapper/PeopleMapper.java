package com.example.takeout.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.takeout.entity.People;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleMapper extends BaseMapper<People> {

}
