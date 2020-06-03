package com.deeaae.of.ants;

import com.deeaae.of.ants.test.DailyTaskTester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AntsApplicationTests {

	@Test
	void contextLoads() {
		DailyTaskTester dailyTaskTester = new DailyTaskTester();
	}

}
