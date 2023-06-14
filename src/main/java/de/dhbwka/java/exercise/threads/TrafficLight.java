package de.dhbwka.java.exercise.threads;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TrafficLight extends JComponent implements Runnable {
   private int cycle = 0;
   private boolean redOn = false;
   private boolean yellowOn = false;
   private boolean greenOn = true;

   private final long delay;

   public TrafficLight(long delay) {
      this.delay = delay;
      Thread thread = new Thread(this);
      thread.start();
   }

   @Override
   public void run() {
      while (this.isVisible()) {
         cycle = ++cycle % 4;
         if (cycle == 0) {
            redOn = true;
            yellowOn = false;
            greenOn = false;
         } else if (cycle == 1) {
            redOn = true;
            yellowOn = true;
            greenOn = false;
         } else if (cycle == 2) {
            redOn = false;
            yellowOn = false;
            greenOn = true;
         } else if (cycle == 3) {
            redOn = false;
            yellowOn = true;
            greenOn = false;
         }

         this.repaint();
         try {
            Thread.sleep(delay);
         } catch (InterruptedException e) {
            e.printStackTrace();
            return;
         }
      }
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.setColor(Color.BLACK);
      g.fillRect(10, 10, 80, 195);

      g.setColor(Color.WHITE);
      g.fillOval(23, 23, 54, 54);
      g.fillOval(23, 83, 54, 54);
      g.fillOval(23, 143, 54, 54);
      
      if (redOn) {
         g.setColor(Color.RED);
         g.fillOval(25, 25, 50, 50);
      }
      
      if (yellowOn) {
         g.setColor(Color.YELLOW);
         g.fillOval(25, 85, 50, 50);
      }

      if (greenOn) {
         g.setColor(Color.GREEN);
         g.fillOval(25, 145, 50, 50);
      }
   }

   public static void main(String[] args) {
      JFrame f = new JFrame("Traffic Light");
      f.add(new TrafficLight(500));
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(100, 260);
      f.setVisible(true);
   }
}
