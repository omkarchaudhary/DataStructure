package datastructure;

public class IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","bar"));
        IsomorphicString s = new IsomorphicString();
        int [] a = {1};
        s.increment(a);
        System.out.println(a[a.length-1]);
        System.out.println(String.valueOf(s.add(5)));
    }

    void increment(int[] i){
        i[i.length-1]++;
    }

    Object add(int a){
        for(int i = 0; i< 3; i++){
            for(int j = 0; j< 3; j++){
                if(a==5){
                    break;
                }
                System.out.println(i*j);
            }
        }
        return null;
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
