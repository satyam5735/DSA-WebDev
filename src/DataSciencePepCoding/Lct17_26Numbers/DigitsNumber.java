package DataSciencePepCoding.Lct17_26Numbers;

import java.util.Scanner;

public class DigitsNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0){
            int digits = n % 10;
            n /= 10;
            System.out.println(digits);
        }
    }
}
