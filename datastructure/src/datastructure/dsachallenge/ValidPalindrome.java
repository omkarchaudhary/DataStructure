package datastructure.dsachallenge;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean isPalindrome = validatePalindrome(str);
        System.out.println("The string is palindrom "+ isPalindrome);
    }
    public static boolean validatePalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(start <= end){
            char leftChar = str.charAt(start);
            char rightChar = str.charAt(end);
            if(!Character.isLetterOrDigit(leftChar)){
                start++;
            }else if(!Character.isLetterOrDigit(rightChar)){
                end--;
            }else {
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
