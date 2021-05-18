package com.example.provide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/12 18:11
 */
@RestController
@RequestMapping("/provide")
public class ProvideController {


    @GetMapping("/test")
    String test() {
        return "this is provide";
    }
}
