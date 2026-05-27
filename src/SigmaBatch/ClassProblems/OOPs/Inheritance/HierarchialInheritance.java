package SigmaBatch.ClassProblems.OOPs.Inheritance;

public class HierarchialInheritance {

}
class annimal {
    String color;

    void eat() {
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathes");
    }
}

//Derived class
class Mammmal extends annimal {
    void walk() {
        System.out.println("walks");
    }
}
class fish extends annimal {
    void swim() {
        System.out.println("swims");
    }
}
class Bird extends annimal {
    void fly() {
        System.out.println("fly");
    }
}