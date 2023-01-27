package task01;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
         * to run java file, enter argument e.g. file name at the end
         */

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
        double termFreq = 0d;

        // Storing the words and count, and for sorting
        Map<String, Double> count = new HashMap<>();

        while ((line = br.readLine()) != null) {

            // remove punctuations and breaks
            lineNoBreaks = line.replaceAll("\n", "");
            lineProcessed = lineNoBreaks.toLowerCase().replaceAll("[.,:!-(){}'/\";]", "");

            // splitting each word and adding unique words into map
            String lineSplit[] = lineProcessed.split("[\\W+]");

            // total word count in file
            wordCount += lineSplit.length;

            // add each unique word into map
            for (String w : lineSplit) {
                if (count.containsKey(w)) {
                    count.put(w, (1) + count.get(w));
                } else {
                    count.put(w, (double) (1));
                }
            }

        }
        int finalwordcount = wordCount;
        System.out.println("Total word count in file: " + finalwordcount);

        // Term Frequency - Replace Value in Map
        count.replaceAll((key, value) -> value / finalwordcount);

        // Converting the HashMap into a List & sorting descending

        ArrayList<Map.Entry<String, Double>> sortCount = new ArrayList<>(count.entrySet());

        sortCount.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // print top 10 freq
        sortCount = new ArrayList<>(sortCount.subList(0, 9));
        System.out.println("\nThe 10 most frequent words and its term frequencies are:");
        System.out.println(sortCount);

        br.close();

    }

}