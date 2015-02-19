package edu.ucsb.cs56.w15.drawings.nikolas_chaconas.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 ** A class for viewing an animation of a house attached to balloons 
 ** flying away
 ** 
 ** @author Nikolas Chaconas 
 ** @version for CS56, lab05, Winter 2015
 **/


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    Thread anim;   
    
    private int x = 200;
    private int y = 170;
    private double size = 1.5;
    private int z = x;
    private int w = y + 150;

    public static void main (String[] args) {
      new AnimatedPictureViewer().begin();

    }

    public void begin() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Nikolas Chaconas's Animated Drawing");
      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent event){
        System.out.println("mouse enter");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent event){        
          System.out.println("mouse exit");
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    }

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
	  
	  java.awt.Color myLightBlue = new java.awt.Color(204,255,255);
          g2.setColor(myLightBlue);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          /* Draw the Balloon house, along with four other sets of balloons
            on either side of it
          */

          BalloonsTiedToHouse balloonHouse = new BalloonsTiedToHouse(x,y,size,z,w);
          Balloons balloons1 = new Balloons(x-(int)(size*280),y,size,z,w);
          Balloons balloons2 = new Balloons(x-(int)(size*140),y,size,z,w);
          Balloons balloons3 = new Balloons(x,y,size,z,w);
          Balloons balloons4 = new Balloons(x+(int)(size*140),y,size,z,w);
          Balloons balloons5 = new Balloons(x+(int)(size*280),y,size,z,w);

          //making different color balloons to attach to the house
          java.awt.Color myBrown = new java.awt.Color(102,051,000);
          java.awt.Color myAqua = new java.awt.Color(051,102,153);
          java.awt.Color myGreen = new java.awt.Color(000,204,000);
          java.awt.Color myOrange = new java.awt.Color(255,153,000);
          java.awt.Color myRed = new java.awt.Color(255,000,000);
          java.awt.Color myPurple = new java.awt.Color(153,102,204);
          java.awt.Color myBlue = new java.awt.Color(051,153,255);

          /*
              Make thicker stroke size and draw all of the balloons and
              balloon house
          */
		      
          g2.setStroke(new BasicStroke (2.0f));

          g2.setColor(myBrown);
          g2.draw(balloonHouse);

          g2.setColor(myBlue);
          g2.draw(balloons1);

          g2.setColor(myOrange);
          g2.draw(balloons2);

          g2.setColor(myGreen);
          g2.draw(balloons3);

          g2.setColor(Color.BLUE);
          g2.draw(balloons4);

          g2.setColor(myPurple);
          g2.draw(balloons5);

       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

            /*
                make house float away and get smaller by
                incrementing house/balloon size and y and 
                x coordinate.
            */

            //reset the animation to it's original coordinates
            if (y < -80) { x=200; y=170; z=x; w=y+150; size = 1.5;}
            //Don't want a negative size, capping out min size at .01
       		  if(size == 0){size=.02;}
            //This if statement creates the "snapping" effect of the balloons
            if (y > 90) {
                x+=3; y-=2;
            }
            /* 
                After house has "Snapped" towards the balloons, the
                entire house and balloons float away together.
            */
            else if (y >= -80) {
                x+= 3; y-=2; z=x; w=y+(int)(size*100); size-=.01;
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
