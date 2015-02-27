package edu.ucsb.cs56.w15.drawings.triptisinghal.advanced;

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
    /** Draw a picture with a few Ants 
     */

    public static void drawPicture1(Graphics2D g2) {

	Ant a1 = new Ant(100,250,50);
	g2.setColor(Color.BLUE); 
	g2.draw(a1);
	
	// Make a red ant that's a quarter of the size, 
	// and moved down 50 pixels in y direction

	Shape a2 = ShapeTransforms.scaledCopyOfLL(a1,0.25,0.25);
	a2 = ShapeTransforms.translatedCopyOf(a2,0,300);
	g2.setColor(Color.RED); g2.draw(a2);
	
	// Here's an ant that's 2x as big 
	// and moved over 150 more pixels to right.
	a2 = ShapeTransforms.scaledCopyOfLL(a2,2,2);
	a2 = ShapeTransforms.translatedCopyOf(a2,10,150);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(a2); 
	
	// Draw two ants with faces
	
	AntWithFace awf1 = new AntWithFace(500,350,40);
	AntWithFace awf2 = new AntWithFace(200,450,100);
	
	g2.draw(awf1);
	g2.setColor(new Color(0xAB274F)); g2.draw(awf2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few ants by Tripti Singhal", 20,20);
    }

    /** Draw a picture with a few Ants
     */


    public static void drawPicture2(Graphics2D g2) {

	// Draw some ants
	Ant a1 = new Ant(700,280,10);
	g2.setColor(Color.BLACK); g2.draw(a1);
	Shape a2 = ShapeTransforms.rotatedCopyOf(a1, Math.PI/4.0);
	Shape a3 = ShapeTransforms.translatedCopyOf(a2,150,0);
	g2.draw(a3);
	Shape a4 = ShapeTransforms.translatedCopyOf(a1,120,80);
	Shape a5 = ShapeTransforms.rotatedCopyOf(a4, Math.PI/3.0);
	g2.draw(a5);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	Ant dad = new AntWithFace(50,250,70);
	Ant mom = new AntWithFace(200,420,50);
	Ant baby1 = new AntWithFace(500,550,20);
	Ant baby2 = new AntWithFace(550,600,20);
	Ant baby3 = new AntWithFace(600,650,20);
	
	g2.setColor(Color.RED);     
	g2.draw(mom);
	g2.setColor(Color.BLUE);   
	g2.draw(dad);
	g2.setColor(Color.MAGENTA);
	g2.draw(baby1);
	g2.setColor(Color.MAGENTA); 
	g2.draw(baby2);
	g2.setColor(Color.MAGENTA); 
	g2.draw(baby3);
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A Mom ant, Dad ant, and their three baby ants by Tripti Singhal", 20,20);
    }


  
    /** Draw a different picture with a few ants
     */


    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of ants in a meeting", 20,20);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	// Draw some ants
	Ant a1 = new AntWithFace(200,600,50);
	Shape a1rot = ShapeTransforms.rotatedCopyOf(a1, Math.PI/2); //RED
	Ant a2 = new Ant(380,600,50);
	Shape a2rot = ShapeTransforms.rotatedCopyOf(a2, Math.PI/3.0); //GREEN	
	Ant a6 = new Ant(480,450,50);
	Shape a6rot = ShapeTransforms.rotatedCopyOf(a6, Math.PI/7.0); //CYAN

	Ant a4 = new Ant(520,120,50);
	Shape a4rot = ShapeTransforms.rotatedCopyOf(a4, Math.PI/0.55); //MAGENTA

	Ant a3 = new AntWithFace(520,300,50);
	Shape a3rot = ShapeTransforms.rotatedCopyOf(a3, Math.PI/0.5); //BLUE
	
	Ant a5 = new AntWithFace(50,200,50);
	Shape a5rot = ShapeTransforms.rotatedCopyOf(a5, Math.PI/0.85); //ORANGE
	
	Ant a7 = new AntWithFace(20,550,50);
	Shape a7rot = ShapeTransforms.rotatedCopyOf(a7, Math.PI/1.5); //PINK
       
	g2.setColor(Color.RED);     g2.draw(a1rot);
	g2.setColor(Color.GREEN);   g2.draw(a2rot);
	g2.setColor(Color.BLUE);   g2.draw(a3rot);
	g2.setColor(Color.MAGENTA);   g2.draw(a4rot);
	g2.setColor(Color.ORANGE);   g2.draw(a5rot);
	g2.setColor(Color.CYAN);   g2.draw(a6rot);
	g2.setColor(Color.PINK);   g2.draw(a7rot);
       
       
    }


}
