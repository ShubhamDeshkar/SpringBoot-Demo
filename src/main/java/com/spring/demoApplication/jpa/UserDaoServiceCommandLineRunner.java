package com.spring.demoApplication.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger("UserDaoServiceCommandLineRunner");

    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... args) throws Exception {
        UserJPA userJPA = new UserJPA("Shubham", "Admin");
        long id = userDAOService.insert(userJPA);
        logger.info("New userJPA created: " + userJPA);
    }
}
