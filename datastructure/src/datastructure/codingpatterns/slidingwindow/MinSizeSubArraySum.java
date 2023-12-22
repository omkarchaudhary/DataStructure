package datastructure.codingpatterns.slidingwindow;

/**
 * Leetcode link https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        MinSizeSubArraySum minSizeSubArraySum = new MinSizeSubArraySum();
        int [] nums = {2,3,1,2,4,3};
        int target= 7;
        System.out.println("The min length of subarray is "+ minSizeSubArraySum.minSubArrayLen(target, nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            windowSum += nums[windowEnd];
            while(windowSum >= target){
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart +1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        if(minWindowSize == Integer.MAX_VALUE) return 0;

        return minWindowSize;
    }
}
