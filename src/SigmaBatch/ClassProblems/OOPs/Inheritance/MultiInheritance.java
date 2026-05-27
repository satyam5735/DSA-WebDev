package SigmaBatch.ClassProblems.OOPs.Inheritance;

public class MultiInheritance {
    public static void main(String[] args) {
        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);
    }
}

//Base class
class animal {
    String color;

    void eat() {
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathes");
    }
}

//Derived class
class Mammal extends animal {
    int legs;
}
class Dog extends Mammal {
    String breed;
}
