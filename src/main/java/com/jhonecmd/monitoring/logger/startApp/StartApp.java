package com.jhonecmd.monitoring.logger.startApp;

import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jhonecmd.monitoring.logger.utils.AppLogger;

@Component
public class StartApp implements ApplicationRunner {

    private final Logger logger = AppLogger.logger(StartApp.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Running Server!");
    }
}
