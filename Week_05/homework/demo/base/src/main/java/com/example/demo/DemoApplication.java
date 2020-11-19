package com.example.demo;

import com.example.demo.core.School;
import com.example.demo.jdbc.DataBaseUtil;
import com.example.demo.jdbc.User;
import com.example.demo.jdbc.UserDao;
import com.example.demo.spring.loadbean.annotationconfig.Car2;
import com.example.demo.spring.loadbean.beanconfig.Car;
import com.example.demo.spring.loadbean.xmlconfig.Car3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ImportResource("application2.xml")
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private Car car;

	@Autowired
	private Car2 car2;

	@Autowired
	private School school;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		// beanConfig 方式装载 com.example.demo.spring.loadbean.beanconfig
		System.out.println(car);
		// annotationconfig 方式装载  com.example.demo.spring.loadbean.annotationconfig
		System.out.println(car2);
		// xmlconfig 方式装载  com.example.demo.spring.loadbean.xmlconfig
		Car3 car3 = applicationContext.getBean(Car3.class);
		System.out.println(car3);

		// autoconfig 与 stater
		System.out.println(school);

		// jdbc
        User user = new User();
		user.setName("王小二");
		user.setAge(18);
		user.setId(1);
		userDao.insert(user);

		user.setId(1);
		user.setAge(19);
		userDao.updateStatement(user);

		User result = userDao.selectById(1);
		System.out.println(result);

		List<User> users = new ArrayList<>();
		for(int i= 0 ; i < 10 ; i++ ){
			User item = new User();
			item.setName("王小二" + i);
			item.setAge(i);
			users.add(item);
		}

		userDao.batchInsert(users);

		int count = userDao.count();

		System.out.println(count);

	}
}
