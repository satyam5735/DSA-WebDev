package Revision_Daywise;

class Trial {
    public String mergeAlternately(String word1, String word2) {
        int maxLength = Math.max(word1.length(),word2.length());
        for(int i=0;i<maxLength;i++){
            System.out.print(word1.charAt(i));
            System.out.print(word2.charAt(i));
        }
    }
    return 0;
}