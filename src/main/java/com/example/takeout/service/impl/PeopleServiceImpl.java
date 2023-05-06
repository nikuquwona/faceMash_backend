package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.entity.People;
import com.example.takeout.mapper.PeopleMapper;
import com.example.takeout.service.PeopleService;
import org.springframework.stereotype.Service;


@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements PeopleService {
}
