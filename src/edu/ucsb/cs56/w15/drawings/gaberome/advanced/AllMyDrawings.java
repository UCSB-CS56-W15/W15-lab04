package edu.ucsb.cs56.w15.drawings.gaberome.advanced;

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
 * @author Gabriel Romero 
 * @version for CS56, lab04, W15
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {
	/*Star s = new Star(400, 300, 200, 100);
	g2.draw(s);

       final double radius = 100;
       final double centerBottomX = 400;
       final double centerBottomY = 300;
       
       Ball DragonBall = 
           new Ball
           (
             centerBottomX,
             centerBottomY - radius,
             radius
           );
     
      g2.setColor(new Color(0xFF9900));
      g2.draw(DragonBall);
	*/
	DragonBall oneStar = new DragonBall(300,300,100);
	g2.setColor(new Color(0xFF9900));
        g2.draw(oneStar);
    }


    
    public static void drawPicture2(Graphics2D g2) {

	// Draw some Balls
	
	Ball red = new Ball(100, 100, 30);
	Ball green = new Ball(60,60,20);
	Ball blue = new Ball(600, 600, 200);
	Ball magenta = new Ball(30, 30, 10);
	
	g2.setColor(Color.RED);     g2.draw(red);
	g2.setColor(Color.GREEN);   g2.draw(green);
	g2.setColor(Color.BLUE);    g2.draw(blue);
	g2.setColor(Color.MAGENTA); g2.draw(magenta);
	
              
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
   
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Circles by Gabriel Romero", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Dragonballs by Gabriel Romero", 20,20);

	
	// Draw some coffee cups.
	
	DragonBall large = new DragonBall(600, 600, 200);
	DragonBall  small = new DragonBall(30, 30, 10);
	DragonBall medium = new DragonBall(150, 150, 50);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       g2.setColor(Color.BLACK);   g2.draw(medium);
       
    }
    

}
