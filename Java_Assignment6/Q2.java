package Java_Assignment6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Q2 {

    public static void main(String[] args) {
        if (args.length != 0 && args.length != 2) {
            System.err.println("Usage: java Java_Assignment6.Q2 [input-log-file filtered-output-file]");
            return;
        }

        String inputFile = args.length == 2 ? args[0] : "application.log";
        String outputFile = args.length == 2 ? args[1] : "filtered_logs.txt";

        try {
            analyzeLog(inputFile, outputFile);
        } catch (IOException e) {
            System.err.println("Could not analyze the log file: " + e.getMessage());
        }
    }

    private static void analyzeLog(String inputFile, String outputFile) throws IOException {
        int totalEntries = 0;
        int errorEntries = 0;
        int warningEntries = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalEntries++;
                String normalizedLine = line.toUpperCase(Locale.ROOT);
                boolean containsError = normalizedLine.contains("ERROR");
                boolean containsWarning = normalizedLine.contains("WARNING");

                if (containsError || containsWarning) {
                    writer.write(line);
                    writer.newLine();
                }
                if (containsError) {
                    errorEntries++;
                }
                if (containsWarning) {
                    warningEntries++;
                }
            }
        }

        System.out.println("Total log entries: " + totalEntries);
        System.out.println("Entries containing ERROR: " + errorEntries);
        System.out.println("Entries containing WARNING: " + warningEntries);
        System.out.println("Filtered entries saved to " + outputFile + ".");
    }
}
