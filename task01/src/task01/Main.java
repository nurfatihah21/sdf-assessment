package task01;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;

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

        // Reading the file's content & processing

        FileReader fr = new FileReader(fileToRead);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String lineNoBreaks = "";
        String lineProcessed = "";
        int wordCount = 0;

        // Storing the words and count, and for sorting
        Map<String, Integer> count = new HashMap<>();
        LinkedHashMap<String, Integer> sortCount2 = new LinkedHashMap<>();

        while ((line = br.readLine()) != null) {

            // remove punctuations and breaks
            lineNoBreaks = line.replaceAll("\n", "");
            lineProcessed = lineNoBreaks.toLowerCase().replaceAll("[.,:!-(){}'/\";]", "");

            // splitting each word and adding unique words into map
            String lineSplit[] = lineProcessed.split("[\\W+]");
            for (String w : lineSplit) {
                if (count.containsKey(w)) {
                    count.put(w, 1 + count.get(w));
                } else {
                    count.put(w, 1);
                }
            }
            wordCount += lineSplit.length;

        }

        // Converting the HashMap into a List & sorting

        ArrayList<Map.Entry<String, Integer>> sortCount = new ArrayList<>(count.entrySet());

        sortCount.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> x : sortCount) {
            System.out.println(x.getKey() + " - " + x.getValue());
        }

        System.out.println(sortCount);
        System.out.println("Total word count in file: " + wordCount);

        br.close();

    }

}