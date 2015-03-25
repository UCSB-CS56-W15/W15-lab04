package edu.ucsb.cs56.w15.drawings.vporter.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;  
    Thread anim2;
 
    //Information for Robot 1
    int xCoordinate = 100;
    int yCoordinate = 100;
    int size = 300;
    int antennaeSize = 10;
    int antennaeSizeChange = 0;

    //Information for Robot 2
    int x2Coordinate = 700;
    int y2Coordinate = 100;
    int size2 = 300;
    int x2Speed = -5;

    static int clickCount = 0;

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
	public void mouseClicked(MouseEvent arg0) {
	    clickCount++;

	    if(clickCount%2 != 0 ) {
	    System.out.println("here was a click ! ");
	    anim = new Animation();
	    anim.start();
	    anim2 = new Animation2();
	    anim2.start();
	    }
	    else {
		anim.interrupt();
		anim2.interrupt();
	    }
	}
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

          Graphics2D g2 = (Graphics2D) g;
	  Stroke thick = new BasicStroke(4.0f,BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
          g2.setStroke(thick);

          g2.setColor(new Color(98,223,255));
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          g2.setColor(Color.BLACK);
          RobotWithFeatures test = new RobotWithFeatures(xCoordinate, yCoordinate, size, antennaeSize);
          g2.draw(test);
	  RobotWithFeatures test2 = new RobotWithFeatures(x2Coordinate,y2Coordinate, size2, 10);
	  g2.setColor(new Color(255,112,222));
	  g2.draw(test2);

	  Rectangle2D.Double ground = new Rectangle2D.Double(0,405,640,40);
	  g2.setColor(Color.GREEN);
	  g2.fill(ground);
	  g2.draw(ground);
	 
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

	    if (x2Coordinate <= 400) {  antennaeSizeChange = 2; }
	    if (antennaeSize >= 100) {  antennaeSizeChange = 0; }
	    if (x2Speed > 0 && x2Coordinate >= 600) {  antennaeSizeChange = -2;}
    
	    antennaeSize += antennaeSizeChange;

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

    class Animation2 extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x2Coordinate >= 800) { x2Speed = -5; }
            if (x2Coordinate <= 400) { x2Speed = 0; }
	    if (antennaeSize >= 100) { x2Speed = 5; }
	    if (antennaeSize <= 10) { antennaeSizeChange = 0;}
	           
            x2Coordinate += x2Speed;
    
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
