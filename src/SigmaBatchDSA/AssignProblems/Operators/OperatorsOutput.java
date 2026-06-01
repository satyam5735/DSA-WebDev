package SigmaBatchDSA.AssignProblems.Operators;

public class OperatorsOutput {
    public static void main(String[] args){
        int x = 2, y = 5;
        int exp1 = (x * y / x);
        int exp2 = (x * (y / x));
        System.out.print(exp1 + ",");
        System.out.println(exp2);
        System.out.println();

        Test test = new Test();
        test.display();
        System.out.println();

        Test2 test2 = new Test2();
        test2.display();
        System.out.println();

        Test3 test3 = new Test3();
        test3.display();
        System.out.println();

        Test4 test4 = new Test4();
        test4.display();
    }
}
class Test {
    public void display(){
        int x = 200, y = 50, z =100;
        if (x>y && y>z){
            System.out.println("Hello");
        }
        if (z>y && z<x){
            System.out.println("Java");
        }
        if ((y+200) < x && (y+150) < z){
            System.out.println("Hello Java");
        }
    }
}
class Test2{
    public void display(){
        int x,y,z;
        x = y = z = 2;
        x += y;
        y -= z;
        z /= (x+y);
        System.out.println(x+","+y+","+z);
    }
}
class Test3{
    public void display(){
        int x = 9, y =12;
        int a = 2, b = 4, c = 6;

        int exp = 4/3 * (x+34) + 9 * (a+b*c) + (3 + y * (2 + a)) / (a + b*y);

        System.out.println(exp);
    }
}
class Test4{
    public void display(){
        int x = 10, y = 5;

        int exp1 = (y * (x/y + x/y));
        int exp2 = (y * x/y + y * x/y);

        System.out.print(exp1 + ",");
        System.out.print(exp2);
    }
}