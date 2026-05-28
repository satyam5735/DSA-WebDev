package SigmaBatch.ClassProblems.OOPs;

public class Oops {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.color);

        p1.setTip(5);
        System.out.println(p1.tip);

        BankAccount myAcc = new BankAccount();
        myAcc.username = "John";
        myAcc.setPassword("ab12cd34");
    }
}
class BankAccount {
    public String username;
    private String password;
    void setPassword(String pwd) {
        password = pwd;
    }
}
class Pen{
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }
    void setTip(int newTip) {
        tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    void calPercentage(int phy, int chem, int math){
        percentage = (phy + chem + math)/3.0f;
    }
}
