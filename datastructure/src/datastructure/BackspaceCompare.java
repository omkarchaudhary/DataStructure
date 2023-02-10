package datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));

        HashMap<Integer,String> map = new HashMap<>();

        map.put(2,"ABC");
        map.put(2,"CDE");
        map.remove(2,"CDE");

        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> new_Map
                    = (Map.Entry<Integer, String>)
                    it.next();
            System.out.println("size of HashMap " + map.size()+ " "+new_Map.getKey() + " value "+ new_Map.getValue());
        }
    }

    public static boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }

    public static String backspace(String s){
        StringBuilder sb = new StringBuilder(s);
        //ab#c and ad#c
        //length =  4;

        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '#') {
                index = Math.max(i - 2, -1);
                if (i == 0) sb.delete(0, 1);
                else sb.delete(i - 1, i + 1);
                i = index;
            }
        }
        return sb.toString();
    }
}
