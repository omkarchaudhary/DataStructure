package datastructure;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.*;

public class DictionaryAnagram {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("duel","speed","dule","cars","seped");
        List<String> queries = Arrays.asList("spede","deul");
        List<List<String>> result = autoCorrect(words,queries);
        System.out.println(result.toString());

        List<List<String>> res=new ArrayList<>();
//        String[] words={"duel","speed","dule","cars"};
        List<String> wordsList = Arrays.asList("duel","speed","dule","cars");
        String[] queriesList={"speed","duel"};
        for(String s:queriesList){
            res.add(getAnagrams(s, wordsList));
        }
        System.out.println(res);

    }

    public static List<List<String>> autoCorrect(List<String> words, List<String> queries){
        List<List<String>> result = new ArrayList<>();
        for(String query: queries){
            List<String> temp = new ArrayList<>();
            for(String word: words){
                if(isAnagram(query,word)){
                    temp.add(word);
                }
            }
            Collections.sort(temp);
            result.add(temp);
        }
        return  result;
    }

    public static List<String> getAnagrams(String word,List<String> options){
        List<String> s=new ArrayList<>();
        char[] sa=word.toCharArray();
        Arrays.sort(sa);
        String myWord=new String(sa);
        for(String option:options){
            char[] oa=option.toCharArray();
            Arrays.sort(oa);
            String aa=new String(oa);
            if(myWord.equals(aa)){
                s.add(option);
            }
        }
        Collections.sort(s);
        return s;
    }
    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()) return false;
        int[] ch = new int[26];
        for(int i = 0; i < a.length();i++){
            ch[a.charAt(i)-'a']++;
            ch[b.charAt(i)-'a']--;
        }
        for(int c : ch){
            if(c>0) return false;
        }
        return true;
    }


}

















