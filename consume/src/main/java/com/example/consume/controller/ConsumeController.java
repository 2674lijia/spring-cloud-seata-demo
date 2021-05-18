package com.example.consume.controller;

import com.example.consume.service.IConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/12 18:11
 */
@RestController
@RequestMapping("/consume")
public class ConsumeController {

    @Autowired
    private IConsumeService consumeService;


    @GetMapping("/test")
    String test() {
        return consumeService.test();
    }
}
