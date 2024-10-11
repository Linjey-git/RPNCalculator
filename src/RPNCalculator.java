import java.util.Scanner;


/**
 * @Author _se.ho
 * @create 2024-01-25
 **/

public class RPNCalculator {

    String[] RPN;

    Stack stack;
    Stack infix;

    /**
     * Constructs a new instance of the Reverse Polish Notation (RPN) Calculator.
     * Initializes the RPN expression using input validation and creates an empty stack.
     */
    public RPNCalculator() {
        this.RPN = inputValidation();
        this.stack = new Stack();
        this.infix = new Stack();
    }

    /**
     * Calculates the result of the mathematical expression in Reverse Polish Notation (RPN) using a stack.
     * Prints the result and the infix notation or an error message if division by zero occurs.
     *
     * @throws ArithmeticException if division by zero is encountered during the calculation.
     */
    public void calculate() {
        boolean divByZero = false;

        for (String value : this.RPN) {
            try {
                if (isNumeric(value)) {
                    this.stack.push(value);
                    this.infix.push(value);
                } else {
                    String top = this.stack.pop();
                    if (Double.parseDouble(top) != 0) {
                        this.stack.push(top);
                        this.stack.push(applyOperation(value));
                        String operand1 = this.infix.pop();
                        String operand2 = this.infix.pop();
                        this.infix.push("(" + operand2 + value + operand1 + ")");
                    } else {
                        divByZero = true;
                    }
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                return; // Stop calculation if division by zero occurs
            }
        }

        if (!divByZero) {
            String initialRPN = String.join(",", this.RPN);
            System.out.println(initialRPN + " = " + this.infix.pop() + " = " + this.stack.pop());
        } else {
            System.out.println("Cannot divide by zero.");
            String operand1 = this.infix.pop();
            String operand2 = this.infix.pop();
            System.out.println("(" + operand2 + "/" + operand1 + ") = null = ø");
        }
    }


    /**
     * Applies the specified mathematical operation on the top two elements of the stack.
     *
     * @param operator The operator to be applied (+, -, *, /, ^).
     * @return The result of the operation.
     * @throws IllegalArgumentException if an invalid operator is provided.
     */
    private String applyOperation(String operator) {
        double operand1 = Double.parseDouble(this.stack.pop());
        double operand2 = Double.parseDouble(this.stack.pop());

        switch (operator) {
            case "+":
                double sum = operand2 + operand1;
                return String.valueOf(sum);
            case "-":
                double delta = operand2 - operand1;
                return String.valueOf(delta);
            case "*":
                double product = operand2 * operand1;
                return String.valueOf(product);
            case "/":
                double quotient = operand2 / operand1;
                return String.valueOf(quotient);
            case "^":
                double powerOutcome = Math.pow(operand2, operand1);
                return String.valueOf(powerOutcome);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /**
     * Validates and retrieves user input for a mathematical problem in Reverse Polish Notation (RPN).
     *
     * @return An array representing the valid RPN input.
     * @throws IllegalArgumentException if the input length is less than or equal to 2, or if the input format is invalid.
     */
    private String[] inputValidation() {
        String[] rpn;

        while (true) {
            try {
                rpn = getString("Enter the problem: ").split(",");

                if (rpn.length <= 2) {
                    throw new IllegalArgumentException("Invalid input. The input should be at least 3 values long.");
                }

                if (!(is1n2Digit(rpn) && endsWithOperator(rpn) && hasNoChars(rpn) && isDigitsMoreThanOperators(rpn))) {
                    throw new IllegalArgumentException("Invalid input. Please check the input format.");
                }

                break; // Exit the loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        return rpn;
    }


    /**
     * Prompts the user with a message and retrieves a string input.
     *
     * @param userPrompt The message to prompt the user.
     * @return The user's input as a string.
     */
    public String getString(String userPrompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(userPrompt);

        while (!scanner.hasNext()) {
            scanner.next();
            System.out.print(userPrompt);
        }

        return scanner.next();
    }

    /**
     * Validates if the first two symbols in the RPN array are numeric digits.
     *
     * @param rpn The array representing the RPN input.
     * @return True if 1st & 2nd values of the expression are digits, false otherwise.
     * @throws IllegalArgumentException if the first two symbols are not numeric digits.
     */
    private boolean is1n2Digit(String[] rpn) {
        try {
            if (!isNumeric(rpn[0]) || !isNumeric(rpn[1])) {
                throw new IllegalArgumentException("Invalid input. The first two symbols should be digits.");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the RPN expression ends with an operator.
     *
     * @param rpn The array representing the RPN input.
     * @return True if the expression ends with an operator, false otherwise.
     * @throws IllegalArgumentException if the expression does not end with an operator.
     */
    private boolean endsWithOperator(String[] rpn) {
        try {
            String lastValue = rpn[rpn.length - 1];

            if (!isOperator(lastValue)) {
                throw new IllegalArgumentException("Invalid input. The expression should end with an operator.");
            }

            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the number of numeric digits in the RPN expression is one more than the number of operators.
     *
     * @param rpn The array representing the RPN input.
     * @return True if the condition is met, false otherwise.
     * @throws IllegalArgumentException if the number of operands is not one more than the number of operators.
     */
    private boolean isDigitsMoreThanOperators(String[] rpn) {
        try {
            int digitsCount = 0;
            int operatorsCount = 0;

            for (String value : rpn) {
                if (isNumeric(value)) {
                    digitsCount++;
                } else if (isOperator(value)) {
                    operatorsCount++;
                }
            }

            if (digitsCount != operatorsCount + 1) {
                throw new IllegalArgumentException("Invalid input. Number of operands should be one more than the number of operators.");
            }

            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the RPN expression contains only numeric digits and operators.
     *
     * @param rpn The array representing the RPN input.
     * @return True if the expression contains only digits and operators, false otherwise.
     * @throws IllegalArgumentException if the expression contains characters other than digits or operators.
     */
    private boolean hasNoChars(String[] rpn) {
        try {
            for (String value : rpn) {
                if (!(isNumeric(value) || isOperator(value))) {
                    throw new IllegalArgumentException("Invalid input. The expression should contain only digits or operators.");
                }
            }

            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Checks if the given string represents a numeric value.
     *
     * @param symbol The string to be checked.
     * @return True if the string is numeric, false otherwise.
     */
    public boolean isNumeric(String symbol) {
        try {
            Double.parseDouble(symbol);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if the given string represents a valid mathematical operator.
     *
     * @param symbol The string to be checked.
     * @return True if the string is a valid operator (+, -, *, /, ^), false otherwise.
     */
    private boolean isOperator(String symbol) {
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/") || symbol.equals("^");
    }
}
