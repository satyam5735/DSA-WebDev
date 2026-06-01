package SigmaBatchDSA.LiveSessions.Session13;

class Automobile {
    private String drive() {
        return "Driving vehicle";
    }
}

class Car extends Automobile {
    protected String drive() {
        return "Driving car";
    }
}

public class AssignmentOOPsProblem2 extends Car {
    @Override
    public final String drive() {
        return "Driving electric car";
    }

    public static void main(String[] wheels) {
        final Car car = new AssignmentOOPsProblem2();
        System.out.print(car.drive());
    }
}

//Output - Driving electric car
