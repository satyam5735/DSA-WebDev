package SigmaBatchDSA.ClassProblems.OOPs;

public class SuperKeyword {
    public static void main(String[] args) {
        Horses horse = new Horses();
        System.out.println(horse.color);
    }
}
class Animals {
    String color;
    Animals() {
        System.out.println("Animals constructor is called");
    }
}

class Horses extends Animals {
    Horses() {
        super.color = "brown";
        System.out.println("Horses constructor is called");
    }
}
