package datastructure;

public class IsBeautifulString {
    public static void main(String[] args) {
        System.out.println(isbeautifulGirl("bbc"));
    }
    public static boolean isbeautifulGirl(String girls){
        int [] girlNumbers = new int[26];
        for(int i = 0; i < girls.length(); i++){
            girlNumbers[girls.charAt(i)-'a']++;
        }
        for(int i  = 0; i < girlNumbers.length-1;i++){
            if(girlNumbers[i]<girlNumbers[i+1]){
                return false;
            }
        }
        return true;
    }
}
