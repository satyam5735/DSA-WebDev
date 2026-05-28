package SigmaBatch.ClassProblems.OOPs;

public class CopyConstructor {
    public static void main(String[] args) {
        stuudent s1 = new stuudent();
        s1.name = "John";
        s1.roll = 456;
        s1.password = "abcd";

        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        stuudent s2 = new stuudent(s1);
        s1.password = "xyz";
        s1.marks[2] = 100;
        for(int i = 0; i < 3; i++){
            System.out.println(s1.marks[i]);
        }
    }
}
class student {
    String name;
    int roll;
    String password;
    int marks[];

    //shallow copy constructor
    student(stuudent s1) {
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks;
    }


    student() {
        marks = new int[3];
        System.out.println("Student constructor");
    }
    student(String name) {
        marks = new int[3];
        this.name = name;
    }
    student(int roll){
        marks = new int[3];
        this.roll = roll;
    }
}
