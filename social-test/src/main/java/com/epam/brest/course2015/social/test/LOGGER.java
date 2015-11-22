package com.epam.brest.course2015.social.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alexander on 22.11.15.
 */
public class LOGGER {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void LOGGERDO() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        LOGGER.debug("Started test: "
                + elements[2].getClassName()
                + " "
                + elements[2].getMethodName());
    }
}
