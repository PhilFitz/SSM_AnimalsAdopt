package com.adopt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adopt.service.UserService;


@Controller
public class test {

	@Resource 
    private UserService us;
	
	@RequestMapping("/test.do")
	
	public void pt() {
		System.out.println("测试成功！！");
	}
}
