# Reverse Polish Notation (RPN) Calculator

## Project Overview

This project implements a **Reverse Polish Notation (RPN) Calculator** in Java, designed to evaluate mathematical expressions using the postfix notation where operators are placed after their operands. The calculator supports basic arithmetic operations and power calculations.

This project was developed as part of the **AC12001 Lab Practical 2 and Assignment 1 – Stacks and Reverse Polish Notation**.

## Features

- **Input validation**: Ensures that the input is a valid RPN expression.
- **Operations supported**: Addition (`+`), subtraction (`-`), multiplication (`*`), division (`/`), and exponentiation (`^`).
- **Error handling**: Handles invalid input and division by zero gracefully.
- **Infix notation display**: Converts the RPN expression to its equivalent infix notation and displays it alongside the result.

## Project Structure

The project consists of several Java classes, each with a specific role:

1. **RPNCalculator**: Handles the input validation, conversion, and calculation of the RPN expression.
2. **Tester**: Provides a user interface for interacting with the calculator, including a menu with options.
3. **Stack**: A custom stack implementation using a linked list.
4. **List**: Implements a singly linked list for storing the stack elements.
5. **ListNode**: Represents a node in the linked list, holding data and a reference to the next node.

## Usage

1. **Running the Program**:
   - Start the program by running the `Tester` class.
   - The program will display a menu with the following options:
     - `S` - Start the RPN Calculator.
     - `O` - Learn about how RPN works.
     - `Q` - Quit the program.

2. **Entering RPN Expression**:
   - When you choose the option to start the RPN calculator, you will be prompted to enter a mathematical expression in RPN format.
   - Example of RPN input: `2,3,+,4,*`
   - The calculator will display the evaluated result and the corresponding infix expression.

3. **Error Handling**:
   - The program will notify you if the input is invalid or if an error, such as division by zero, occurs.


