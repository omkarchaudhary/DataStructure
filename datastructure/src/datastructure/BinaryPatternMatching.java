package datastructure;

public class BinaryPatternMatching {
    public static void main(String[] args) {
        System.out.println(numberOfSubString("010","amazing"));
    }

    public static int numberOfSubString(String pattern, String source) {
        //010 = amazing; 0101011
        //vowels = 0;
        //Vowels are ‘a‘, ‘e‘, ‘i‘, ‘o‘, ‘u‘, and ‘y‘. All other letters are consonants.
        int count = 0;
        int patLength = pattern.length();
        StringBuilder string= new StringBuilder();
        for(int i  =0; i< source.length();i++) {
            if(source.charAt(i) == 'a' ||source.charAt(i) == 'i'
                    ||source.charAt(i) == 'e'||source.charAt(i) == 'o'||source.charAt(i) == 'u'||source.charAt(i) == 'y') {
                string.append('0');
            }else {
                string.append('1');
            }
        }
        for(int i = 0; i<string.length()-patLength;i++) {
            String string2 = string.substring(i, i+patLength);
            if(pattern.equals(string2)) {
                count++;
            }
        }
        return count;
    }
}
