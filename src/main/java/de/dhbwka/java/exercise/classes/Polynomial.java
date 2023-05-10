package de.dhbwka.java.exercise.classes;

public class Polynomial {
    private static final String STRING_PRINT = "%fx^2 %+fx %+f";

    private final double a;
    private final double b;
    private final double c;

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double f(double x) {
        return a * (x * x) + b * x + c;
    }

    public Polynomial add(Polynomial polynomial) {
        return new Polynomial(a + polynomial.a, b + polynomial.b, c + polynomial.c);
    }

    public Polynomial subtract(Polynomial polynomial) {
        return new Polynomial(a - polynomial.a, b - polynomial.b, c - polynomial.c);
    }

    public Polynomial multiply(double factor) {
        return new Polynomial(a * factor, b * factor, c * factor);
    }

    public double[] getZeroPoints() {
        double d = (b * b) - (4 * a * c);

        if (d < 0)
            return new double[]{};

        double sqrtD = Math.sqrt(d);
        if (d == 0) {
            return new double[]{ (-b + sqrtD) / (2 * a) };
        } else {
            return new double[]{ (-b + sqrtD) / (2 * a), (-b - sqrtD) / (2 * a) };
        }
    }

    @Override
    public String toString() {
        return String.format(STRING_PRINT, a, b, c);
    }

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(2.0, 0.0, 0.0);
        System.out.println("P1: " + p1);
        Polynomial p2 = new Polynomial(0.0, -4.0, 1.0);
        System.out.println("P2: " + p2);
        Polynomial p3 = p1.add(p2);
        System.out.println("P3 = P1 + P2: " + p3);
        p3 = p3.multiply(2.0);
        System.out.println("P3 = 2.0 * P3: " + p3);
        System.out.printf("Nullstellen von P3 (%s):\n", p3);
        for (double zp : p3.getZeroPoints()) {
            System.out.printf("%f ", zp);
        }
        System.out.println();

        Polynomial p4 = new Polynomial(2.0, 4.0, 2.0);
        System.out.printf("Nullstellen von P4 (%s):\n", p4);
        for (double zp : p4.getZeroPoints()) {
            System.out.printf("%f ", zp);
        }
        System.out.println();
    }
}
