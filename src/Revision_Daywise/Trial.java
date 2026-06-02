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

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> result = new Stack<>();
        // Stack operates on LIFO(Last In First Out)
        for(String op : operations){
            if(op.equals("+")){
                int last = result.pop();
                int lastsecond = last + result.peek();
                result.push(last);
                result.push(lastsecond);
            }
            else if(op.equals("D")){
                result.push(2*result.peek());
            }
            else if(op.equals("C")){
                result.pop();
            }
            else{
                result.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for(int i : result){
            sum+=i;
        }
        return sum;
    }
}