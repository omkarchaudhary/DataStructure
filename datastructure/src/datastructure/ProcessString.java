package datastructure;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProcessString {
    public static void main(String[] args) {
        String input = "asdSEPgfdjbkSEPgnkjfdnSEPcdgfg";
        HashMap<String, String> result = processString(input,"SEP");
        for (Map.Entry<String, String> e : result.entrySet())
            System.out.println(e.getKey()+": "+e.getValue());
    }

    private static HashMap<String, String> processString(String input, String separator){

        HashMap<String, String> result  = new HashMap<>();
        if(separator.isEmpty()){
            result.put("Count",String.valueOf(1));
            result.put("Prefix",input);
            result.put("SortedItems", "");
            result.put("EvenChar", "");
            return  result;
        }
        String[] arr = input.split(separator);
        int count = arr.length;

        result.put("Count",String.valueOf(count));
        result.put("Prefix",arr[0]);

        Arrays.sort(arr);
        StringBuilder sortedStr = new StringBuilder();
        for(int i = 0; i < arr.length-1; i++){
            sortedStr.append(arr[i]+ " ");
        }
        sortedStr.append(arr[arr.length-1]);
        result.put("SortedItems", sortedStr.toString());

        StringBuilder strB = new StringBuilder();
        for(int i  = 0; i<input.length();i=i+2){
            strB.append(input.charAt(i));
        }
        result.put("EvenChar", strB.toString());

        return result;
    }
}
