package wordpuzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPuzzle {
    private List<String> dictionary = new ArrayList<>();

    public WordPuzzle() {
        try {
            this.dictionary = setupDictionary();
        } catch (IOException e) {
            System.out.println("Probably could not find the dictionary text file.");
            System.out.println("The exception is: " + e);
        }
    }

    @SuppressWarnings("Duplicates")
    public List<String> findWords(Map<Integer, Character[]> puzzle) {
        List<String> foundWords = new ArrayList<>();

        // Check by row left to right
        for (int i = 1; i <= puzzle.size(); i++) {
            Character[] row = puzzle.get(i);
            StringBuilder word = new StringBuilder();
            for (Character character : row) {
                addFoundWordToDictionary(foundWords, word, character);
            }
        }

        // Check by column top to bottom
        for (int j = 0; j < 4; j++) {
            StringBuilder word = new StringBuilder();

            for (int i = 1; i <= puzzle.size(); i++) {
                Character[] row = puzzle.get(i);
                addFoundWordToDictionary(foundWords, word, row[j]);
            }
        }

        // Check by row right to left
        for (int i = 1; i <= puzzle.size(); i++) {
            Character[] row = puzzle.get(i);
            StringBuilder word = new StringBuilder();
            for (int j = row.length - 1; j >= 0; j--) {
                Character character = row[j];
                addFoundWordToDictionary(foundWords, word, character);
            }
        }

        // Check by column bottom to top
        for (int j = 0; j < 4; j++) {
            StringBuilder word = new StringBuilder();
            for (int i = puzzle.size(); i > 0; i--) {
                Character[] row = puzzle.get(i);
                addFoundWordToDictionary(foundWords, word, row[j]);
            }
        }

        return foundWords;
    }

    private void addFoundWordToDictionary(List<String> foundWords, StringBuilder word, Character letter) {
        word.append(letter);
        if (dictionary.contains(word.toString()) && word.length() > 1) {
            foundWords.add(word.toString());
        }
    }


    public List<String> setupDictionary() throws IOException {
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
            Character[] line2 = {'w', 'a', 't', 'n'};
            Character[] line3 = {'o', 'a', 'h', 'e'};
            Character[] line4 = {'f', 'g', 'd', 't'};

            rows.put(1, line1);
            rows.put(2, line2);
            rows.put(3, line3);
            rows.put(4, line4);
        }
        return rows;
    }
}
