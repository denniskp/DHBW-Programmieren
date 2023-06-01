package de.dhbwka.java.exercise.collections.gas;

import java.util.Comparator;
import java.util.Map;

public class GasPricesComparator implements Comparator<Map.Entry<String, GasPrices>> {
    @Override
    public int compare(Map.Entry<String, GasPrices> o1, Map.Entry<String, GasPrices> o2) {
        return o1.getKey().compareTo(o2.getKey());
    }
}
