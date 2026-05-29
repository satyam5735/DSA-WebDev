package Revision_Daywise;

public class Day4 {

    // DAY - 4

    // STRINGS
    // String Concatenation

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter 1st string: ");
//        String s = sc.nextLine();
//        System.out.print("Enter 2nd string: ");
//        String ss = sc.nextLine();
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(s);
//        sb.append(" ");
//        sb.append(ss);
//        System.out.println(sb.toString());
//    }

    // String is Palindrome
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String reverse = new StringBuilder(s).reverse().toString();
//        System.out.println(reverse);
//
//        System.out.print("Palindrome: ");
//        if(s.equalsIgnoreCase(reverse)){
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
//    }

//    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(Character.isLetterOrDigit(c)){
//                sb.append(Character.toLowerCase(c));
//            }
//        }
//        System.out.println(sb.toString());
//        String reverse = new StringBuilder(sb).reverse().toString();
//        System.out.println(reverse);
//
//        System.out.print("Palindrome: ");
////        if(sb.toString().equalsIgnoreCase(reverse)){  // sb.equalsIgnoreCase(reverse) will not work as: It is red because the StringBuilder class does not have an equalsIgnoreCase() method. That method only exists in the String class.
////
////            System.out.println("Yes");
////        } else {
////            System.out.println("No");
////        }
//        // For boolean:
//        boolean isPalindrome = sb.toString().equalsIgnoreCase(reverse);
//        System.out.println(isPalindrome);
//    }


    // Strings Shortest Path
//    public static int ShortestPath(String path){
//    int x = 0 , y = 0 ;
//    for (int i = 0; i < path.length(); i++) {
//        if (path.charAt(i) == 'N') {
//            y++;
//        } else if (path.charAt(i) == 'S') {
//            y--;
//        } else if (path.charAt(i) == 'E') {
//            x++;
//        } else {
//            x--;
//        }
//    }
//    int X = (x - 0)*(x - 0);
//    int Y = (y - 0)*(y - 0);
//    long Z = X + Y;
//    return (int) Math.sqrt(Z);
//    }
//    public static void main(String[] args) {
//    String path = "WNEENESENNN";
//        System.out.println(ShortestPath(path));
//    }

    //Print Largest String
//    public static void main(String[] args) {
//    String fruits[] = {"apple", "orange", "kiwi"};
//    String largest = fruits[0];
//    for (int i = 1; i < fruits.length; i++) {
//        if (largest.compareTo(fruits[i]) < 0) {
//            largest = fruits[i];
//        }
//    }
//    System.out.println(largest);
//    }

    // String Compression
//    public static void main(String[] args) {
//    String s = "abadabbajabba";
//    for (int i = 0; i < s.length(); i++) {
//        int count = 1;
//        while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) { // This is for consecutive coming characters, will not work if same char is coming after some time
//            count++;
//            i++;
//        }
//        System.out.print(s.charAt(i) + " : " + count + " ");
//    }
//    }
    //Compression for global counting: use of Hash Set
//    public static void main(String[] args) {
//        String s = "abadabbajabba";
//        Map<Character, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
//            //The .entrySet() method is a function in Java's Map interface that returns a Set view of the key-value mappings contained in the map
//            //Map.Entry is a nested interface within the java.util.Map interface that represents a single key-value pair (an entry) in a Java Map.
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//
//    }
}
