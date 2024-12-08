package fr.lernejo.logger;

public class FilteredLogger implements Logger {
    private final Logger delegate;
    private final String keyword;

    public FilteredLogger(Logger delegate, String keyword) {
        this.delegate = delegate;
        this.keyword = keyword;
    }

    @Override
    public void log(String message) {
        if (message.contains(keyword)) {
            delegate.log(message);
        }
    }
}
