package datastructure;

public class NestedAnagrams {
    public static void main(String[] args) {
        System.out.println(isNestedAnagrams("bored cat bore","act robed robe"));
    }

    static boolean isNestedAnagrams(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        String[] str1Array = str1.split(" ");
        String[] str2Array = str2.split(" ");
        for(String s1 : str1Array){
            boolean flag = false;
            for(String s2 : str2Array) {
                if (isAnagram(s1, s2)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return  false;
        }
        return true;
    }

    static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        int[] ch = new int[128];
        for(int i = 0; i < str1.length();i++){
            ch[str1.charAt(i) - 'a']++;
            ch[str2.charAt(i)-'a']--;
        }
        for(int c : ch){
            if(c>0) return false;
        }
         return true;
    }
}
