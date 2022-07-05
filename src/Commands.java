import java.util.ArrayList;
import java.util.Scanner;

public abstract class Commands {

    private final String name;
    private final String[] commands;
    private final Scanner scanner;
    private String nextCommands;

    public Commands(String name, String[] commands, String nextCommands) {
        this.name = name;
        this.commands = commands;
        this.scanner = new Scanner(System.in);
        this.nextCommands = nextCommands;
    }

    abstract public void run();

    public String getNextCommands() {
        return nextCommands;
    }

    public void setNextCommands(String nextCommands) {
        this.nextCommands = nextCommands;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGreeting() {
        printMessage(String.format("Welcome to the %s commands", name));
    }

    public void printCommands() {
        printCommands(commands);
    }

    public void printCommands(String[] arrayList) {
        for (int i = 0; i < arrayList.length; i++) {
            printMessage((i + 1) + ": " + arrayList[i]);
        }
    }

    public void printCommands(ArrayList<String> arrayList) {
        printCommands(arrayList.toArray(new String[0]));
    }

    public int getIntegerInput(int rangeLimit) {

        boolean isActive = true;
        int input = 0;
        printMessage("Please enter a number between 1 and " + rangeLimit);

        while (isActive) {
            int userInput = scanner.nextInt();

            if (userInput >= 1 && userInput <= rangeLimit) {
                isActive = false;
                input = userInput;
            } else {
                printMessage("Unable to understand input, try again");
            }
        }
        scanner.nextLine();
        return input;
    }

    public int getIntegerInput() {
        return getIntegerInput(commands.length);
    }

}
