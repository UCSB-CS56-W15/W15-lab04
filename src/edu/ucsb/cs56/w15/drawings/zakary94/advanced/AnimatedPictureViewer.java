package edu.ucsb.cs56.w15.drawings.zakary94.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private ShovelWithDetail mySH = new ShovelWithDetail(100, 100, 100);
    
    Thread anim;   
    
    private int x = 200;
    private int y = 50;
    
    private int dy = 5;
    private int dx = 5;

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
      
    } // go()
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {
	int GROW;	
	

        Graphics2D g2 = (Graphics2D) g;
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
         // Clear the panel first
          g2.setColor(new Color(102,0,204));
          g2.fillRect(0,0,this.getWidth(), this.getHeight());
	//draw a background 
	Rectangle2D.Double myBack = new Rectangle2D.Double(0,0,getWidth(),getHeight());
        g2.setColor(new Color(0,51,102));
	g2.fill(myBack);
	// draw the pile
	g2.setColor(new Color(153,76,0));
	Ellipse2D Pile = new Ellipse2D.Double(400,300/*HERE*/,100,300);
	g2.draw(Pile);
	g2.fill(Pile);
        // draw shovel  
        g2.setColor(new Color(102,0,204));
        ShovelWithDetail test = new ShovelWithDetail(x+100, y, 200);
	g2.draw(test);
	// draw the ground as a rectangle on top of the shovel
	Rectangle2D.Double myG = new Rectangle2D.Double(0,400,1000,200);
	g2.setColor(new Color(153,76,0));
	//myG.fillRect();
	g2.draw(myG);
	g2.fill(myG);
	g2.setColor(Color.GREEN);
	// title
	g2.drawString("Disco Shovel at the Beach", 150,20);

       }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {	//dig a hole
		if (y >= 230) { dy = -5;}
		if (y <= 150) { dy = +5; }
		y+= dy;
            	panel.repaint();
            	Thread.sleep(50);
		if(y>215) Thread.sleep(100);
	


		
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

