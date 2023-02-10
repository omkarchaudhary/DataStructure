package datastructure;

import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayReductionOrNRopesMinCost {
    public static void main(String[] args) {
        int[] nums = {2,5,4,8,6,9};
        System.out.println(reductionCost(nums));
        int[] num = {4,6,8};
        System.out.println(reductionCost(num));
    }

    private static int reductionCost(int[] nums) {
        int totalCost = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int n : nums){
            queue.offer(n);
        }
        while(queue.size() > 1){
            int firstNum = queue.poll();
            int secondNum = queue.poll();
            int sum = firstNum+secondNum;
            totalCost += sum;
            queue.offer(sum);
        }
        return totalCost;
    }
}
