package com.shancha.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShanchaTaskServiceApplicationTests {

	@Test
	public void contextLoads() {
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
    }

}
