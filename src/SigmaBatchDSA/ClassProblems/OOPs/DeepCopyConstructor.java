package SigmaBatchDSA.ClassProblems.OOPs;

public class DeepCopyConstructor {
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
class stuudent {
    String name;
    int roll;
    String password;
    int marks[];

    //deep copy constructor
    stuudent(stuudent s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.password = s1.password;
        for(int i = 0; i < marks.length; i++){
            this.marks[i] = s1.marks[i];
        }
    }

    stuudent() {
        marks = new int[3];
        System.out.println("Student constructor");
    }
    stuudent(String name) {
        marks = new int[3];
        this.name = name;
    }
    stuudent(int roll){
        marks = new int[3];
        this.roll = roll;
    }
}

