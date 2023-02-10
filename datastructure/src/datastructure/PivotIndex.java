package datastructure;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{1,2,3}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }
    public  static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftsum = 0;
        for (int num : nums)
            totalSum += num;
        for (int i = 0; i < nums.length;i++ ){
            if (leftsum * 2 == totalSum - nums[i]){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}
