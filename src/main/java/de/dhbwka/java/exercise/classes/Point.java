package de.dhbwka.java.exercise.classes;

public class Point {
    private static final String PRINT_TEMPLATE = "Punkt (%f, %f)";

    private double x;
    private double y;

    public Point() {
        x = 0.0;
        y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceToOrigin() {
        return Math.sqrt((x * x) + (y * y));
    }

    public Point mirrorAtX() {
        return new Point(x, -y);
    }

    public Point mirrorAtY() {
        return new Point(-x, y);
    }

    public Point mirrorOrigin() {
        return new Point(-x, -y);
    }

    public double getDistance(Point point) {
        double newX = point.getX() - x;
        double newY = point.getY() - y;
        return Math.sqrt((newX * newX) + (newY * newY));
    }

    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE, x, y);
    }

    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: " + pointA.getDistance(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A'-B: " + pointA.getDistance(pointB));
    }
}
