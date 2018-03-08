package com.shancha.task.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by weiq on 2018/03/08.
 *
 * @author weiq
 */
@Component
public class HelloWorldTask implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("HelloWord");
    }
}
