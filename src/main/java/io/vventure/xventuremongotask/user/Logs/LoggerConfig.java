package io.vventure.xventuremongotask.user.Logs;

import io.vventure.xventuremongotask.user.Controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean
    public Logger getLogger(){
        return LoggerFactory.getLogger(UserController.class);
    }
}
