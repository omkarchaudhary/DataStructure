package datastructure.hackerrank;

import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        int output = getLongestConsecutive(new int[]{100,4,200,1,2,3});
        System.out.println("This is output: "+output);
    }

    public static int getLongestConsecutive(int[] input){
        long l = System.currentTimeMillis();
        //100
        int maxCount =0;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<input.length; i++){
            set.add(input[i]);
        }
        //O(n)
        //100,4,200,1,2,3
        for(int i =0; i< input.length; i++){
            int num = input[i];
            int count = 1;
            if(!set.contains(num-1)){
                while(set.contains(num+1) ){
                    count++;
                    num++;
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(System.currentTimeMillis()-l);
        return maxCount;
    }
}

