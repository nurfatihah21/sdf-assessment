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

        // Storing the words and count, and for sorting
        // Map<String, Integer> count = new HashMap<>();
        // LinkedHashMap<String, Integer> sortCount = new LinkedHashMap<>();

        while ((line = br.readLine()) != null) {

            // remove punctuations and breaks
            lineNoBreaks = line.replaceAll("\n", "");
            lineProcessed = lineNoBreaks.toLowerCase().replaceAll("[.,:!-(){}'/\";]", "");

            // System.out.println(lineProcessed);

            // splitting each word and adding unique words into map
            String lineSplit[] = lineProcessed.split("[\\W+]");

            Map<String, Integer> count = new HashMap<>();

            for (String w : lineSplit) {
                if (count.containsKey(w)) {
                    count.put(w, 1 + count.get(w));
                } else {
                    count.put(w, 1);
                }
            }

            // List<Integer> sortCount = new ArrayList<Integer>(count.values());

            // Collections.sort(sortCount, Collections.reverseOrder());
            // sortCount.sort(Comparator.reverseOrder());

            Set<Map.Entry<String, Integer>> s = count.entrySet();

            for (Map.Entry<String, Integer> x : s) {
                System.out.println(x.getKey() + " - " + x.getValue());
            }
        }

        // System.out.println(sortCount);

        br.close();

    }

}