package de.dhbwka.java.exercise.classes.periodic;

public class Element {
    public final static int PHASE_SOLID = 1;
    public final static int PHASE_LIQUID = 2;
    public final static int PHASE_GAS = 3;

    public final static boolean GROUP_MAIN = true;
    public final static boolean GROUP_SIDE = true;

    private final String name;
    private final String symbol;
    private final int ordinal;
    private final char shell;
    private final int phase;
    private final boolean isMainGroup;

    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean isMainGroup) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.isMainGroup = isMainGroup;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public char getShell() {
        return shell;
    }

    public int getPhase() {
        return phase;
    }

    public boolean isMainGroup() {
        return isMainGroup;
    }

    private String phaseToString() {
        return switch (phase) {
            case PHASE_SOLID -> "fest";
            case PHASE_LIQUID -> "flüssig";
            case PHASE_GAS -> "gasförmig";
            default -> "unbekannt";
        };
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Element e) && (e.getOrdinal() == this.getOrdinal());
    }

    @Override
    public String toString() {
        return String.format("%-2s | %-15s | %2d | %s | %-9s | %s", symbol, name, ordinal, shell, phaseToString(), isMainGroup ? "H" : "N");
    }
}
