package fr.lernejo.logger;

import java.util.List;

public class CompositeLogger implements Logger {
    private final List<Logger> loggers;

    public CompositeLogger(List<Logger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void log(String message) {
        for (Logger logger : loggers) {
            logger.log(message);
        }
    }
}
