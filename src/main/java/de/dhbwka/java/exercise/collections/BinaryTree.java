package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTree<T extends Comparable<T>> {
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public boolean add(T newValue) {
        if (value == null) {
            value = newValue;
            return true;
        }

        int comparison = newValue.compareTo(value);
        if (comparison < 0) {
            if (left == null) left = new BinaryTree<>();
            return left.add(newValue);
        } else if (comparison > 0) {
            if (right == null) right = new BinaryTree<>();
            return right.add(newValue);
        }

        return false;
    }

    public T getValue() {
        return value;
    }

    public List<T> traverse() {
        List<T> result = new ArrayList<>();
        if (left != null) result.addAll(left.traverse());
        result.add(value);
        if (right != null) result.addAll(right.traverse());
        return result;
    }

    @Override
    public String toString() {
        return traverse().toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (int i = 0; i < 10; i++) tree.add(random.nextInt(100));
        System.out.println(tree);
    }
}
