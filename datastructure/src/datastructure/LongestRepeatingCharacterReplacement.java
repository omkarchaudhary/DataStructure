package datastructure;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
    int result = characterReplacement("ABACAABA",1);
        System.out.println("The output is "+result);
    }

    public static int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int leftPointer = 0;
        int rightPointer = 0;
        int n = arr.length;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int mostFreq = 0;
        while(rightPointer< n){
            map.put(arr[rightPointer], map.getOrDefault(arr[rightPointer],0)+1);
            mostFreq = Math.max(mostFreq, map.get(arr[rightPointer]));
            if((rightPointer-leftPointer+1) - mostFreq > k){
                map.put(arr[leftPointer], map.get(arr[leftPointer])-1);
                leftPointer++;
            }
            maxLen = Math.max(maxLen,rightPointer-leftPointer+1);
            rightPointer++;
        }
        return maxLen;
    }
}
