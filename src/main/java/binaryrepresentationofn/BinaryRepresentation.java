package binaryrepresentationofn;

public class BinaryRepresentation {

    public static int numberOfOnes(int number) {
        if (number % 2 != 0) {
            return numberOfOnes(number/2) + 1;
        }

        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        } else if (number == 2) {
            return 1;
        } else if (number == 3) {
            return 2;
        } else {
            return numberOfOnes(number / 2);
        }
    }
}
