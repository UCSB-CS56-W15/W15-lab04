package edu.ucsb.cs56.w15.drawings.dlynch.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
   An angry Kanye West that taunts the viewer, 
   borrows some format/mouse stuff from andrewberls 

   @author Dylan Lynch
 */
public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    Thread anim;

    private int x = 150;
    private int y = 150;

    private Random rand = new Random();
    
    private int randomDx;
    private int randomDy;
    private boolean fiftyFifty;

    public static void main (String [] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);
        frame.setSize(700,500);
        frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
          public void mouseEntered(MouseEvent e){
          System.out.println("Mouse entered");
            anim = new Animation();
            anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
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

          // Draw Angry Kanye West
          g2.setColor(Color.RED);
          KanyeWestAngry testKanye = new KanyeWestAngry(x, y, 75,100);
          g2.draw(testKanye);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
	      // randomly moves Kanye around
	      // staying within the bounds of the frame
	      randomDx = rand.nextInt(11);
	      randomDy = rand.nextInt(11);
	      
	      fiftyFifty = rand.nextBoolean();
	      
	      if (x < 200 || y < 200) { fiftyFifty = true; }

	      if (fiftyFifty){
		  x += randomDx; y += randomDy;
	      } else {
		  x -= randomDx; y -= randomDy;
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
