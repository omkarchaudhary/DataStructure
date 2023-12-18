package datastructure.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1,2,3});
        res.stream().forEach( x -> System.out.println(x));

    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(),nums,0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int start){
        // add empty set
        res.add(new ArrayList<>(temp));
        for(int i = start; i< nums.length; i++){
            temp.add(nums[i]);
            dfs(res,temp,nums, i+1);
            System.out.println("remove called");
            temp.remove(temp.size()-1);
        }
    }

}
