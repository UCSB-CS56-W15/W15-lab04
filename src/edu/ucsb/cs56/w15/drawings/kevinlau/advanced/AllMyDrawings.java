package edu.ucsb.cs56.w15.drawings.kevinlau.advanced;

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
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	// Title
	g2.drawString("Bunch of TVs in different colors, by Kevin Lau", 20,20);
	
	// Draw some tvs.
	
       tv tv1 = new tv(100,50,225,150);
       tvWithTable tv2 = new tvWithTable(400,200,50,50);
       tvWithTable tv3 = new tvWithTable(450,50,150,150);
       tv tv4 = new tv(10,250,300,100);
       tvWithTable tv5 = new tvWithTable(200,200,400,400);

       //rotate
       Shape rotate = ShapeTransforms.rotatedCopyOf(tv1, Math.PI/4.0);
       Shape rotate2 = ShapeTransforms.rotatedCopyOf(tv2, Math.PI/3.0);
       Shape rotate3 = ShapeTransforms.rotatedCopyOf(tv3, Math.PI*1.5);
 
       g2.setColor(Color.BLUE);     
       g2.draw(rotate);
       g2.draw(rotate2);
       g2.setColor(Color.GREEN);  
       g2.draw(rotate3);  
       g2.draw(tv4);
       g2.setColor(Color.RED);  
       g2.draw(tv5);
    }

    public static void drawPicture2(Graphics2D g2) {

	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Bunch of TVs in different colors, by Kevin Lau", 20,20);
	
       tv tv1 = new tv(100,300,250,150);
       tvWithTable tv2 = new tvWithTable(460,100,200,110);
       tvWithTable tv3 = new tvWithTable(300,50,100,200);
       tv tv4 = new tv(10,100,150,100);
       tvWithTable tv5 = new tvWithTable(200,190,300,150);
	
	g2.setColor(Color.RED);     g2.draw(tv1);
	g2.setColor(Color.GREEN);   g2.draw(tv2);
	g2.setColor(Color.BLUE);    g2.draw(tv3);
	g2.setColor(Color.MAGENTA); g2.draw(tv4);
	g2.draw(tv5);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(tv1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	g2.draw(tv5);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(tv4, Math.PI/4.0);

	g2.draw(hw3);
      
    }


    public static void drawPicture3(Graphics2D g2) {

	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Random TVs, by Kevin Lau", 20,20);
	
       tv tv1 = new tv(100,300,150,100);
       tvWithTable tv2 = new tvWithTable(460,100,150,100);
       tvWithTable tv3 = new tvWithTable(300,50,150,100);
       tv tv4 = new tv(10,100,150,100);
       tvWithTable tv5 = new tvWithTable(200,190,150,100);
	
       g2.setColor(new Color(0x8F00FF));     
       g2.draw(tv1);
       g2.draw(tv2);
       g2.setColor(Color.GREEN);  
       g2.draw(tv3);  
       // We'll draw this with a thicker stroke
       Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	g2.draw(tv4);
	g2.setColor(Color.RED);  
	g2.draw(tv5);
           
    }
}
