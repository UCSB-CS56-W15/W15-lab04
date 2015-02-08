package edu.ucsb.cs56.w15.drawings.nikolas_chaconas.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color;
import java.awt.Graphics2D;
// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a bunch of balloons made by my Balloons class tied to a house
   BalloonsTiedToHouse extends my Balloons class
   @author Nikolas Chaconas
   @version for CS56, Winter 15, UCSB
   
*/
public class BalloonsTiedToHouse extends Balloons implements Shape
{
	/**
	       Constructor to call Balloons and to also draw the house for balloons to be attached to.
	       @param x x coordinate of center of balloon
	       @param y y coordinate of center of balloon
	       @param size proportional multiplier for width radius of balloon 1 is small, 10 is large
	       @param xCord x coordinate of bottom of string
	       @param yCord y coordinate of bottom of string
	*/
		
	public BalloonsTiedToHouse(double x, double y, double size, double xCord, double yCord) {
		
		super(x,y,size,xCord,yCord);
		
		double length = size*250;
		double width = size*200;

		//make top of house using inheritted class MakeTriangle from Balloons.java
		GeneralPath topOfHouse = MakeTriangle(x, yCord-length, width, length);
		
		//base of house x coordinate
		double basey = yCord-length+1.1*length;
		//base of house y coordinate
		double basex = x-width/5;
		
		//height of base of house
		double baseHeight = width*1/3;

		//width of base of house
		double baseWidth = width*2/5;

		Rectangle2D.Double base =
	    		new Rectangle2D.Double(basex, basey,baseWidth, baseHeight);

		Rectangle2D.Double door = 
			new Rectangle2D.Double(basex+baseWidth*1/3,basey+baseHeight*1/2, baseWidth*1/3, baseHeight*1/2);


		GeneralPath House = this.get();
		House.append(topOfHouse,false);
		House.append(base,false);
		House.append(door,false);
		

		}


    

}
