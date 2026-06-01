package SigmaBatchDSA.ClassProblems.OOPs;

public class GetSet {
    public static void main(String[] args) {
        Pent p1 = new Pent();
        p1.setColor("Blue");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        System.out.println(p1.getColor());
    }
}
class Pent {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String color) {
        this.color = color;
    }
    void setTip(int tip) {
        this.tip = tip;
    }
}
