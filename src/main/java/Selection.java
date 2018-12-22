import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static java.lang.Math.random;

public class Selection {

    int findElementInList(Integer[] numbers, int kthLargestElement) {
        sort(numbers);

        return numbers[kthLargestElement - 1];
    }

    void sort(Integer[] list) {
        int length = list.length;
        boolean noSwaps = true;
        for(int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if(list[j-1] > list[j]) {
                    int temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    noSwaps = false;
                }
            }
            if(noSwaps) {
                break;
            }
            noSwaps = true;
        }
    }

    public static void runSelectionProblem() {
        Map<Integer, Long> algorithmRunningTimes = new HashMap<>();

        List<Integer> keysForMap = new ArrayList<>();
        int numberOfElements;

        for(int k = 10; k < 10000; k = k + 100) {
            numberOfElements = k;
            Integer[] numbers = new Integer[numberOfElements];
            keysForMap.add(numberOfElements);

            for (int i = 0; i < numberOfElements; i++) {
                numbers[i] = (int) (random() * 100);
            }

            Selection selection = new Selection();

            long startTime = System.currentTimeMillis();
            selection.findElementInList(numbers, numberOfElements - numberOfElements / 30);
            long endTime = System.currentTimeMillis();

            long timeTaken = endTime - startTime;

            algorithmRunningTimes.put(numberOfElements, timeTaken);
        }

        System.out.println("Number of Elements  ||  Time Taken");
        System.out.println("==================================");
        for (int key : keysForMap) {
            System.out.println("        " + key + "              " + algorithmRunningTimes.get(key));
        }

        Collections.reverse(keysForMap);

        for (int key : keysForMap) {
            System.out.print(algorithmRunningTimes.get(key));
            System.out.print(StringUtils.repeat(" ", Math.toIntExact(algorithmRunningTimes.get(key))));
            System.out.println(".");
        }
        Collections.reverse(keysForMap);

        for (int key : keysForMap) {
            System.out.print(key/100 + " ");
        }
    }
}
