package com.jhonecmd.monitoring.logger.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AppLogger {

    private AppLogger() {

    }

    public static Logger logger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}