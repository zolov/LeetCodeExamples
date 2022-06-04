package arrays.containsduplicate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicatesSolution {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 4, 5, 6};
        System.out.printf("%n Result: %s %n", containsDuplicate(array));
    }

    public static boolean containsDuplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;

        Set<Integer> unique = new HashSet<>();

        for (Integer it : numbers) {
            if (!unique.add(it)) return true;
        }
        return false;
    }
}
