package datastructure;

public class GCDOfTwoString {

    public static void main(String[] args) {

        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println("The GCD of two string is: "+gcdOfTwoString(str1, str2));
    }

    private static String gcdOfTwoString(String str1, String str2) {
        if(str1.equals(str2)) return str1;

        if(str2.length() > str1.length()) {
            return gcdOfTwoString(str2, str1);
        }
        if(str1.startsWith(str2)){
            return gcdOfTwoString(str1.substring(str2.length()),str2);
        }
         return "";
    }
}
