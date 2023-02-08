package de.dhbwka.java.exercise.classes;

public class Radio {
    private static final String PRINT_TEMPLATE = "Radio %s; Lautstärke %d; Frequenz %.1f MHz";
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 10;
    private static final double MIN_FREQUENCY = 85.0;
    private static final double MAX_FREQUENCY = 110.0;

    private boolean on;
    private int volume;
    private double frequency;

    public Radio() {
        on = true;
        volume = 4;
        frequency = 99.9;
    }

    public Radio(boolean on, int volume, double frequency) {
        this.on = on;
        this.volume = volume;
        this.frequency = frequency;
    }

    private void clampVolume() {
        volume = Math.max(MIN_VOLUME, Math.min(MAX_VOLUME, volume));
    }

    public void incVolume() {
        volume++;
        clampVolume();
    }

    public void decVolume() {
        volume--;
        clampVolume();
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void setFrequency(double frequency) {
        if ((frequency > MAX_FREQUENCY) || (frequency < MIN_FREQUENCY))
            frequency = 99.9;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE, on ? "an" : "aus", volume, frequency);
    }

    public static void main(String[] args) {
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }
}
