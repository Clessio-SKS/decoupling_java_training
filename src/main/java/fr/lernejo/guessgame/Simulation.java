package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("Correct!");
            return true;
        }
        if (guess < numberToGuess) {
            logger.log("The number is greater!");
            player.respond(true);
        } else {
            logger.log("The number is lower!");
            player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        long startTime = System.currentTimeMillis();
        boolean success = false;
        int iterations = 0;

        while (iterations < maxIterations && !success) {
            success = nextRound();
            iterations++;
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        String timeTaken = String.format("%02d:%02d.%03d",
            (duration / 60000) % 60,
            (duration / 1000) % 60,
            duration % 1000);

        if (success) {
            logger.log("You won in " + iterations + " iterations! Time taken: " + timeTaken);
        } else {
            logger.log("Game over! Player did not guess the number within the limit. Time taken: " + timeTaken);
        }
    }
}
