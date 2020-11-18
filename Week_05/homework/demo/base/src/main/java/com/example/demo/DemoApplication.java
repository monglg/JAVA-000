package com.example.demo;

import com.example.demo.core.School;
import com.example.demo.core.Student;
import com.example.demo.spring.loadbean.annotationconfig.Car2;
import com.example.demo.spring.loadbean.beanconfig.Car;
import com.example.demo.spring.loadbean.xmlconfig.Car3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

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


	}
}
