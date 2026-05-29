package Revision_Daywise;

import java.util.Scanner;

public class Day1 {

              //  DAY-1

    // Sum of N natural nos

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int sum = 0;
//        for(int i=1;i<=a;i++) {
//            sum += i;
//        }
//        System.out.println(sum);
//    }


    // Sq Pattern

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print("*"+" ");
//            }
//            System.out.println();
//        }
//    }


    // Reverse a No

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int revNo = 0;
//        while (n > 0) {
//            int lastdigit = n % 10;
//            revNo = revNo * 10 + lastdigit;
//            n = n / 10;
//        }
//        System.out.println(revNo);
//    }


    // Star Pattern

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*" + " ");
//            }
//            System.out.println();
//        }
//    }


    // Inverted Star Pattern
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 1; i <= n; i++) {
//            for(int j=n;j>=i;j--){
//                System.out.print("*" +" ");
//            }
//            System.out.println();
//        }
//    }


                  //DAY-2


    // Half Pyramid

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
//    }

    //  Character Pattern

//        public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//
//        for (int i = 1; i <= n; i++) {
//            char ch = 'A';
//            for (int j = 1; j <= i; j++) {
//                System.out.print(ch + " ");
//                ch++;
//            }
//            System.out.println();
//        }
//    }

    // Hollow Rectangle

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        int col = sc.nextInt();
//        for (int i = 1; i <= row; i++) {
//            for (int j = 1; j <= col; j++) {
//                if (i == 1 || i == row || j == 1 || j == col) {
//                    System.out.print("*" + " ");
//                }
//                else {
//                    System.out.print("  "); // 2 spaces for compensating * and one space
//                }
//            }
//            System.out.println();
//        }
//    }

    // Floyd's Pattern

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int a = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(a + " ");
//                a++;
//            }
//            System.out.println();
//        }
//    }

    // 0-1 Pattern

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int rows = sc.nextInt();
//
//
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= i; j++) {
//                if( (i+j) % 2 == 0 ){
//                    System.out.print("1" +" ");
//                }
//                else {
//                    System.out.print("0" +" ");
//                }
//            }
//            System.out.println();
//        }
//    }

    // Butterfly Pattern
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }


}
