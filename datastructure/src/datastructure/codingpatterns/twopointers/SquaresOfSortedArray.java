package datastructure.codingpatterns.twopointers;

import java.util.Arrays;

/**
 * Leetcode link: https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        Arrays.stream(squaresOfSortedArray.sortedSquares(new int[]{-4, -1, 0, 3, 10})).forEach( x -> {
            System.out.print(x+" , ");
        });
        System.out.println("The square of sorted array "+ squaresOfSortedArray.sortedSquares(new int[]{-4, -1, 0, 3, 10}).toString());
    }
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];
            int highestIndex = nums.length-1;
            int startPointer = 0;
            int endPointer = nums.length-1;
            while(startPointer <= endPointer){
                int firstSquare = nums[startPointer] * nums[startPointer];
                int lastSquare = nums[endPointer] * nums[endPointer];
                if(firstSquare > lastSquare){
                    result[highestIndex--] = firstSquare;
                    startPointer++;
                }else{
                    result[highestIndex--] = lastSquare;
                    endPointer--;
                }
            }

            return result;

        }

}
