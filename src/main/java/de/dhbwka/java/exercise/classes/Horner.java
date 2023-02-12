package de.dhbwka.java.exercise.classes;

public class Horner {
    private final double[] coefs;

    public Horner(double[] coefs) {
        this.coefs = coefs;
    }

    public double getValue(double value) {
        double result = 0;
        for (int i = coefs.length - 1; i >= 0; i--) {
            result = coefs[i] + (value * result);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coefs.length; i++) {
            sb.append(String.format("%+f*x^%d ", coefs[i], i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Horner h1 = new Horner(new double[]{ 1.0, -2.0, 3.0, 4.5, 8.0, -10.0, 3.0, 4.0, 2.0, -3.0, 0.5 });
        System.out.println(h1);
        System.out.println("f(1.5): " + h1.getValue(1.5));
    }
}
