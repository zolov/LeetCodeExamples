package arrays.missingnumber;

import java.util.Arrays;

public class MissingNumberBinarySearchSolution {
    public static void main(String[] args) {
        int[] array = {9, 6, 4, 2, 3, 5, 7, 0, 1, 11, 12, 13, 14, 15};
        System.out.printf("Result: [%s]", findMissingNumber(array));
    }

    private static int findMissingNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int left = 0;
        int mid;
        int right = numbers.length;
        while (left < right) {
            System.out.printf("calculate mid (left(%d) + right(%d)) / 2 = %d %n", left, right, (left + right) / 2);
            mid = (left + right) / 2;
            System.out.printf("which number is greater? array[mid](%d) or mid(%d) %n", numbers[mid], mid);
            if (numbers[mid] > mid) {
                System.out.printf("shift right(%d) to mid(%d) %n", right, mid);
                right = mid;
            } else {
                System.out.printf("shift left(%d) to mid(%d) + 1 %n", left, mid);
                left = mid + 1;
            }
        }
        return left;
    }
}
