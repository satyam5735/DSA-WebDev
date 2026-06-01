package Revision_Daywise;

public class Day6 {

    // Recursion 2
    // Remove Duplicate in a String - I'm using LinkedHashMap for use, more efficient - Hash Set

//    public static String Duplicate(String str){
//        Map<Character,Boolean> map = new LinkedHashMap<>();
//        if(str==null || str.length()==1){
//            return str;
//        }
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            map.put(str.charAt(i),true);
//        }
//        StringBuilder result = new StringBuilder();
//        for (Character c : map.keySet()) {
//            result.append(c);
//        }
//        return result.toString();
//    }
//    public static void main(String[] args) {
//        String str = "apnnaCollege";
//        System.out.println(Duplicate(str));
//    }

    // Friends Pairing
//    public static int Pairing(int n){
//        if(n == 1){
//            return 1;
//        }
//        if(n == 2){
//            return 2;
//        }
//        // single's party
//        int remainingSingle = Pairing(n - 1);
//        // UmmHmm Couples
//        int remainingCoupling = Pairing(n - 2);
//        int pairing = (n - 1) * remainingCoupling;
//        return remainingSingle + pairing;
//    }
//    public static void main(String[] args) {
//        System.out.println(Pairing(3));
//    }

    // Binary String(No Consecutive 1)
//    public static void BinaryString(int n, int last_place, StringBuilder sb) {
//        if (n == 0) {
//            System.out.println(sb.toString());
//            return;
//        }
//        if (last_place == 0) {
//            BinaryString(n - 1, 0, sb.append("0"));
//            sb.deleteCharAt(sb.length() - 1);
//            BinaryString(n - 1, 1, sb.append("1"));
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        else {
//            BinaryString(n - 1, 0, sb.append("0")); // the last place is 0 for next level
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }
//    public static void main(String[] args) {
//        BinaryString(3, 0, new StringBuilder());
//    }

    //
}
