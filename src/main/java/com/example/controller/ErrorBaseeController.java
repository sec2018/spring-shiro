package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "error")
public class ErrorBaseeController implements ErrorController {
 
    private static final Logger log = LoggerFactory.getLogger(ErrorBaseeController.class);
    @Override
    public String getErrorPath() {
        log.info("出错了进入自定义错误控制器");
        return "error/error-404";
    }
 
    @RequestMapping
    public String error(){
        return getErrorPath();
    }
 
}