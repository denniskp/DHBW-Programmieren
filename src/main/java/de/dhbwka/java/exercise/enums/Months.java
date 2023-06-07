package de.dhbwka.java.exercise.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public enum Months {
    JANUARY("Januar", 31, new ArrayList<>(Arrays.asList("Hartung", "Eismond"))),
    FEBRUARY("Februar", 28, new ArrayList<>(Arrays.asList("Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"))),
    MARCH("März", 31, new ArrayList<>(Arrays.asList("Lenzing", "Lenzmond"))),
    APRIL("April", 30, new ArrayList<>(Arrays.asList("Launing", "Ostermond"))),
    MAY("Mai", 31, new ArrayList<>(Arrays.asList("Winnemond", "Blumenmond"))),
    JUNE("Juni", 30, new ArrayList<>(Arrays.asList("Brachet", "Brachmond"))),
    JULY("Juli", 31, new ArrayList<>(Arrays.asList("Heuert", "Heumond"))),
    AUGUST("August", 31, new ArrayList<>(Arrays.asList("Ernting", "Erntemond", "Bisemond"))),
    SEPTEMBER("September", 30, new ArrayList<>(Arrays.asList("Scheiding", "Herbstmond"))),
    OCTOBER("Oktober", 31, new ArrayList<>(Arrays.asList("Gilbhart", "Gilbhard", "Weinmond"))),
    NOVEMBER("November", 30, new ArrayList<>(Arrays.asList("Nebelung", "Windmond", "Wintermond"))),
    DECEMBER("Dezember", 31, new ArrayList<>(Arrays.asList("Julmond", "Heilmond", "Christmond", "Dustermond")));

    private final String name;
    private final int days;
    private final ArrayList<String> oldNames;

    Months(String name, int days, ArrayList<String> oldNames) {
        this.name = name;
        this.days = days;
        this.oldNames = oldNames;
    }

    String getName() {
        return name;
    }

    int getDays() {
        return days;
    }

    ArrayList<String> getOldNames() {
        return oldNames;
    }

    public static void main(String[] args) {
        Months month = Months.values()[Calendar.getInstance().get(Calendar.MONTH)];
        String monthName = month.getName();
        int monthDays = month.getDays();
        String monthOldNames = month.getOldNames().toString().replaceAll("^.|.$", "");

        String output = String.format("Der %s hat %d Tage und hieß früher '%s'", monthName, monthDays, monthOldNames);
        System.out.println(output);
    }
}
