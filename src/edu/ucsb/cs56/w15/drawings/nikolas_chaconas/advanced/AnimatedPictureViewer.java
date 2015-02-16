package edu.ucsb.cs56.w15.drawings.nikolas_chaconas.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = 200;
    private int y = 150;
    private double size = 1.5;
    private int z = x;
    private int w = y + 150;

    public static void main (String[] args) {
      new AnimatedPictureViewer().begin();
    }

    public void begin() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Balloon house, along with two other sets of balloons on either side of it
          
          BalloonsTiedToHouse balloonHouse = new BalloonsTiedToHouse(x,y,size,z,w);
          Balloons balloons = new Balloons(x-(int)(size*145),y,size,z,w);
          Balloons balloons2 = new Balloons(x,y,size,z,w);
          Balloons balloons3 = new Balloons(x+(int)(size*145),y,size,z,w);

          java.awt.Color myBrown = new java.awt.Color(102,051,000);
          java.awt.Color myAqua = new java.awt.Color(051,102,153);
          java.awt.Color myGreen = new java.awt.Color(000,102,000);
          //java.awt.Color brown = new java.awt.Color(102,051,000);


		  g2.setStroke(new BasicStroke (2.0f));

          g2.setColor(myBrown);
          g2.draw(balloonHouse);


          g2.setColor(myAqua);
          g2.draw(balloons);

          g2.setColor(Color.BLUE);
          g2.draw(balloons2);

          g2.setColor(myGreen);
          g2.draw(balloons3);

       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // make house float away and get smaller

            if (y < -70) { x=200; y=150; z=x; w=y+150; size = 1.5;}
       		if(size == 0){size=.02;}
            if (y >= -70) {x+= 3; y-=2; z=x; w=y+(int)(size*100); size-=.01;}
                          
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
