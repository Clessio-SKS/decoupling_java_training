package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        logger.log("Please enter your guess:");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("The number is higher!");
        } else {
            logger.log("The number is lower!");
        }
    }
}
