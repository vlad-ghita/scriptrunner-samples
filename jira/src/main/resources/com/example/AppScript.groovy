package com.example

import org.apache.log4j.Logger

def logger = binding.getVariable("log") as Logger

app = new App(logger)
app.boot()

app.logger.info("Script loaded.")
app.logger.info("Hello script.")
