package de.dhbwka.java.exercise.classes;

/**
 * A java class which was created as an exercise purpose.
 * It simulates some basic functions of a radio.
 *
 * @author Dennis
 * @version 0.0.1
 * @since 0.0.1
 */
public class Radio {
    private static final String PRINT_TEMPLATE = "Radio %s; Lautstärke %d; Frequenz %.1f MHz";
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 10;
    private static final double MIN_FREQUENCY = 85.0;
    private static final double MAX_FREQUENCY = 110.0;

    private boolean on;
    private int volume;
    private double frequency;

    /**
     * The default constructor.
     * It activates the radio, assigns the volume the value 4
     * and the frequency the value 99.9.
     */
    public Radio() {
        on = true;
        volume = 4;
        frequency = 99.9;
    }

    /**
     * The enhanced constructor.
     *
     * @param on        On/Off state
     * @param volume    Volume
     * @param frequency Frequency
     */
    public Radio(boolean on, int volume, double frequency) {
        this.on = on;
        this.volume = volume;
        this.frequency = frequency;
    }

    /**
     * Private helper method used to clamp values.
     *
     * @param value Value to clamp
     * @param min Max value
     * @param max Min value
     * @return Clamped value
     */
    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * Used to increment the volume by one.
     * The volume is clamped afterwards.
     *
     * @see Radio#clamp(double, double, double) Radio#clamp(double, double, double)
     */
    public void incVolume() {
        volume++;
        volume = (int) clamp(volume, MIN_VOLUME, MAX_VOLUME);
    }

    /**
     * Used to decrement the volume by one.
     * The volume is clamped afterwards.
     *
     * @see Radio#clamp(double, double, double) Radio#clamp(double, double, double)
     */
    public void decVolume() {
        volume--;
        frequency = clamp(frequency, MIN_FREQUENCY, MAX_FREQUENCY);
    }

    /**
     * Used to activate the radio.
     */
    public void turnOn() {
        on = true;
    }

    /**
     * Used to deactivate the radio.
     */
    public void turnOff() {
        on = false;
    }

    /**
     * Used to change the frequency.
     * If the requested frequency is not between {@value MIN_FREQUENCY} and {@value MAX_FREQUENCY}
     * it'll default to the value 99.9.
     *
     * @param frequency Requested frequency
     */
    public void setFrequency(double frequency) {
        if ((frequency > MAX_FREQUENCY) || (frequency < MIN_FREQUENCY))
            frequency = 99.9;
        this.frequency = frequency;
    }

    /**
     * This function is used to return the general state of the radio.
     * It includes information whether the radio is on or off, on which volume the radio is playing
     * and which frequency it picks up.
     *
     * @return State of the radio
     */
    @Override
    public String toString() {
        return String.format(PRINT_TEMPLATE, on ? "an" : "aus", volume, frequency);
    }

    /**
     * Program entry point
     *
     * @param args Command line arguments
     */
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
