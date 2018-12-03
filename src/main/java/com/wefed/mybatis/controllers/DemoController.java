package com.wefed.mybatis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wefed.mybatis.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@GetMapping(value = "/test")
	public void test() {
		demoService.test();
	}

}
