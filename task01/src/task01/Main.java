package task01;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
         * to run java file, enter argument e.g. file name at the end
         */

        Console cons = System.console();
        BufferedReader reader = null;

        // User will input the file name

        String fileName = args[0];
        Path filePath = Paths.get("./files/" + fileName);
        File file = filePath.toFile();

        if (file.exists()) {
            System.out.printf("Opening file >> %s\n", fileName);
        } else {
            System.out.printf("File doesn't exist >> %s\n", fileName);
        }

    }

}