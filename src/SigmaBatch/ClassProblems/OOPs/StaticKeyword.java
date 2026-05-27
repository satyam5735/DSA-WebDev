package SigmaBatch.ClassProblems.OOPs;

public class StaticKeyword {
    public static void main(String[] args) {
        Students s1 = new Students();
        s1.schoolName = "JMV";

        Students s2 = new Students();
        System.out.println(s1.schoolName);

        Students s3 = new Students();
        s3.schoolName = "VMJ";
        System.out.println(s3.schoolName);
    }
}

class Students {
    static int returnPercentage(int math, int phy, int chem){
        return (math + phy + chem) / 3;
    }
    String name;
    int roll;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
}
