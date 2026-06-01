package SigmaBatchDSA.AssignProblems.ConditionalStatements;

import java.util.Scanner;

public class ConditionalStatements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>0){
            System.out.println("Positive");
        }else if(n<0){
            System.out.println("Negative");
        }else{
            System.out.println("Zero");
        }
        System.out.println();

        Solution sol = new Solution();
        sol.display();
        System.out.println();

        Week week = new Week();
        week.display();
        System.out.println();

        Solution2 sol2 = new Solution2();
        sol2.display();
        System.out.println();

        LeapYear leapYear = new LeapYear();
        leapYear.display();
    }
}
class Solution{
    public void display(){
        double temp = 103.5;
        if (temp>100){
            System.out.println("Fever");
        } else{
            System.out.println("Not Fever");
        }
    }
}
class Week{
    public void display(){
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        switch(day){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
class Solution2{
    public void display(){
        int a = 63, b = 36;
        boolean x = (a<b) ? true : false;
        int y = (a>b) ? a : b;

        System.out.println("Value of x is: " + x);
        System.out.println("Value of y is: " + y);
    }
}
class LeapYear{
    public void display(){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if(year%4==0 && year%100!=0 || year%400==0){
            System.out.println("Leap Year");
        }else{
            System.out.println("Not Leap Year");
        }
    }
}
