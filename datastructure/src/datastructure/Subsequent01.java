package datastructure;

import java.util.Stack;

public class Subsequent01 {
    public static void main(String[] args) {
        System.out.println(solution("123*01ert"));
    }
    static int solution(String str) {
        Stack<Character> stack = new Stack<>();

        for(Character c : str.toCharArray()) {
            if(c == '*') {
                stack.push(c);
            }
            if(c == '1') {
                if(!stack.isEmpty() && stack.peek() == '0'){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if(c == '0') {
                if(!stack.isEmpty() && stack.peek() == '1') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }
}
