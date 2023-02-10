package datastructure;

public class IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("add","egg"));
    }
    public static boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        for(int i  = 0; i < s.length(); i++){
            if(sArr[s.charAt(i)] != tArr[t.charAt(i)]){
                return false;
            }

            sArr[s.charAt(i)] = i+1;
            tArr[t.charAt(i)] = i+1;
        }


        return true;
    }
}
