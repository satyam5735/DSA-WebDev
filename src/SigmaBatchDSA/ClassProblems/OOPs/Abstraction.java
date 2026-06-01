package SigmaBatchDSA.ClassProblems.OOPs;

public class Abstraction {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);

        System.out.println();
        Chicken c = new Chicken();
        c.eat();
        c.walk();

        System.out.println();
        Mustang myHorse = new Mustang();
    }
}
abstract class Animal {
    String color;
    //constructor
    Animal(){
        System.out.println("Animal Constructor called");
    }
    void eat() {
        System.out.println("animal eats");
    }
    abstract void walk();
}
class Horse extends Animal {
    Horse(){
        System.out.println("Horse Constructor called");
    }
    void changeColor() {
        color = "dark brown";
    }
    void walk() {
        System.out.println("walks on 4 legs");
    }
}
class Mustang extends Horse {
    Mustang(){
        System.out.println("Mustang Constructor called");
    }
}
class Chicken extends Animal {
    void changeColor() {
        color = "white";
    }
    void walk() {
        System.out.println("walks on 2 legs");
    }
}
