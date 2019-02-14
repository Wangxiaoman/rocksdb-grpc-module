package com.wxm.log;


import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonLogger {
    private static Logger infoLog = LoggerFactory.getLogger("info");
    private static Logger warnLog = LoggerFactory.getLogger("warn");
    private static Logger errorLog = LoggerFactory.getLogger("error");
    private static Logger actionLog = LoggerFactory.getLogger("actionLogger");
    private static Logger urlLog = LoggerFactory.getLogger("urlPostLogger");
    private static Logger plugLog = LoggerFactory.getLogger("plugLogger");
    private static Logger activateLog = LoggerFactory.getLogger("activateLogger");
    
    public static void info(String msg) {
    	infoLog.info(msg);
    }
    
    public static void info(String format, Object... arguments){
        infoLog.info(format, arguments);
    }
    
    public static void infoOneInThousand(String msg) {
    	if(RandomUtils.nextInt(0, 10000) < 10){
			infoLog.info("1/1000 info sampling," + msg);
    	}
    }
    
    public static void infoOneInThousand(String format, Object... arguments) {
        if(RandomUtils.nextInt(0, 10000) < 10){
            infoLog.info("1/1000 info sampling," + format, arguments);
        }
    }
    
    public static void warn(String msg) {
    	warnLog.warn(msg);
    }
    
    public static void warn(String format, Object... arguments){
        warnLog.warn(format, arguments);
    }
    
    public static void warnOneInThousand(String msg) {
    	if(RandomUtils.nextInt(0, 10000) < 10){
    		warnLog.warn("1/1000 warn sampling," +msg);
    	}
    }
    
    public static void errorOneInThousand(String msg,Throwable t) {
    	if(RandomUtils.nextInt(0, 10000) < 10){
			errorLog.error("1/1000 error sampling," + msg, t);
    	}
    }
    
    public static void error(String msg,Throwable t) {
    	errorLog.error(msg,t);
    }
    
    public static void error(String msg) {
        errorLog.error(msg);
    }
    
    public static void error(String format, Object... arguments){
        errorLog.error(format, arguments);
    }
    
    public static void action(String msg) {
    	actionLog.info(msg);
    }
    
    public static void action(String format, Object... arguments){
        actionLog.info(format, arguments);
    }

    public static void urlLog(String msg) {
    	urlLog.info(msg);
    }
    
    public static void urlLog(String format, Object... arguments){
        urlLog.info(format, arguments);
    }
    
    public static void plugLog(String msg){
        plugLog.info(msg);
    }
    public static void plugLog(String format, Object... arguments){
        plugLog.info(format, arguments);
    }

    public static void activate(String msg){
        activateLog.info(msg);
    }
    public static void activate(String format, Object... arguments){
        activateLog.info(format, arguments);
    }
}
