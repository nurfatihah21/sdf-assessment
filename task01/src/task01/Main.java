package task01;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

import javax.sound.sampled.SourceDataLine;

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

        Map<String, Integer> count = new HashMap<>();

        while ((line = br.readLine()) != null) {
            lineNoBreaks = line.replaceAll("\n", "");
            lineProcessed = lineNoBreaks.toLowerCase().replaceAll("[.,:!-(){}'/\";]", "");

            System.out.println(lineProcessed);

            String lineSplit[] = lineProcessed.split("[\\W+]");
            for (String w : lineSplit) {
                if (count.containsKey(w)) {
                    count.put(w, 1 + count.get(w));
                } else {
                    count.put(w, 1);
                }
            }

            LinkedHashMap<String, Integer> sortCount = new LinkedHashMap<>();
            count.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortCount.put(x.getKey(), x.getValue()));
            System.out.println(sortCount);
        }

        br.close();

    }

}