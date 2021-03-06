package com.example.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.locks.ReentrantLock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@ComponentScan("com.example.demo.*")
public class Demo1Application {

	public static void main(String[] args) {
		System.out.println("---------------------") ;
		SpringApplication.run(Demo1Application.class, args);
	}

}
