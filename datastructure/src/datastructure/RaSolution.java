package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RaSolution {

    public static void main(String[] args) {

    }

    // updated
    public static List<List<String>> autoCorrectUpdate(List<String> words, List<String> queries){
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,List<String>> resMap = new HashMap<>();
        for(String query: queries){
            int[] freq = new int[128];
            for(int i = 0; i < query.length();i++){
                freq[query.charAt(i)-'a']++;
            }
            String key = Arrays.toString(freq);
            map.put(key,query);
        }
        for(String word: words){
            int[] freq = new int[128];
            for(int i = 0; i < word.length();i++){
                freq[word.charAt(i)-'a']++;
            }
            String key = Arrays.toString(freq);
            if(map.containsKey(key)){
                List<String> ls = resMap.getOrDefault(key,new ArrayList<>());
                ls.add(word);
//                Collections.sort(ls);
                resMap.put(key,ls);
            }
        }
        List<List<String>> lists = new ArrayList<>(resMap.values());
        return lists;
    }

}
