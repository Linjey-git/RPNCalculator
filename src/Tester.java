import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author _se.ho
 * @create 2024-01-18
 **/

public class Tester {
    private RPNCalculator calculator;


    public static void main(String args[]) {
        System.out.println("This project is done by Serhii Horbonos to AC12001 Lab Practical 2 and Assignment 1 – Stacks and Reverse Polish Notation");
        Tester test = new Tester();
        test.menu();
    }


    /**
     * Display a menu, validate the user's input
     */
    private void menu() {
        String choice;
        boolean exit = false;

        do {
            System.out.println("\n--------------");
            System.out.println("List test Menu");
            System.out.println("S - Start RPN Calculator");
            System.out.println("O - Options");
            System.out.println("Q - quit");

            choice = getString("Please make a choice, and press ENTER: ");

            switch (choice) {
                case "S", "s" -> {
                    this.calculator = new RPNCalculator();
                    this.calculator.calculate();
                }
                case "O", "o" -> {

                    System.out.println("Reverse Polish Notation (RPN) is a way of expressing mathematical expressions where operators come after their operands.\n" +
                            "Using a stack, the expression is evaluated by executing operators from the top of the stack, and results are pushed back\n" +
                            "onto the stack. RPN simplifies calculations as it eliminates the need for parentheses or operator precedence.\n" +
                            "\n" +
                            "Example:\n" +
                            "Standard expression: ( (2 + 3) * 4 )\n" +
                            "RPN equivalent: ( 2,3,+,4,* )\n" +
                            "\n" +
                            "Example of RPN evaluation:\n" +
                            "1. Add 2 and 3: ( (2 + 3) )\n" +
                            "2. Obtain 5 and multiply by 4: ( 5 * 4 = 20 )\n" +
                            "Supported operator: +, -, *, /, ^"
                    );
                }
                case "Q", "q" -> {
                    System.out.println("Goodbye\n");
                    exit = true;
                }
                default -> System.out.println("That is not a valid choice, please try again");
            }
        } while (!exit);
    }


    /**
     * Prompts the user with a message and retrieves a string input.
     *
     * @param userPrompt The message to prompt the user.
     * @return The user's input as a string.
     */
    public String getString(String userPrompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(userPrompt);
        while (!s.hasNext()) {
            s.next();
            System.out.print(userPrompt);
        }

        return s.next();
    }
}
