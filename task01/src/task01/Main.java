package task01;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
         * to run java file, enter argument e.g. file name at the end
         */

        Console cons = System.console();

        // User will input the file name
        // If file exists, print out 'opening'
        // If doesn't exist, print out 'doesnt exist'

        String fileName = args[0];
        Path filePath = Paths.get("./files/" + fileName);
        File fileToRead = filePath.toFile();

        if (fileToRead.exists()) {
            System.out.printf("Opening file >> %s\n", fileName);
        } else {
            System.out.printf("File doesn't exist >> %s\n", fileName);
        }

        // Reading the file's content

        FileReader fr = new FileReader(fileToRead);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String lineProcessed = "";

        while ((line = br.readLine()) != null) {
            lineProcessed = line.toLowerCase().replaceAll("[.,:!-(){}'/\";]", "");
            System.out.println(lineProcessed);
        }
        br.close();

    }

}