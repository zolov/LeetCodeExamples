package arrays.missingnumber;

public class MissingNumberXorSolution {
    public static void main(String[] args) {
        int[] array = {9, 6, 4, 2, 3, 5, 7, 0, 1, 10, 11, 12, 13};
        System.out.printf("Result: [%s] %n", findMissingNumber(array));
    }

    private static int findMissingNumber(int[] numbers) {
        int result = numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("res(%d) XOR i(%d) = %d %n", result, i, result ^ i);
            result ^= i;
            System.out.printf("res(%d) XOR nums[i](%d) = %d %n", result, numbers[i], result ^ numbers[i]);
            result ^= numbers[i];
        }

        return result;
    }
}
