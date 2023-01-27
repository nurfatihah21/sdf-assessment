package task02;

import java.io.Console;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        Console cons = System.console();
        double result;
        boolean exit = false;
        DecimalFormat df = new DecimalFormat("0.#");

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

            if ((userInput.contains("+") || userInput.contains("-") || userInput.contains("*")
                    || userInput.contains("/"))) {

                String[] parameters = userInput.split(" ");
                double num1 = Double.parseDouble(parameters[0]);
                char operator = parameters[1].charAt(0);
                double num2 = Double.parseDouble(parameters[2]);

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        System.out.println(df.format(result));
                        break;
                    case '-':
                        result = num1 - num2;
                        System.out.println(df.format(result));
                        break;
                    case '*':
                        result = num1 * num2;
                        System.out.println(df.format(result));
                        break;
                    case '/':
                        result = num1 / num2;
                        System.out.println(df.format(result));
                        break;

                }

            } else {
                System.out.println("You have entered an invalid statement.");
            }
        }
    }
}
