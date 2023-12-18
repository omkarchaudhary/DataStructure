package datastructure.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1,2,3});
        res.stream().forEach( x -> System.out.println(x));

    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(),nums);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums){
        // add empty set
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i< nums.length; i++){
            if(temp.contains(nums[i])){
                System.out.println("duplicate found");
                continue;
            }
            temp.add(nums[i]);
            dfs(res,temp,nums);
            System.out.println("remove called");
            temp.remove(temp.size()-1);
        }
    }
}
