package com.pas.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pas.dao.UserDao;
import com.pas.dao.UserDaoImp;
import com.pas.model.UserModel;

public class HouTest {
	
	private ApplicationContext app;
	private UserDaoImp user;
	
	@Before
	public void beforea(){
		app = new ClassPathXmlApplicationContext("bean.xml");
		user = (UserDao)app.getBean("user");
	}
	
	@Test
	public void t(){
		System.out.println("Hi!");
		UserModel um = user.findUserByUId(1);
		System.out.println(um.getU_id());
		System.out.println(um.getUsername());
	}
	
}
