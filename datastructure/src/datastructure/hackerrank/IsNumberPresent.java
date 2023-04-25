package datastructure.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class IsNumberPresent {
    public static void main(String[] args) {

        List<String> res = isNumberPresent(List.of(1,2,3,2,1));
        System.out.println(res.toString());

        int x =1;
        for(int i= 1; i <= 128; i +=i){
            x += x;
        }
        System.out.println(x);
    }

    public static List<String> isNumberPresent(List<Integer> list){
        //input = {1,2,3,1}
        List<String> result = new ArrayList<>();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        //{1,2,3,4,1}
        for(int i  = 0; i < list.size(); i++){
            List<Integer> firstHalf = i == 0 ? null : list.subList(0,i-1);
            List<Integer> secondHalf = i == list.size()-1 ? null: list.subList(i+1, list.size());
            if(isPresent(firstHalf, list.get(i))){
                str1.append('1');
            }else str1.append('0');

            if(isPresent(secondHalf, list.get(i))){
                str2.append('1');
            }else str2.append('0');
        }
        result.add(str1.toString());
        result.add(str2.toString());
        return  result;
    }

    public static boolean isPresent(List<Integer> input, int val){
        if(input == null) return false;
        return input.contains(val);
    }
}
