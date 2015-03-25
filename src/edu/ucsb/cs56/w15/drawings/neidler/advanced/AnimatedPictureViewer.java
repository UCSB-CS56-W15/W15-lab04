package edu.ucsb.cs56.w15.drawings.neidler.advanced;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnimatedPictureViewer {

    private static final double WIDTH = 225;
    private static final double HEIGHT = 175;

    private DrawPanel panel;
    private DetailedCreditCard card;
    private Thread anim;   

    private int x = 100;
    private int y = 100;
    private int dx = 5;

    public static void main (String[] args) {
        new AnimatedPictureViewer().go();
    }

    public AnimatedPictureViewer() {
        panel = new DrawPanel();
        card = new DetailedCreditCard(100.0, 100.0, AnimatedPictureViewer.WIDTH, AnimatedPictureViewer.HEIGHT);
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);
        frame.setSize(640,480);
        frame.setVisible(true);

        frame.getContentPane().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                System.out.println("mouse entered");
                anim = new Animation();
                anim.start();
            }

            public void mouseExited(MouseEvent e){        
                System.out.println("Mouse exited");

                // Kill the animation thread
                anim.interrupt();
                try {
                    anim.join();
                } catch (Exception f) {
                    f.printStackTrace();
                }
                panel.repaint();        
            }
        });
    }

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;

            // Clear the panel first
            g2.setColor(Color.white);
            g2.fillRect(0,0,this.getWidth(), this.getHeight());

            // Draw the Credit Card
            g2.setColor(Color.RED);
            DetailedCreditCard _card = new DetailedCreditCard(x, y, AnimatedPictureViewer.WIDTH, AnimatedPictureViewer.HEIGHT);
            g2.draw(_card);
        }
    }

    class Animation extends Thread {
        private final int SLEEP_TIME = 50;

        public void run() {
            try {
                while (true) {
                    // Bounce off the walls

                    if (x >= 400) { dx = -5; }
                    if (x <= 50) { dx = 5; }

                    x += dx;                
                    panel.repaint();
                    Thread.sleep(SLEEP_TIME);
                }
            } catch (InterruptedException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
