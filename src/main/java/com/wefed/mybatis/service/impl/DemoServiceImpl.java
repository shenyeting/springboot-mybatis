package com.wefed.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wefed.mybatis.dao.UserDao;
import com.wefed.mybatis.entities.User;
import com.wefed.mybatis.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void test() {
		User user = userDao.get(1);
		System.out.println(user.toString());

	}

}
