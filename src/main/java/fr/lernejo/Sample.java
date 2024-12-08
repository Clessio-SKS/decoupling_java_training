package fr.lernejo;

public class Sample {
    public enum Operation {
        ADD, MULTIPLY
    }

    public int op(Operation operation, int a, int b) {
        return switch (operation) {
            case ADD -> a + b;
            case MULTIPLY -> a * b;
        };
    }
}

