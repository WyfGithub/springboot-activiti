package com.springactiviti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述 :
 *
 * @author wangyf
 * @create 2018/10/31
 */
@RestController
public class RedirectController {
    @RequestMapping("/redirectTest")
    public ModelAndView redirectTest(){

        return new ModelAndView("activiti/test");
    }
}
