package datastructure;

//public class LongestPossibleSequence {
//}

import java.util.List;

/**
 * Optimize "fast" Method to act the same as "slow" method but for less than 50 ms
 * Algorithm and what need method to do is explained in comment at the end.
 */
import java.util.*;

public class LongestPossibleSequence {

    public static void main(String[] args) {
        int numN = 50000;

        List<Integer> list = new ArrayList<>(numN);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numN; i++) {
            sb.append((int) (Math.random() * numN)).append(" ");
        }

        String inputString = sb.toString();
        System.out.println("Input: " + inputString.substring(0, 50));

        List<Integer> resultSlow;
        List<Integer> resultFast;
        long startTime = System.currentTimeMillis();
        resultSlow = slow(inputString);
        long endTime = System.currentTimeMillis();
        System.out.println("Max Jumps: " + resultSlow.stream().mapToInt(Integer::intValue).max().orElse(0));
        System.out.println("Jumps: " + resultSlow.subList(0, Math.min(resultSlow.size(), 20)));

        System.out.println("Execution Time: " + (endTime - startTime) + " ms");

        long startTimef = System.currentTimeMillis();
        resultFast = fast(inputString);
        long endTimef = System.currentTimeMillis();


        System.out.println("Max Jumps: " + resultFast.stream().mapToInt(Integer::intValue).max().orElse(0));
        System.out.println("Jumps: " + resultFast.subList(0, Math.min(resultSlow.size(), 20)));

        System.out.println("Execution Time: " + (endTimef - startTimef) + " ms");
        if (!resultSlow.equals(resultFast)) {
            System.out.println("Error!!! Not equal results!");
        }

    }

    static List<Integer> slow(String inputNumbers) {
        String[] numberStrings = inputNumbers.trim().split(" ");
        int numN = numberStrings.length;

        int[] numbers = new int[numN];
        for (int i = 0; i < numN; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        int initialJump = 0;
        int next = 0;

        List<Integer> list = new ArrayList<>(numN);

        int counter = 0;
        int max = Arrays.stream(numbers).max().orElse(0);
        for (int i = 0; i < numN; i++) {
            initialJump = numbers[i];

            // Partial optimization
            if (initialJump == max) {
                list.add(0);
                continue;
            }

            for (int j = i + 1; j < numN; j++) {
                next = numbers[j];
                if (initialJump < next) {
                    counter++;
                    initialJump = next;
                }
            }

            list.add(counter);
            counter = 0;
        }

        return list;
    }

    static List<Integer> fast(String inputNumbers) {
        //1 4 2 6 3 4
        String[] numberStrings = inputNumbers.trim().split(" ");
        int numN = numberStrings.length;

        int[] numbers = new int[numN];
        for (int i = 0; i < numN; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        int max = Arrays.stream(numbers).max().orElse(0);

        List<Integer> list = new ArrayList<>(numN);

        int counter = 0;
        int initialJump = numbers[0];
        for (int i = 1; i < numN; i++) {

            int next = 0;
            while (initialJump < next) {
                counter++;
                initialJump = next;
            }
            next = numbers[i];
            if (initialJump < next) {
                counter++;
                initialJump = next;
            } else if (initialJump == max) {
                list.add(0);
                initialJump = next;
                counter = 0;
            } else {
                list.add(counter);
                initialJump = next;
                counter = 0;
            }
        }

        list.add(counter);

        return list;
    }
}

/**
 * Jumps
 * <p>
 * Given a sequence of elements(numbers), calculate the longest possible sequence of 'jumps' from each number.
 * <p>
 * Each 'jump' must be made according to the following rules:
 * <p>
 * You can only 'jump' on a number that is greater than the current one;
 * You can 'jump' on a number, only if there isn't one with a greater value between;
 * You can 'jump' only from left to right;
 * <p>
 * Input
 * <p>
 * Read from the standard input
 * <p>
 * On the first line, you will find the number N
 * The number of elements
 * On the second line you will find N numbers, separated by a space
 * The elements themselves
 * <p>
 * The input will be correct and in the described format, so there is no need to check it explicitly.
 * Output
 * <p>
 * Print to the standard output
 * <p>
 * On the first line, print the length of the longest sequence of jumps
 * On the second line, print the lengths of the sequences, starting from each element
 * <p>
 * Constraints
 * <p>
 * The N will always be less than 50000
 * <p>
 * Sample Tests
 * Input
 * <p>
 * 1 4 2 6 3 4
 * <p>
 * Output
 * <p>
 * 2 1 1 0 1 0
 * <p>
 * Explanation
 * <p>
 * Element 1:
 * 1 -> 4 -> 6 (2 jumps)
 * Element 2:
 * 4 -> 6 (1 jump)
 * Element 3:
 * 2 -> 6 (1 jump)
 * Element 4:
 * 6 (0 jumps)
 * Element 5:
 * 3 -> 4 (1 jump)
 * Element 6:
 * 4 -> (0 jumps)
 * <p>
 * Input
 * <p>
 * 1 1 1 1 1
 * <p>
 * Output
 * <p>
 * 0 0 0 0 0
 */
