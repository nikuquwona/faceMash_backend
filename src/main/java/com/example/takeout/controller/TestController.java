package com.example.takeout.controller;

import com.example.takeout.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/message")
public class TestController {

    @PostMapping()
    public R<String> getMessage() {
        return R.message("hello spring");
    }
}
