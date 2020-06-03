package com.deeaae.of.ants;

import com.deeaae.of.ants.core.Task;
import com.deeaae.of.ants.test.DailyTaskTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AntsApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AntsApplication.class, args);
	}

}
