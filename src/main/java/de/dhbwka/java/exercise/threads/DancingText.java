package de.dhbwka.java.exercise.threads;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DancingText extends JComponent implements Runnable {
   private final static int XBASE = 30;
   private final static int XSTEP = 36;
   private final static int YBASE = 150;
   private final static Random RANDOM = new Random();

   private final String text;
   private final long delay;

   private int colR = 0;
   private int colG = 90;
   private int colB = 180;

   public DancingText(String text, long delay) {
      this.text = text;
      this.delay = delay;
      Thread painter = new Thread(this);
      painter.start();
   }

   @Override
   public void run() {
      while (this.isVisible()) {
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

      g.setFont(new Font("Helvetica", Font.BOLD, 48));
      for (int i = 0; i < this.text.length(); i++) {
         char c = this.text.charAt(i);

         this.colR = (this.colR + 4 + DancingText.RANDOM.nextInt(4)) % 256;
         this.colG = (this.colG + 4 + DancingText.RANDOM.nextInt(4)) % 256;
         this.colB = (this.colB + 4 + DancingText.RANDOM.nextInt(4)) % 256;

         int yOffset = DancingText.RANDOM.nextInt(30);

         g.setColor(new Color(this.colR, this.colG, this.colB));
         g.drawString(String.valueOf(c), DancingText.XBASE + i * DancingText.XSTEP, DancingText.YBASE - yOffset);
      }
   }

   public static void main(String[] args) {
      JFrame f = new JFrame("Dancing Text");
      DancingText dancingText = new DancingText("Dancing Text :-)", 44);
      f.add(dancingText);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(640, 280);
      f.setVisible(true);
   }
}
