package codember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class solutionCHALLENGE_01 {

    public static String decodeMessage(String message) {
        message = message.toLowerCase();

        String[] words = message.split("\\s+");

        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        for (String word : words) {
            word = word.replaceAll("[^a-z]", "");

            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String fileURL = "https://codember.dev/data/message_01.txt";

        try {
            URL url = new URL(fileURL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();

            String result = decodeMessage(content.toString());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}