package SigmaBatch.AssignProblems.Loops;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        for(int i = 0; i<5; i++){
            System.out.println("Hello");
            i+=2;
        }
        System.out.println();

        Loop2 loop = new Loop2();
        loop.display();
        System.out.println();

        Factorial factorial = new Factorial();
        factorial.display();
        System.out.println();

        MultiplicationTable multiplicationTable = new MultiplicationTable();
        multiplicationTable.display();
    }
}
class Loop2{
    public void display(){
        Scanner sc = new Scanner(System.in);
        int EvenSum = 0;int OddSum = 0;
        System.out.println("Enter number of integers: ");
        int n = sc.nextInt();
        System.out.println("Enter numbers: ");
        for(int i = 0; i<n; i++){
            int x = sc.nextInt();

            if (x%2==0){
                EvenSum += x;
            }else{
                OddSum += x;
            }
        }
        System.out.println("Even Sum: "+EvenSum);
        System.out.println("Odd Sum: "+OddSum);
    }
}
class Factorial{
    public void display(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number for factorial: ");
        int N = sc.nextInt();
        int factorial = 1;
        for(int i = 1; i<=N; i++){
            factorial *= i;
        }
        System.out.println("Factorial of " + N + " is: " + factorial);
    }
}
class MultiplicationTable{
    public void display(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number for multiplication table: ");
        int N = sc.nextInt();
        System.out.println("Multiplication table of : " + N + " is: ");
        for(int i = 1; i<=10; i++){
            System.out.println(N + " x " + i + " = " + N*i);
        }
    }
}