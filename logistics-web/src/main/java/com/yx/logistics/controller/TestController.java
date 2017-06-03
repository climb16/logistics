package com.yx.logistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * author : Guo LiXiao
 * date : 2017-5-31  17:55
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test(){
        System.out.println("hahahahh");
        return "index";
    }
}
