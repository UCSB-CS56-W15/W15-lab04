package edu.ucsb.cs56.w15.drawings.elswenson.advanced;

import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;

/**
  AnimatedPictureViewer animates a R4 droid, moving it side to side across the screen.
  @author Eric Swenson
  @version CS56W15Lab05
 */

public class AnimatedPictureViewer
{
	private DrawPanel panel = new DrawPanel();
	private int curX = 100, curY = 240, dx = 5;
	private double tilt = 2.0;
	Thread animation;
	
	public static void main (String[] args)
	{
		new AnimatedPictureViewer().go();
	}
	

	/**
 	 go() initializes the jframe and drawpanel, then starts the listener and animation.
	*/
	public void go()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel); //adds relevant panel

		frame.setSize(640,480); //as per requirements, nothing larger than 640x480 for turn-in
		frame.setVisible(true);
		
		frame.getContentPane().addMouseListener(new MouseAdapter() 
			{
				public void mouseEntered(MouseEvent e) 
				{
					animation = new Animation();
					animation.start();
				}
				
				public void mouseExited(MouseEvent e)
				{
					animation.interrupt();
					while(animation.isAlive()) {}
					animation = null;
					panel.repaint();
				}
			}); //end of addMouseListener
	} //end of go
	
	class DrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setColor(Color.BLACK);
			g2.fillRect(0,0,this.getWidth(), this.getHeight());
			
			g2.setColor(Color.RED);
			R4 oneR4 = new R4(curX, curY, 100, 100);
			Shape rotatedR4 = ShapeTransforms.rotatedCopyOf(oneR4, tilt * Math.PI);
			g2.draw(rotatedR4);
		}
	}
	
	class Animation extends Thread
	{
		public void run()
		{
			try
			{
				while(true)
				{
					if (curX <= 100 && tilt < 2.25)
						tilt = Math.min(2.25, tilt + 0.05);
					if (curX >= (panel.getWidth() - 200) && tilt > 1.75)
						tilt = Math.max(1.75, tilt - 0.05);

					if (tilt >= 2.25 && curX < (panel.getWidth() - 200))
						curX += dx;
					if (tilt <= 1.75 && curX > 100)
						curX -= dx;
					panel.repaint();
					Thread.sleep(50);
				}
			} catch (Exception ex) 
			{
				if (ex instanceof InterruptedException) {}
				else
				{
					ex.printStackTrace();
					System.exit(1);
				}
			}
		}
	}
}



					
