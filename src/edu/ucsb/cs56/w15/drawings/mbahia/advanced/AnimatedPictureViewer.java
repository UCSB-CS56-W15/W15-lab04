package edu.ucsb.cs56.w15.drawings.mbahia.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import java.util.Random;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = -150;
    private int y = -125;
    private int xCoor = 200;
    private int yCoor = 200;
    private int xAdder = 10;
    private int yAdder = 10;
    private double rotate = Math.PI;
   
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(700,700);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
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

	g2.setColor(new Color(0xFFFF00));
	g2.fillRect(0,0,this.getWidth(), this.getHeight());
	
	// rotates and turns in all corners
	g2.setColor(Color.PINK);
	IceCreamConeWithToppings tempIC = new IceCreamConeWithToppings(100, 100, 100, 100);
	Shape IC = ShapeTransforms.translatedCopyOf(tempIC, 100, 100);
	Shape IC2 = ShapeTransforms.rotatedCopyOf(IC, rotate);
	IC2 = ShapeTransforms.translatedCopyOf(IC2, x, y);
	g2.draw(IC2);

	// rotates just in circle in center of screen
	// and changes colors of ice cream cone
	int red = (int)(Math.random()*256);
	int green = (int)(Math.random()*256);
	int blue = (int)(Math.random()*256);
	Color randomColor = new Color(red, green, blue);
	g2.setColor(randomColor);
	Stroke thickLine = new BasicStroke(1.75f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
	g2.setStroke(thickLine);
	IceCreamConeWithToppings tempIC2 = new IceCreamConeWithToppings(100, 100, 100, 100);
	Shape IC4 = ShapeTransforms.rotatedCopyOf(tempIC2, -rotate);
	IC4 = ShapeTransforms.translatedCopyOf(IC4, xCoor, yCoor);
	g2.draw(IC4);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
	      if (y == -125) {
		      x = x + xAdder; 
	      }
	      if (x > 349) {
		  if (y <= 350) {
		      y = y + yAdder; 
		  }
	      }
	      if (y > 349) {
		  if (x != -150) {
		      x = x - xAdder; }
	      }
	      if (x == -150) {
		  if (y != -125) {
		      y = y - yAdder;
		  }
	      }
	      
	      rotate = rotate + (Math.PI)/16.0;	      
	      panel.repaint();
	      Thread.sleep(100);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
