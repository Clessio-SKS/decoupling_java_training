package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("computer");
    private long lowerBound = Long.MIN_VALUE;
    private long upperBound = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        long guess = (lowerBound + upperBound) / 2;
        logger.log("Computer guesses: " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            lowerBound = (lowerBound + upperBound) / 2 + 1;
        } else {
            upperBound = (lowerBound + upperBound) / 2 - 1;
        }
        logger.log("Updated bounds: [" + lowerBound + ", " + upperBound + "]");
    }
}
