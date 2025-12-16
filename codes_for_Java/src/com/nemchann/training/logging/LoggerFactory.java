package com.nemchann.training.logging;

public abstract class LoggerFactory {
    public abstract Logger createLogger();

    public void processLog(String message){
        Logger logger = createLogger();

        logger.log(message);
    }
}
