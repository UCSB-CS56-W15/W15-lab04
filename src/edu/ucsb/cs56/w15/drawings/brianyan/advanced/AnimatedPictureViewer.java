package edu.ucsb.cs56.w15.drawings.brianyan.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** A viewer class to see a picture I drew with 
 *  just three simple Java graphics objects, namely
 *  Rectangle, Line2D.Double, Ellipse2D.Double
 *  
 * @author P. Conrad 
 * @author Brian Yan
 * @version for UCSB CS56, W15, 02/17/2015
 */
public class AnimatedPictureViewer {
    
    private DrawPanel panel = new DrawPanel();

    private Television tele  = new Television(100,100,50);

    Thread anim;
    
    private int x,y = 100;
    private int dx = 5;
    private int dy = 5;
    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }

    public void go(){
	//sets the new frame
	JFrame frame = new JFrame();
	//exits when red button or X is pressed
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	// sets the size of frame to 640,480
	frame.setSize(640,480);
	// gives the frame a title.
	frame.setTitle("Brian Yan's Animted Drawing");
	frame.setVisible(true);
	
	//set Mouse Listeners
	frame.getContentPane().addMouseListener(new MouseAdapter(){
	public void mouseEntered(MouseEvent e){
	    System.out.println("mouse entered");
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
    }
    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Television
	  if(x>=200){
	      g2.setColor(Color.RED);
	      Television test = new Television(x, y, 50);
	      g2.draw(test);
	  }
	  else{
          g2.setColor(Color.CYAN);
          Television test = new Television(x, y, 50);
          g2.draw(test);
	  }
}
}
class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

	      if (x >= 400) { dx = -5; }
            if (x <= 50) { dx = 5; }
	    if (y>=400){ dy= -5;}
	    if (y<=50){ dy= 5;}
            
            x += dx;           
	    y += dy;
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
