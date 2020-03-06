package com.example

import org.apache.log4j.Level

import javax.annotation.Nullable
import org.apache.log4j.Logger

class App {

    Logger logger

    App(@Nullable Logger logger) {
        setLogger(logger)
    }

    void setLogger(@Nullable Logger logger) {
        this.logger = logger ?: Logger.getLogger("com.example")
        this.logger.setLevel(Level.TRACE)
    }

    void boot() {
        logger.info("App started.")
//        logger.info("Hello app.")
    }

}
