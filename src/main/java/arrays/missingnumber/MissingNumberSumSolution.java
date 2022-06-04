package arrays.missingnumber;

public class MissingNumberSumSolution {

    private static final  String debugStr = """
                n + 1 = %d
                (n * (n + 1)) = %d
                (n * (n + 1)) / 2 = %d
                Array sum = %d
                %n
                """;

    public static void main(String[] args) {
        int[] array = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.printf("Result: %s", findMissingNumber(array));
    }

    public static int findMissingNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int n = numbers.length;
        int expectedSum = (n * (n + 1)) / 2;

        int currentSum = 0;
        for (int number : numbers) {
            currentSum += number;
        }
        System.out.printf(debugStr, (n + 1), (n * (n + 1)), (n * (n + 1)) / 2, currentSum);
        return expectedSum - currentSum;
    }
}
