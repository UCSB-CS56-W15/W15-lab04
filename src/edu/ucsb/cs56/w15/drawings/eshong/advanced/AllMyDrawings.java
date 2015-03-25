package edu.ucsb.cs56.w15.drawings.eshong.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles

import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import java.awt.geom.Point2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Ellipse2D.Double;

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

    /** Draw a blank domino 
     */
    public static void drawPicture1(Graphics2D g2) {
	Domino d1 = new Domino(100,250,30,70);
	g2.setColor(Color.BLACK); g2.draw(d1);

	// Make a blue domino that's half the size,
	// and moved over 150 pixels in x direction

	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(Color.BLUE); g2. draw(d2);

	// Make a domino that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);

	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7));
	g2.draw(d2);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few dominos by Elliott Hong", 20,20);
    }


    /** Draw a few numbered dominos
     */
    public static void drawPicture2(Graphics2D g2) {

	double dominoOneX = 15;
	double dominoTwoX = 50;
	double dominoThreeX = 100;

	double dominoY = 50;

	double dominoOneWidth = 30;
	double dominoTwoWidth = 40;
	double dominoThreeWidth = 50;

	double dominoOneHeight = 60;
	double dominoTwoHeight = 80;
	double dominoThreeHeight = 100;

	// Draw some DominoPieces
	DominoPiece first = new DominoPiece(dominoOneX, dominoY, dominoOneWidth, dominoOneHeight);
	DominoPiece second = new DominoPiece(dominoTwoX, dominoY, dominoTwoWidth, dominoTwoHeight);
	DominoPiece third = new DominoPiece(dominoThreeX, dominoY, dominoThreeWidth, dominoThreeHeight);

	g2.setColor(Color.RED);
	g2.draw(first);

	g2.setColor(Color.GREEN);
	g2.draw(second);

	g2.setColor(Color.BLUE);
	g2.draw(third);


	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

	Stroke orig=g2.getStroke();

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few dominos by Elliott Hong", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Elliott Hong", 20,20);

	
	// Draw some coffee cups.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
