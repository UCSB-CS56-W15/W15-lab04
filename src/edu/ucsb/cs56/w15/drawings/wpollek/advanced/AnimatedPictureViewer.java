package edu.ucsb.cs56.w15.drawings.wpollek.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel trainstation = new DrawPanel();
    
    private TrainCar traincar = new TrainCar(10, 100, 200, 40);
    
    Thread move;   
    
    private int x = -600;
    private int y = 100;
    
    private int dx = 10;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(trainstation);
      frame.setSize(1080,720);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("Choo Choo!");
          move = new Animation();
          move.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Waiting for Mouse");
          // Kill the animation thread
          move.interrupt();
          while (move.isAlive()){}
          move = null;         
          trainstation.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the TrainCar
          g2.setColor(Color.RED);
          TrainCar tcr = new TrainCar(x, y, 200, 40);
          g2.draw(tcr);
	  g2.setColor(Color.YELLOW);
          TrainCar tcy = new TrainCar(x+200, y, 200, 40);
          g2.draw(tcy);
	  g2.setColor(Color.GREEN);
          TrainCar tcg = new TrainCar(x+400, y, 200, 40);
          g2.draw(tcg);
	  
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
	    while(true){
		while (x<=1080) {
                    x += dx;                
		    trainstation.repaint();
		    Thread.sleep(50);
		    y+=1;
		    trainstation.repaint();
		    Thread.sleep(50);
		    y-=1;
		    trainstation.repaint();
		}
		x=-600;
		y=100;
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
