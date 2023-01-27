package task02;

import java.io.Console;
import java.text.DecimalFormat;

public class Main {

    static double num1;
    static double num2;
    static char operator;
    static double result;
    static double $last;
    static DecimalFormat df = new DecimalFormat("0.#");

    public static void calculate() {
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println(df.format(result));
                $last = result;
                break;
            case '-':
                result = num1 - num2;
                System.out.println(df.format(result));
                $last = result;
                break;
            case '*':
                result = num1 * num2;
                System.out.println(df.format(result));
                $last = result;
                break;
            case '/':
                result = num1 / num2;
                System.out.println(df.format(result));
                $last = result;
                break;

        }
    }

    public static void main(String[] args) {

        Console cons = System.console();
        boolean exit = false;
        System.out.println("Welcome.");

        while (!exit) {

            String userInput = cons.readLine(">");

            // when user decides to exit
            if (userInput.contains("exit")) {
                exit = true;
                System.out.println("Bye bye");
                System.exit(1);
            } else

            // if input meets format requirement
            // split by spaces

            if (((userInput.contains("+") || userInput.contains("-") || userInput.contains("*")
                    || userInput.contains("/")))) {

                String[] parameters = userInput.split(" ");

                /*
                 * if user input $last first, give num1 value of $last
                 * if user input $last last, give num2 value of $last
                 * if $last not input, set num1 & num2 as per numbers entered
                 */

                if (parameters[0].equals("$last")) {
                    num1 = $last;
                } else {
                    num1 = Double.parseDouble(parameters[0]);
                }

                operator = parameters[1].charAt(0);
                if (parameters[2].equals("$last")) {
                    num2 = $last;
                } else {
                    num2 = Double.parseDouble(parameters[2]);
                }

                calculate();

            } else {
                System.out.println("You have entered an invalid statement.");
            }
        }
    }
}
