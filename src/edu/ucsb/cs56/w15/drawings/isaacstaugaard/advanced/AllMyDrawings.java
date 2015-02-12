package edu.ucsb.cs56.w15.drawings.isaacstaugaard.advanced;

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
 * @author Phill Conrad, Isaac Staugaard
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with backboard 
     */

    public static void drawPicture1(Graphics2D g2) {

	BasketballHoop h1 = new BasketballHoop(130,100,400,250);
	g2.setColor(Color.RED);
	g2.draw(h1);
	
	//Make a black backboard that's half the size, 
	// and moved over 50 pixels in -x direction and 40 pixels in y direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,-50,40);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a backboard that's 1.5x as big 
	// and moved over 30 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,1.5,1.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,30,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw backboard with basketball and man dunking!
	
	BasketballHoopWithBall b1 = new BasketballHoopWithBall(50,50,100,100);
		 
	g2.draw(b1);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A backboard by Isaac Staugaard", 20,20);
    }


    /** Draw a picture with basketball hoops!
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw lots of basketball hoops.
	
	BasketballHoop nbaSize = new BasketballHoop(100,50,225,150);
	BasketballHoop kidSize = new BasketballHoop(20,50,40,30);
	BasketballHoop tallHoop = new BasketballHoop(20,150,20,40);
	BasketballHoop shortHoop = new BasketballHoop(20,250,40,20);
	BasketballHoop rightHoop = new BasketballHoop(450,50,100,100);
	BasketballHoop lowerHoop = new BasketballHoop(450,290,150,150);
	BasketballHoop middleHoop = new BasketballHoop(180,140,200,200);
	
	g2.setColor(Color.RED);     g2.draw(nbaSize);
	g2.setColor(Color.GREEN);   g2.draw(kidSize);
	g2.setColor(Color.BLUE);    g2.draw(tallHoop);
	g2.setColor(Color.MAGENTA); g2.draw(shortHoop);
	g2.setColor(Color.BLACK);   g2.draw(rightHoop);
	g2.setColor(Color.YELLOW);  g2.draw(lowerHoop);
	g2.setColor(Color.ORANGE);  g2.draw(middleHoop);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("The basketball courts by Isaac Staugaard", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A frame of basketball hoops by Isaac Staugaard", 20,20);

	//Draw border of basketball hoops
	BasketballHoop hoopOne = new BasketballHoop(25,25,75,75);            //top left corner
	BasketballHoop hoopTwo = new BasketballHoop(25,125,75,75);           //left edge
	BasketballHoop hoopThree = new BasketballHoop(25,225,75,75);         //left edge
  	BasketballHoop hoopFour = new BasketballHoop(25,325,75,75);          //bottom left corner
  	BasketballHoop hoopFive = new BasketballHoop(125,25,75,75);          //top edge
  	BasketballHoop hoopSix = new BasketballHoop(225,25,75,75);           //top edge
  	BasketballHoop hoopSeven = new BasketballHoop(325,25,75,75);         //top edge
  	BasketballHoop hoopEight = new BasketballHoop(425,25,75,75);         //top edge
  	BasketballHoop hoopNine = new BasketballHoop(525,25,75,75);           //top right corner
   	BasketballHoop hoopTen = new BasketballHoop(525,125,75,75);       //right edge
  	BasketballHoop hoopEleven = new BasketballHoop(525,225,75,75);       //right edge
	BasketballHoop hoopTwelve = new BasketballHoop(525,325,75,75);     //bottom right corner
  	BasketballHoop hoopThirteen = new BasketballHoop(125,325,75,75);     //bottom edge
  	BasketballHoop hoopFourteen = new BasketballHoop(225,325,75,75);      //bottom edge
  	BasketballHoop hoopFifteen = new BasketballHoop(325,325,75,75);      //bottom edge
	BasketballHoop hoopSixteen = new BasketballHoop(425,325,75,75);    //bottom edge
	BasketballHoop hoopSeventeen = new BasketballHoop(525,325,75,75);    //bottom right corner



       g2.setColor(Color.BLACK);     g2.draw(hoopOne);
       g2.setColor(Color.BLACK);     g2.draw(hoopTwo);
       g2.setColor(Color.BLACK);     g2.draw(hoopThree);
       g2.setColor(Color.BLACK);     g2.draw(hoopFour);
       g2.setColor(Color.BLACK);     g2.draw(hoopFive);
       g2.setColor(Color.BLACK);     g2.draw(hoopSix);
       g2.setColor(Color.BLACK);     g2.draw(hoopSeven);
       g2.setColor(Color.BLACK);     g2.draw(hoopEight);
       g2.setColor(Color.BLACK);     g2.draw(hoopNine);
       g2.setColor(Color.BLACK);     g2.draw(hoopTen);
       g2.setColor(Color.BLACK);     g2.draw(hoopEleven);
       g2.setColor(Color.BLACK);     g2.draw(hoopTwelve);
       g2.setColor(Color.BLACK);     g2.draw(hoopThirteen);
       g2.setColor(Color.BLACK);     g2.draw(hoopFourteen);
       g2.setColor(Color.BLACK);     g2.draw(hoopFifteen);
       g2.setColor(Color.BLACK);     g2.draw(hoopSixteen);
       g2.setColor(Color.BLACK);     g2.draw(hoopSeventeen);

       //Draw center hoop with man dunking
       BasketballHoopWithBall centerHoop = new BasketballHoopWithBall(230,130,125,125);
       Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);     
       g2.setStroke(thick);
       g2.setColor(Color.RED);
       g2.draw(centerHoop);
       
    }
    

}
