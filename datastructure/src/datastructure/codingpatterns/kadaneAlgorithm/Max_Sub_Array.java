package datastructure.codingpatterns.kadaneAlgorithm;

import java.util.Arrays;

public class Max_Sub_Array {
    public static void main(String[] args) {
        System.out.println("The maximum sub array is "+maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("The maximum sub array using kadane algorithm is "+maxSubArrayUsingKadaneAlgorithm(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("The index of maximum sub array is "+ Arrays.toString(indexOfMaxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})));
    }

    // O(n2)
    //3, 4, -2, 1, -5, 8
    // max = arr[0], curSum = 0;
    private static int maxSubArray(int[] ints) {
        int max = ints[0];
        for(int i  = 0; i< ints.length; i++){
            int currSum = 0;
            for(int j = i ; j < ints.length; j++){
                currSum += ints[j];
                max = Math.max(max, currSum);
            }
        }
        return max;
    }
    // O(n) - Kadane algorithm, if currentsum < 0 then make current sum 0 because it doesn't add any value to the current element;
    //3, 4, -5, 1, -2, 8
    // max = arr[0], curSum = 0;
    private static int maxSubArrayUsingKadaneAlgorithm(int[] ints) {
        int max = ints[0];
        int currSum = 0;
        for(int i  = 0; i< ints.length; i++){
            currSum += ints[i];
            max = Math.max(max, currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return max;
    }
    //Followup questions: rerturn the index of subArray

    private static int[] indexOfMaxSubArray(int[] ints){
        int max = ints[0];
        int currSum = 0;
        int leftIndx = 0, rightIndx = 0;
        int l = 0;
        for(int r  = 0; r< ints.length; r++){
            if(currSum < 0){
                currSum = 0;
                l = r;
            }
            currSum += ints[r];
            if(currSum > max){
                max = currSum;
                rightIndx = r;
                leftIndx = l;
            }
        }
        return new int[]{leftIndx, rightIndx};
    }
}
