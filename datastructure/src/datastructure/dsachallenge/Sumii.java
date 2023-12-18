package datastructure.dsachallenge;

import java.util.Arrays;

public class Sumii {
    public static void main(String[] args) {
        int[] input = new int[]{1,5,2,3,6,-1,-2};
        int target = 6;
        sum1(input,target);
        sum2(input,target);
    }
    //
    public static void sum1(int[] arr, int target){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            for(int j =i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length;k++){
                    if(arr[i]+arr[j]+arr[k] == target){
                        System.out.println("The triplets are "+arr[i]+ " " +arr[j]+" "+arr[k]);
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.print("The time taken is ");
        System.out.println(endTime-startTime);
    }
    //using two pointer
    public static  void sum2(int[] arr, int target){
        long startTime = System.currentTimeMillis();
        // sort the array to use two pointer
        Arrays.sort(arr);
        for(int i  = 0; i < arr.length; i++){
            int remPairSum = target - arr[i];
            int first = i+1;
            int end = arr.length-1;
            while(first < end){
                if(arr[first]+arr[end] == remPairSum){
                    System.out.println("The triplets are "+arr[i]+ " " +arr[first]+" "+arr[end]);
                    first++;
                    end--;
                }else if(arr[first]+arr[end] < remPairSum){
                    first++;
                }else{
                    end--;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.print("The time taken is ");
        System.out.println(endTime-startTime);
    }
}
