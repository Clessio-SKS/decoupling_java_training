package fr.lernejo.logger;

import java.util.Scanner;

public class ConsoleLogger implements Logger {
  @Override
  public void log(String message){
    System.out.println(message);
  }
}
