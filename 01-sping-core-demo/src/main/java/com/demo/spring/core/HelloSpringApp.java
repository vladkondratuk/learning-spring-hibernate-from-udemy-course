package com.demo.spring.core;

import com.demo.spring.core.core_logic.Coach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static Logger log = LoggerFactory.getLogger(HelloSpringApp.class);

    public static final String CONFIG_LOCATION = "applicationContext.xml";

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        Coach coach = context.getBean("myCoach", Coach.class);

        log.info("DI with constructor -> daily workout: {}", coach.getDailyWorkout());
        log.info("DI with constructor -> daily fortune: {}", coach.getDailyFortune());

        context.close();
    }
}
