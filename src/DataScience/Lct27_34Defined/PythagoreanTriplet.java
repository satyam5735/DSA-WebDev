package DataScience.Lct27_34Defined;
import java.util.Scanner;
public class PythagoreanTriplet {
    public static boolean isPythagoreanTriplet(int p , int b , int h){

        int max = Math.max(h,Math.max(p,b));
        int SumOfSquares = 0;

        if (max == h){
            SumOfSquares = b*b + p*p;
        } else if (max == p){
            SumOfSquares = h*h + b*b;
        } else {
            SumOfSquares = h*h + p*p;
        }

        return max*max == SumOfSquares;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int b = sc.nextInt();
        int h = sc.nextInt();

        if (isPythagoreanTriplet(p, b, h)) {
            System.out.println("Is Pythagorean Triplet");
        } else {
            System.out.println("Not a Pythagorean Triplet");
        }
    }
}
