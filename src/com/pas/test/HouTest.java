package com.pas.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pas.dao.UserDao;
import com.pas.dao.UserDaoImp;
import com.pas.model.UserModel;
import com.pas.service.UserService;
import com.pas.service.UserServiceImp;

public class HouTest {
	
	private ApplicationContext app;
	private UserDaoImp user;
	private UserServiceImp usi;
	
	@Before
	public void beforea(){
		app = new ClassPathXmlApplicationContext("bean.xml");
		user = (UserDao)app.getBean("user");
		usi = (UserService)app.getBean("se");
	}
	
	@Test
	public void t(){
		System.out.println("Hi!");
		UserModel um = usi.findUser(1);
		System.out.println(um.getU_id());
		System.out.println(um.getUsername());
		
//		UserModel um1=new UserModel();
//		//um1.setU_id(4);
//		um1.setUsername("lisi");
//		um1.setPassword("1464");
//		um1.setStatus(0);
//		um1.setCreate_time(new Date().getTime());
//		user.insertUser(um1);
//		System.out.println(um1.getU_id());
	}
	
}
