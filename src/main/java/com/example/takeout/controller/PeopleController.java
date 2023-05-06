package com.example.takeout.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.takeout.entity.Employee;
import com.example.takeout.common.R;
import com.example.takeout.entity.People;
import com.example.takeout.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @PostMapping("/get_girl")
    public List<People> get_girl(HttpServletRequest request) {

        LambdaQueryWrapper<People> queryMapper = new LambdaQueryWrapper<>();

        List<People> data = peopleService.list(queryMapper);
//        log.info("data {}",data);
//        List<RandomData> allData = peopleService.
        for (var people : data) {
            var url = people.getImageUrl();
            url = "http://localhost:8080/images/" + url;
//            url = "http://129.226.83.165:8080/images/"+url;
            people.setImageUrl(url);
        }
        Collections.shuffle(data);

        return data.subList(0, 2);
    }

    @PostMapping("/compare_girl")
    public R<String> compare_girl(HttpServletRequest request, @RequestParam String id1, @RequestParam String id2) {
//        for (var people:peoples){
//            LambdaQueryWrapper<People> queryMapper =new LambdaQueryWrapper<>();
//            queryMapper.eq(People::getId,people.getUsername());
//            log.info("updateById {} {}",id1,id2);
//            peopleService.updateById(people);
//            LambdaQueryWrapper<People> queryMapper =new LambdaQueryWrapper<>();
//            queryMapper.eq(People::getId,id1);
        People winer = peopleService.getById(id1);
        People loser = peopleService.getById(id2);


        var Ra = winer.getScore();
        var Rb = loser.getScore();
        var Ea = 1 / (1 + Math.pow(10, (Rb - Ra) / 400));
        var Eb = 1 / (1 + Math.pow(10, (Ra - Rb) / 400));
        var K = 32;
        var Ra_new = Ra + K * (1 - Ea);
        var Rb_new = Rb + K * (0 - Eb);
//            log.info("updateById {} {}",Ra,Ra_new);
//            log.info("updateById {} {}",Rb,Rb_new);

        winer.setScore((float) Ra_new);
        loser.setScore((float) Rb_new);

        peopleService.updateById(winer);
        peopleService.updateById(loser);
//        }
        return R.success("success");
//        log.info("data {}",data);
//        List<RandomData> allData = peopleService.
//        Collections.shuffle(data);

//        return  data.subList(0, 2);
    }
}
