package edu.ucsb.cs56.w15.drawings.stp.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.lang.Exception;
import java.lang.System;
import java.lang.Thread;
import java.awt.geom.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    Thread animation;

    private double x = 100.0;
    private double y = 300.0;

    private double height = 90.0;
    private double width = 70.0;
    private double wheelRadius = 20.0;

    private double obstacleXPOS = 500.0;

    private int boxSpeed = 7;

    private double dx = 5.0;

    public static void main (String[] args) {
        new AnimatedPictureViewer().go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);
        frame.setSize(640,480);
        frame.setVisible(true);

        frame.getContentPane().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                System.out.println("Start");
                animation = new Animation();
                animation.start();
            }

            public void mouseExited(MouseEvent e){
                System.out.println("Paused");
                // Kill the animation thread
                animation.interrupt();
                while (animation.isAlive()){}
                animation = null;
                panel.repaint();
            }

            public void mousePressed(MouseEvent e) {
                y = y - 30;
                panel.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                y = y + 30;
                panel.repaint();

            }
        });

    } // go()

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;

            // Clear the panel first
            g2.setColor(Color.white);
            g2.fillRect(0,0,this.getWidth(), this.getHeight());

            g2.setColor(Color.BLACK);
            g2.drawString("Press and hold mouse to jump the box.", 20,20);


            // Draw the Scooter
            g2.setColor(Color.GREEN);

            Scooter movingScooter = new Scooter(x, y, width, height, wheelRadius);
            g2.draw(movingScooter);

            g2.setColor(Color.BLUE);
            Rectangle2D.Double obstacle = new Rectangle2D.Double(obstacleXPOS, 290.0, 20.0, 20.0);
            g2.draw(obstacle);
        }
    }

    class Animation extends Thread {
        public void run() {
            try {
                while (true) {
                    if (obstacleXPOS <= 0) {
                        obstacleXPOS = 500;
                        boxSpeed += 1;
                    } else {
                        obstacleXPOS -= boxSpeed;
                    }
                    if ((obstacleXPOS >= x && obstacleXPOS <= x + width) && y == 300.0) {
                        System.out.println("You hit the box.");
                        obstacleXPOS = 500.0;
                    }

                    panel.repaint();
                    Thread.sleep(50);
                }
            } catch(Exception ex) {
                if (ex instanceof InterruptedException) {
                    // Do nothing - expected on mouseExited
                } else {
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

}
