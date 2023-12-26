package datastructure.codingpatterns.twopointers;

import java.util.Arrays;

/**
 * Leetcode link : https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println("The three sum closest to target is "+ threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4},1));
    }
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        //-4, -1, 1, 2
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int firstValue = nums[i];
            int startPointer = i+1;
            int endPointer = nums.length-1;
            while(startPointer < endPointer){
                int sum = firstValue+nums[startPointer]+nums[endPointer];

                if(sum == target){
                    result = sum;
                }else if(Math.abs(target - sum) < Math.abs(target-result)){
                    result = sum;
                }

                if(sum < target){
                    startPointer++;
                }else{
                    endPointer--;
                }
            }
        }
        return result;
    }

}
