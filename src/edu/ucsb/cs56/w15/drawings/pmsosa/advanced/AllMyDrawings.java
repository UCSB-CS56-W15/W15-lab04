package edu.ucsb.cs56.w15.drawings.pmsosa.advanced;

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
import java.util.Random;


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
    /** Draw a picture with a few faces 
     */

    public static void drawPicture1(Graphics2D g2) {
    
    FaceWithExtras fe1 = new FaceWithExtras(50,50,50,50);
    FaceWithExtras fe2 = new FaceWithExtras(150,150,60,60);
    Face f1 = new Face(250,250,70,70);
    Face f2 = new Face(350,350,80,80);
    Shape fe3 = ShapeTransforms.scaledCopyOfLL(fe1,5,10);
	fe3 = ShapeTransforms.translatedCopyOf(fe3,450,450);
    
    g2.setColor(Color.ORANGE); g2.draw(fe1);
    g2.setColor(Color.BLUE); g2.draw(fe2);
    g2.setColor(Color.RED); g2.draw(f1);
    g2.setColor(Color.GREEN); g2.draw(f2);
    g2.setColor(Color.BLACK); g2.draw(fe3);
    g2.drawString("A few faces by Pedro M. Sosa", 20,20);
    
    /*
    Random rand = new Random();
    for (int i = 0; i < 4; i++){
        Face h1 = new Face(100+rand.nextInt(100),100+rand.nextInt(100),10+rand.nextInt(100),10+rand.nextInt(100));
        Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,1+rand.nextInt(4),1+rand.nextInt(4));
        //Stroke stroke = new BasicStroke (1.0f*rand.nextInt(4), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
        g2.setColor(Color.BLACK);
        //g2.setStroke(stroke);
        g2.draw(h2); 
    }
    */
    
    /*
	Face h1 = new Face(10,50,50,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black Face that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,1,2);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.RED); g2.draw(h2);
	
	// Here's a Face that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,3);
	h2 = ShapeTransforms.translatedCopyOf(h2,180,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.BLUE); 
	g2.draw(h2); 
	
	// Draw two faces with Windows
	
	FaceWithExtras hw1 = new FaceWithExtras(50,350,40,75);
	FaceWithExtras hw2 = new FaceWithExtras(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
    */
	
    }


    /** Draw a picture with a few faces and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

    FaceWithExtras fe1 = new FaceWithExtras(20,30,50,40);
    FaceWithExtras fe2 = new FaceWithExtras(400,400,74,51);
    Face f1 = new Face(250,100,40,200);
    Face f2 = new Face(101,200,75,100);
    Shape fe3 = ShapeTransforms.scaledCopyOfLL(fe1,0.5,0.5);
	fe3 = ShapeTransforms.translatedCopyOf(fe3,300,300);
    
    g2.setColor(Color.ORANGE); g2.draw(fe1);
    g2.setColor(Color.BLUE); g2.draw(fe2);
    g2.setColor(Color.RED); g2.draw(f1);
    g2.setColor(Color.GREEN); g2.draw(f2);
    g2.setColor(Color.BLACK); g2.draw(fe3);
    g2.drawString("A few faces by Pedro M. Sosa", 20,20);
    
    /*
	// Draw some coffee cups.
	CoffeeCup large = new CoffeeCup(100,50,225,150);
	CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
	CoffeeCup tallSkinny = new CoffeeCup(20,150,20,40);
	CoffeeCup shortFat = new CoffeeCup(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Face h1 = new Face(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black Face that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a Face that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two faces with Windows
	
	FaceWithExtras hw1 = new FaceWithExtras(50,350,40,75);
	FaceWithExtras hw2 = new FaceWithExtras(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second Face 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Coffee Cups and a few faces by Pedro M. Sosa & Phill Conrad", 20,20);
    */
    }
  
    /** Draw a different picture with a few faces and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {

    FaceWithExtras fe1 = new FaceWithExtras(50,50,40,40);
    FaceWithExtras fe2 = new FaceWithExtras(100,100,40,75);
    Face f1 = new Face(150,100,40,75);
    Face f2 = new Face(150,200,75,100);
    Shape fe3 = ShapeTransforms.scaledCopyOfLL(fe1,5,5);
	fe3 = ShapeTransforms.translatedCopyOf(fe3,300,300);
    
    g2.setColor(Color.ORANGE); g2.draw(fe1);
    g2.setColor(Color.BLUE); g2.draw(fe2);
    g2.setColor(Color.RED); g2.draw(f1);
    g2.setColor(Color.GREEN); g2.draw(f2);
    g2.setColor(Color.BLACK); g2.draw(fe3);
    g2.drawString("A few faces by Pedro M. Sosa", 20,20);

	

       
       
    }
    

}
