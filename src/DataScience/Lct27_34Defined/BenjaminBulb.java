package DataScience.Lct27_34Defined;
import java.util.*;
public class BenjaminBulb {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the number of bulbs: ");
        int n = sc.nextInt();

        System.out.println("Bulbs that remain on :");
        for ( int i = 1; i*i <= n; i++){
            System.out.print((i*i) + " ");
        }
    }
}
