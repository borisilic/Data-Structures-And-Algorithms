package wordpuzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPuzzle {


    public void findWords(Map<Integer, Character[]> puzzle) {
        List<String> words;
        try {
            words = setupWords();
        } catch (IOException e) {
            System.out.println("Probably could not find the words text file");
            System.out.println("The exception is: " + e);
        }



    }


    public List<String> setupWords() throws IOException {
        FileReader fileReader = new FileReader("words.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        List<String> words = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line);
        }

        return words;
    }

    public Map<Integer, Character[]> setupPuzzle(List<Character[]> lines) {
        Map<Integer, Character[]> rows = new HashMap<>();

        if (!lines.isEmpty()) {
            for (int i = 1; i <= lines.size(); i++) {
                rows.put(i, lines.get(i));
            }
        } else {
            Character[] line1 = {'t', 'h', 'i', 's'};
            Character[] line2 = {'w', 'a', 't', 's'};
            Character[] line3 = {'o', 'a', 'h', 'g'};
            Character[] line4 = {'f', 'g', 'd', 't'};

            rows.put(1, line1);
            rows.put(2, line2);
            rows.put(3, line3);
            rows.put(4, line4);
        }
        return rows;
    }
}
