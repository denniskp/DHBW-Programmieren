package de.dhbwka.java.exercise.classes;

public class Account {
    private static final String PRINT_TEMPLATE = "Konto Nr. %d (%s), Stand: %.2f €, Limit: %.2f €";
    private static final String CLR_RESET = "\u001B[0m";
    private static final String CLR_RED = "\u001B[31m";

    private final int id;
    private final String owner;
    private double balance;
    private double limit;

    public Account(int id, String owner) {
        this.id = id;
        this.owner = owner;
        balance = 0.0;
        limit = 0.0;
    }

    public Account(int id, String owner, double balance, double limit) {
        this(id, owner);
        this.balance = balance;
        this.limit = limit;
    }

    public void deposit(double amount) {
        if (amount <= 0.0) {
            System.out.println(CLR_RED + "Es muss mehr als 0€ eingezahlt werden!" + CLR_RESET);
            return;
        }
        balance += amount;
    }

    public void payout(double amount) {
        if (amount > balance + limit) {
            System.out.println(CLR_RED + "Deckung nicht ausreichend!" + CLR_RESET);
            return;
        }
        balance -= amount;
    }

    public void printBalance() {
        System.out.printf("Kontostand: %.2f €\n", balance);
    }

    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE, id, owner, balance, limit);
    }

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500.0, 1000.0);
        System.out.println(account);
        account.deposit(200.0);
        System.out.println(account);
        account.payout(400.0);
        System.out.println(account);
        account.payout(2000.0);
        System.out.println(account);
    }
}
