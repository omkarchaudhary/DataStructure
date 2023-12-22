package datastructure.codingpatterns.slidingwindow;

/**
 * Leetcode linK https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class FindMaxAverageSubArray {
    public static void main(String[] args) {
        FindMaxAverageSubArray findMaxAverageSubArray = new FindMaxAverageSubArray();
        int [] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("The max average of subarray is "+ findMaxAverageSubArray.findMaxAverage(nums,k));
    }
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int windowStart = 0;
        int sum = 0;
        int result = 0;
        for(int window = 0; window < n; window++){
            sum += nums[window];
            if(window >= k-1){
                result = Math.max(result, sum);
                sum -= nums[windowStart];
                windowStart++;
            }
        }

        return (double)result/k;
    }
}
