package edu.ucsb.cs56.w15.drawings.marshallnaito.advanced;

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
 * A class with static methods for drawing various pictures of poles and stoplights
 * 
 * @author P. Conrad
 * @author Marshall Naito
 * @version for CS10, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few poles and stoplights
     */

    public static void drawPicture1(Graphics2D g2) {

	     StopLight light1 = new StopLight(100,200, 16, 120);
	     g2.setColor(Color.BLACK);
	     g2.draw(light1);

	     Shape l1 = ShapeTransforms.rotatedCopyOf(light1,Math.PI/4.0);
	     l1 = ShapeTransforms.translatedCopyOf(l1,300,45);
	     g2.setColor(Color.CYAN); 
	     g2.draw(l1);

		 Pole pole1 = new Pole(150,400, 16, 120);
	     g2.setColor(Color.BLUE);
	     g2.draw(pole1);


	g2.drawString("A few poles and lights by Marshall Naito", 20,20);
    }


    /** Draw a picture of a few stoplights
     */
    public static void drawPicture2(Graphics2D g2) {
	
	     
	     StopLight light1 = new StopLight(150,200, 16, 120);
	     g2.setColor(Color.BLACK);
	     g2.draw(light1);


	     StopLight light2 = new StopLight(200, 400, 8, 60);
	     g2.setColor(Color.GREEN);
	     g2.draw(light2);

	     Shape l1 = ShapeTransforms.rotatedCopyOf(light1,Math.PI);
	     g2.setColor(Color.CYAN); 
	     g2.draw(l1);
         g2.drawString("A bunch of Poles by Marshall Naito", 20,20);

     }
  
    /** Draw a picture of a few poles
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	 g2.drawString("A bunch of Poles by Marshall Naito", 20,20);
     
     Pole pole1 = new Pole(100,200, 16, 120);
     g2.setColor(Color.BLACK);
     g2.draw(pole1);

	 Shape p1 = ShapeTransforms.rotatedCopyOf(pole1,Math.PI/4.0);
    // p1 = ShapeTransforms.translatedCopyOf(pole1,180,50);
     g2.setColor(Color.GREEN);
     g2.draw(p1);

     Pole pole2 = new Pole(200, 400, 32, 60);
     g2.setColor(Color.PINK);
     g2.draw(pole2);
       
    }
    

}
