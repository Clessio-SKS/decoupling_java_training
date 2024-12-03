package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("launcher");

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        if (args[0].equals("-interactive")) {
            HumanPlayer player = new HumanPlayer();
            Simulation simulation = new Simulation(player);

            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100); // Nombre aléatoire entre 0 et 99
            simulation.initialize(randomNumber);

            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

        } else if (args[0].equals("-auto") && args.length > 1) {
            try {
                long targetNumber = Long.parseLong(args[1]);
                ComputerPlayer player = new ComputerPlayer();
                Simulation simulation = new Simulation(player);

                simulation.initialize(targetNumber);

                simulation.loopUntilPlayerSucceed(1000); // Limite de 1000 itérations

            } catch (NumberFormatException e) {
                logger.log("Invalid number format for the target number: " + args[1]);
                printUsage();
            }
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  -interactive : Play interactively with a human player.");
        System.out.println("  -auto <number> : Play automatically with a computer player. <number> is the target number.");
    }
}
