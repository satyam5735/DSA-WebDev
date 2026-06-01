package SigmaBatchDSA.LiveSessions.Session13;

import java.util.Scanner;

class Complex {
    private int real;
    private int imaginary;

    // Constructor
    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Method to subtract two complex numbers
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Method to multiply two complex numbers
    public Complex multiply(Complex other) {
        int r = this.real * other.real - this.imaginary * other.imaginary;
        int i = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(r, i);
    }

    // Display method
    public void display() {
        System.out.println(this.real + " + " + this.imaginary + "i");
    }
}
public class AssignmentOOPsProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first complex number
        System.out.print("Enter real and imaginary part of first complex number: ");
        int real1 = sc.nextInt();
        int imag1 = sc.nextInt();
        Complex c1 = new Complex(real1, imag1);

        // Input second complex number
        System.out.print("Enter real and imaginary part of second complex number: ");
        int real2 = sc.nextInt();
        int imag2 = sc.nextInt();
        Complex c2 = new Complex(real2, imag2);

        // Perform operations
        Complex sum = c1.add(c2);
        Complex diff = c1.subtract(c2);
        Complex prod = c1.multiply(c2);

        // Display results
        System.out.print("Sum: ");
        sum.display();

        System.out.print("Difference: ");
        diff.display();

        System.out.print("Product: ");
        prod.display();

        sc.close();
    }
}