import wordpuzzle.WordPuzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordPuzzleTest {

    public static void main(String[] args) {
//        testSetupPuzzle();
//        testSetupDictionary();
        testFindWords();
    }

    private static void testSetupPuzzle() {
        WordPuzzle wordPuzzle = new WordPuzzle();

        Map<Integer, Character[]> rows = wordPuzzle.setupPuzzle(new ArrayList<>());

        for (int row = 1; row <= rows.size(); row++) {
            Character[] characters = rows.get(row);
            System.out.println("Character at row: " + characters[row - 1]);
            System.out.println(Arrays.toString(characters));
        }
    }

    private static void testSetupDictionary() {
        WordPuzzle wordPuzzle = new WordPuzzle();

        try {
            List<String> words = wordPuzzle.setupDictionary();
//            for (int i = 0; i < words.size(); i++) {
//                System.out.println(words.get(i));
//            }
            assert !words.isEmpty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testFindWords() {
        WordPuzzle wordPuzzle = new WordPuzzle();

        List<String> foundWords = wordPuzzle.findWords(wordPuzzle.setupPuzzle(new ArrayList<>()));

        foundWords.forEach(System.out::println);
    }
}
