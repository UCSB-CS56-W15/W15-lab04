package edu.ucsb.cs56.w15.drawings.salolivares.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few computers
     */

    public static void drawPicture1(Graphics2D g2) {

	DesktopComputer h1 = new DesktopComputer(50,150,100,125);
	g2.setColor(Color.RED); g2.draw(h1);
	
	// Make a blue computer that's half the size,
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLUE); g2.draw(h2);
	
	// Here's a computer that's 3x as big
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,3,3);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x011234444));
	g2.draw(h2); 
	
	// Draw two houses with Windows
	
	DesktopComputerWithMonitor hw1 = new DesktopComputerWithMonitor(75,300,40,75);
	DesktopComputerWithMonitor hw2 = new DesktopComputerWithMonitor(300,300,70,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few computers by Sal Olivares", 20,20);
    }


    /** Draw a picture with a few computers!!!
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some computers
	
	DesktopComputer large = new DesktopComputer(100,50,225,150);
	DesktopComputer smallCC = new DesktopComputer(20,50,40,30);
	DesktopComputer tallSkinny = new DesktopComputer(20,150,20,40);
	DesktopComputer shortFat = new DesktopComputer(20,250,40,20);

	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	DesktopComputerWithMonitor h1 = new DesktopComputerWithMonitor(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black computer that's half the size,
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,300,-200);
	g2.setColor(Color.BLACK); g2.draw(h2);

	// make a computer thats 4x as big and moved down
	h2 = ShapeTransforms.scaledCopyOfLL(h2,3,3);
	h2 = ShapeTransforms.translatedCopyOf(h2,-80,200);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two computers with monitors
	
	DesktopComputer hw1 = new DesktopComputer(50,350,40,75);
	DesktopComputerWithMonitor hw2 = new DesktopComputerWithMonitor(150,355,50,75);
		DesktopComputer c1 = new DesktopComputerWithMonitor(375,355,50,75);

	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second computer 20 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, -Math.PI/12);
		Shape hw4 = ShapeTransforms.rotatedCopyOf(c1, Math.PI/12);

	g2.draw(hw3);
		g2.setColor(new Color(0x57184));
		g2.draw(hw4);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Computers by Sal Olivares", 20,20);
    }
  
    /** Draw a different picture with a few computers
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A few computers by Sal Olivares", 20,20);

	
	// Draw some computers
		DesktopComputer one = new DesktopComputer(200,50,100,150);
		DesktopComputerWithMonitor two = new DesktopComputerWithMonitor(100, 230, 100, 200);

       g2.setColor(Color.LIGHT_GRAY);     g2.draw(one);
       g2.setColor(Color.MAGENTA);   g2.draw(two);
       
       
    }
    

}
