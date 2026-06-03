package Revision_Daywise;

//class Trial {
//    public static String mergeAlternately(String word1, String word2) {
//        int maxLength = Math.max(word1.length(), word2.length());
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < maxLength; i++) {
//            if(i<word1.length()) {
//                result.append(word1.charAt(i));
//            }
//            if(i<word2.length()) {
//                result.append(word2.charAt(i));
//            }
//        }
//        return result.toString();
//    }
//    public static void main(String[] args) {
//        String word1 = "abc";
//        String word2 = "xyz";
//        System.out.println(mergeAlternately(word1, word2));
//    }
//}

//import java.util.Stack;
//
//class Solution {
//    public int calPoints(String[] operations) {
//        Stack<Integer> result = new Stack<>();
//        // Stack operates on LIFO(Last In First Out)
//        for(String op : operations){
//            if(op.equals("+")){
//                int last = result.pop();
//                int lastsecond = last + result.peek();
//                result.push(last);
//                result.push(lastsecond);
//            }
//            else if(op.equals("D")){
//                result.push(2*result.peek());
//            }
//            else if(op.equals("C")){
//                result.pop();
//            }
//            else{
//                result.push(Integer.parseInt(op));
//            }
//        }
//        int sum = 0;
//        for(int i : result){
//            sum+=i;
//        }
//        return sum;
//    }
//}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> CloseToOpen = new HashMap<Character,Character>();

        // Map CLOSING brackets (keys) to OPENING brackets (values)
        CloseToOpen.put(')','(');
        CloseToOpen.put(']','[');
        CloseToOpen.put('}','{');

        for (char c : s.toCharArray()) {

            // If it is a closing bracket
            if (CloseToOpen.containsKey(c)) {
                // Stack must not be empty, and the top must match the opening bracket
                if (!stack.isEmpty() && stack.peek() == CloseToOpen.get(c)) {
                    stack.pop(); // Match found, remove it
                } else {
                    return false; // Mismatch or stack was empty when a close bracket appeared
                }
            }
            else{
                // It is an opening bracket, push it onto the stack
                stack.push(c);
            }
        }
        // If the stack is empty, all brackets were matched perfectly
        return stack.isEmpty(); // all poped out
    }
}
