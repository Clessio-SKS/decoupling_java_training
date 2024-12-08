package fr.lernejo.logger;

import java.util.List;

public class LoggerFactory {
    public static Logger createCompositeLogger(List<Logger> loggers) {
        return new CompositeLogger(loggers);
    }

    public static Logger createFilteredLogger(Logger logger, String keyword) {
        return new FilteredLogger(logger, keyword);
    }
}
