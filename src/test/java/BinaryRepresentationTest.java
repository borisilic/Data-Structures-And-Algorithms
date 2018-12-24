import binaryrepresentationofn.BinaryRepresentation;

public class BinaryRepresentationTest {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        int number = 1500000000;
        int numberOfOnes = BinaryRepresentation.numberOfOnes(number);
        long timeEnd = System.currentTimeMillis();
        System.out.println("The number of ones in " + number + " is: " + numberOfOnes);
        long timeTaken = timeEnd - timeStart;
        System.out.println("Time taken: " + timeTaken);
    }
}
