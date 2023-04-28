package datastructure;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int right = 1, left = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }
        //1,2,3,4
        //res = 1, 1, 2, 6
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }
        //res = 24,
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
    }
}
