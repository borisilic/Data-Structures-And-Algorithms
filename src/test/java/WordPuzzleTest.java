import wordpuzzle.WordPuzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordPuzzleTest {

    public static void main(String[] args) {
//        testSetupPuzzle();
        testSetupWords();
    }

    public static void testSetupPuzzle() {
        WordPuzzle wordPuzzle = new WordPuzzle();

        Map<Integer, Character[]> rows = wordPuzzle.setupPuzzle(new ArrayList<>());

        for (int i = 1; i <= rows.size(); i++) {
            Character[] characters = rows.get(i);
            System.out.println("Character at i: " + characters[i]);
            System.out.println(Arrays.toString(characters));
        }
    }

    public static void testSetupWords() {
        WordPuzzle wordPuzzle = new WordPuzzle();

        try {
            List<String> words = wordPuzzle.setupWords();
            assert !words.isEmpty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
