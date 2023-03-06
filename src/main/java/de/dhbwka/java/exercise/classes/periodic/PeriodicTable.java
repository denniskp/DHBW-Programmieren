package de.dhbwka.java.exercise.classes.periodic;

import java.util.ArrayList;
import java.util.List;

public class PeriodicTable {
    private final Element[] elements;

    public PeriodicTable() {
        elements = new Element[118];
    }

    public Element[] getElements() {
        return elements;
    }

    public void addElement(Element e) {
        final int pos = e.getOrdinal() - 1;
        if (elements[pos] == null)
            elements[pos] = e;
    }

    public boolean hasElement(int o) {
        return getElement(o) != null;
    }

    public Element getElement(int o) {
        return elements[o - 1];
    }

    public Element[] getMetals() {
        List<Element> metals = new ArrayList<>();
        for (Element e : elements) {
            if (e != null)
                if (e instanceof Metal)
                    metals.add(e);
        }
        return metals.toArray(Element[]::new);
    }

    public static void main(String[] args) {
        PeriodicTable periodicTable = new PeriodicTable();
        periodicTable.addElement(new Element("Wasserstoff", "H", 1, 'K', Element.PHASE_GAS, Element.GROUP_MAIN));
        periodicTable.addElement(new Element("Helium", "He", 2, 'K', Element.PHASE_GAS, Element.GROUP_MAIN));
        periodicTable.addElement(new Metal("Natrium", "Na", 11, 'M', Element.PHASE_SOLID, Element.GROUP_MAIN, false, 21000000.0));
        periodicTable.addElement(new Metal("Eisen", "Fe", 26, 'N', Element.PHASE_SOLID, Element.GROUP_SIDE, false, 10020000.0));
        periodicTable.addElement(new Metal("Germanium", "Ge", 32, 'N', Element.PHASE_SOLID, Element.GROUP_SIDE, true, 1.45));
        periodicTable.addElement(new Element("Brom", "Br", 35, 'N', Element.PHASE_LIQUID, Element.GROUP_MAIN));
        periodicTable.addElement(new Element("Tellur", "Te", 52, 'O', Element.PHASE_SOLID, Element.GROUP_MAIN));
        periodicTable.addElement(new Element("Gold", "Au", 79, 'P', Element.PHASE_SOLID, Element.GROUP_SIDE));

        for (Element e : periodicTable.getElements()) {
            if (e != null)
                System.out.println(e);
        }
        System.out.println();

        Element[] metals = periodicTable.getMetals();
        for (Element m : metals) {
            System.out.println(m);
        }
        System.out.println();

        Element e79 = periodicTable.getElement(79);
        System.out.println(e79);
    }
}
