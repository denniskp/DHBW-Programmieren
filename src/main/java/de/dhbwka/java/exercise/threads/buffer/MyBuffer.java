package de.dhbwka.java.exercise.threads.buffer;

import java.util.LinkedList;
import java.util.Random;

class ProducerThread extends Thread {
    private final Random random = new Random();
    private final MyBuffer buf;
    
    public ProducerThread(MyBuffer b) {
        this.buf = b;
    }

    private void sleep() {
        try {
            Thread.sleep(random.nextLong(0, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void run() {
        this.buf.put(0);
        System.out.println("Fill level after put " + buf.getValues().size());
        sleep();
        this.buf.put(1);
        System.out.println("Fill level after put " + buf.getValues().size());
        sleep();
        this.buf.put(2);
        System.out.println("Fill level after put " + buf.getValues().size());
        sleep();
        this.buf.put(3);
        System.out.println("Fill level after put " + buf.getValues().size());
        sleep();
        this.buf.put(4);
        System.out.println("Fill level after put " + buf.getValues().size());
        sleep();
        this.buf.put(5);
        System.out.println("Fill level after put " + buf.getValues().size());
        sleep();
        this.buf.put(6);
        System.out.println("Fill level after put " + buf.getValues().size());
        sleep();
    }
}

class ConsumerThread extends Thread {
    private final Random random = new Random();
    private final MyBuffer buffer;

    public ConsumerThread(MyBuffer b) {
        this.buffer = b;
    }

    private void sleep() {
        try {
            Thread.sleep(random.nextLong(0, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        this.buffer.get();
        System.out.println("Fill level after get " + buffer.getValues().size());
        sleep();
        this.buffer.get();
        System.out.println("Fill level after get " + buffer.getValues().size());
        sleep();
        this.buffer.get();
        System.out.println("Fill level after get " + buffer.getValues().size());
        sleep();
        this.buffer.get();
        System.out.println("Fill level after get " + buffer.getValues().size());
        sleep();
        this.buffer.get();
        System.out.println("Fill level after get " + buffer.getValues().size());
        sleep();
        this.buffer.get();
        System.out.println("Fill level after get " + buffer.getValues().size());
        sleep();
        this.buffer.get();
        System.out.println("Fill level after get " + buffer.getValues().size());
        sleep();
    }
}

public class MyBuffer {
    private final static int MAXSIZE = 3;

    private final LinkedList<Integer> values = new LinkedList<>();

    public LinkedList<Integer> getValues() {
        return values;
    }

    public synchronized void put(int v) {
        if (!this.values.isEmpty()) {
            try {
                System.out.println("Buffer full - please wait");
                this.wait();
            } catch (InterruptedException ignored) { }
        }

        this.values.add(v);

        this.notify();

        System.out.println("Put: " + v);
    }

    public synchronized int get() {
        int v;
        if (this.values.isEmpty()) {
            try {
                System.out.println("Buffer empty - please wait");
                this.wait();
            } catch (InterruptedException ignored) { }
        }

        v = this.values.get(0);
        this.values.remove(0);

        this.notify();
        System.out.println("Get: " + v);

        return v;
    }

    public static void main(String[] args) {
        MyBuffer buffer = new MyBuffer();

        ProducerThread thread1 = new ProducerThread(buffer);
        thread1.start();

        ConsumerThread thread2 = new ConsumerThread(buffer);
        thread2.start();
    }
}
