package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> test = combinationSum(new int[]{2,3,5},8);
        for(List<Integer> ls : test){
            System.out.println(ls.toString());
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backTrack(candidates, target, result, currentList,0);
        return result;
    }
    public static void backTrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList, int index){
        //base case
        if(target == 0){
            result.add(new ArrayList<>(currentList));
        }else if(target < 0 || index >= candidates.length){
            return;
        }
        else{
            currentList.add(candidates[index]);
            backTrack(candidates,target-candidates[index], result, currentList, index);
            currentList.remove(currentList.get(currentList.size()-1));
            backTrack(candidates,target,result,currentList, index+1);
        }
    }
}
