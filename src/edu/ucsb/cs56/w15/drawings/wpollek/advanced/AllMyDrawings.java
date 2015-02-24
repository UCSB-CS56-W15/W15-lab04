package edu.ucsb.cs56.w15.drawings.wpollek.advanced;

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
 * @author Phill Conrad, Wesley Pollek
 * @version for CS56, lab06, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few train cars and cargo cars 
     */

    public static void drawPicture1(Graphics2D g2) {

	TrainCar t1 = new TrainCar(100,250,250,75);
	g2.setColor(Color.CYAN); g2.draw(t1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape t2= ShapeTransforms.translatedCopyOf(t1,250,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	
	CargoCar c1 = new CargoCar(40,600,420,100);
	CargoCar c2 = new CargoCar(460,600,200,100);
	
	g2.draw(c1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(c2);

	Shape c3= ShapeTransforms.translatedCopyOf(c1,620,0);
	g2.setColor(Color.RED); g2.draw(c3);
	Shape c4= ShapeTransforms.translatedCopyOf(c2,620,0);
	g2.setColor(Color.GREEN);
	g2.draw(c4);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
 
	g2.drawString("A few train cars by Wesley Pollek", 20,20);
    }


    /** Draw a picture with a train and a cargo train
     */
    public static void drawPicture2(Graphics2D g2) {

	
	TrainCar t1 = new TrainCar(50,200,125,40);
	TrainCar t2 = new TrainCar(175,200,60,40);
	TrainCar t3 = new TrainCar(235,200,50,40);
	TrainCar t4 = new TrainCar(285,200,100,40);
	
	g2.setColor(Color.RED);     g2.draw(t1);
	g2.setColor(Color.GREEN);   g2.draw(t2);
	g2.setColor(Color.BLUE);    g2.draw(t3);
	g2.setColor(Color.MAGENTA); g2.draw(t4);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
       	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	CargoCar c1 = new CargoCar(50,600,100,70);
	CargoCar c2 = new CargoCar(150,600,170,70);
	CargoCar c3 = new CargoCar(320,600,80,70);
	g2.setColor(Color.RED); g2.draw(c1);
	g2.setColor(Color.YELLOW); g2.draw(c2);
	g2.setColor(Color.GREEN); g2.draw(c3);
	
	Shape c1s = ShapeTransforms.scaledCopyOfLL(c1,1,1);
	c1s = ShapeTransforms.translatedCopyOf(c1,350,0);
	g2.setColor(Color.BLACK); g2.draw(c1s);

	c1s = ShapeTransforms.scaledCopyOfLL(c2,1,1);
	c1s = ShapeTransforms.translatedCopyOf(c2,350,0);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c1s); 
	c1s = ShapeTransforms.scaledCopyOfLL(c3,1,1);
	c1s = ShapeTransforms.translatedCopyOf(c3,350,0);
	g2.setColor(Color.BLUE); 
	g2.draw(c1s); 
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of train cars and cargo cars by Wesley Pollek", 20,20);
    }
  
    /** Draw a different picture with a few more trains
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A few more train cars by Wesley Pollek", 20,20);

	
	// Draw some coffee cups.
	
       TrainCar large = new TrainCar(100,150,225,150);
       CargoCar small = new CargoCar(20,150,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
