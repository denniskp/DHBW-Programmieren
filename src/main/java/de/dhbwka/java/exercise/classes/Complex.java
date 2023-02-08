package de.dhbwka.java.exercise.classes;

import java.util.*;

public class Complex {
    private static final String STR_PRINT = "%f %+fi";

    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex add(Complex comp) {
        return new Complex(real + comp.getReal(), imag + comp.getImag());
    }

    public Complex sub(Complex comp) {
        return new Complex(real - comp.getReal(), imag - comp.getImag());
    }

    public Complex mult(Complex comp) {
        double cReal = comp.getReal();
        double cImag = comp.getImag();
        double newReal = (real * cReal) - (imag * cImag);
        double newImag = (real * cImag) - (imag * cReal);
        return new Complex(newReal, newImag);
    }

    public Complex div(Complex comp) {
        double cReal = comp.getReal();
        double cImag = comp.getImag();
        double c2Pd2 = (cReal * cReal) + (cImag * cImag);
        double newReal = ((real * cReal) + (imag * cImag)) / (c2Pd2);
        double newImag = ((imag * cReal) - (real * cImag)) / (c2Pd2);
        return new Complex(newReal, newImag);
    }

    public double getMagnitude() {
        return Math.sqrt((real * real) + (imag * imag));
    }

    public boolean isLess(Complex comp) {
        return this.getMagnitude() < comp.getMagnitude();
    }

    private static boolean isSorted(Complex[] array) {
        for (int i = 0; i < array.length - 1; ++i)
            if (array[i].getMagnitude() > array[i + 1].getMagnitude())
                return false;
        return true;
    }

    public static void sort(Complex[] array) {
        if (isSorted(array))
            return;

        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].getMagnitude() > array[i + 1].getMagnitude()) {
                Complex temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }

        sort(array);
    }

    @Override
    public String toString() {
        return String.format(STR_PRINT, real, imag);
    }

    public static void main(String[] args) {
        final Random random = new Random();

        Complex[] complexList = new Complex[10];
        for (int i = 0; i < 10; ++i) {
            Complex randComp = new Complex(random.nextDouble(10.0), random.nextDouble(10.0));
            complexList[i] = randComp;
        }

        System.out.println("Unsortiert:");
        for (Complex comp : complexList) {
            System.out.println(comp + "  Betrag: " + comp.getMagnitude());
        }

        Complex.sort(complexList);
        System.out.println("Sortiert:");
        for (Complex comp : complexList) {
            System.out.println(comp + "  Betrag: " + comp.getMagnitude());
        }
    }
}
