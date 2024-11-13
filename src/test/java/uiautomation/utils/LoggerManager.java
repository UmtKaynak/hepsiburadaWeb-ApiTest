package uiautomation.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerManager {

    private static final Logger log = Logger.getLogger(LoggerManager.class);

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public void info(String message) {
        String logMessage = ANSI_GREEN + getDateTime() + " [INFO] [" +
                Thread.currentThread().getStackTrace()[2].getClassName() +
                ":" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                ":" + Thread.currentThread().getStackTrace()[2].getLineNumber() +
                "] " + message;
        log.info(logMessage);
    }

    public void error(String message) {
        String logMessage = ANSI_RED + "[ERROR] [" + getDateTime() +
                ":" + Thread.currentThread().getStackTrace()[2].getClassName() +
                ":" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                ":" + Thread.currentThread().getStackTrace()[2].getLineNumber() +
                "] " + message;
        log.error(logMessage);
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
