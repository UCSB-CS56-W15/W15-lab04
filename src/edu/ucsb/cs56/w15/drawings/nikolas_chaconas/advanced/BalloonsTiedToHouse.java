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
   A drawing of a bunch of balloons made by my Balloons class being held by a stick figure
   BalloonsTiedToHouse extends my Balloons class
   @author Nikolas Chaconas
   @version for CS56, Winter 15, UCSB
   
*/
public class BalloonsTiedToHouse extends Balloons implements Shape
{

	public BalloonsTiedToHouse(double x, double y, double size, double xCord, double yCord) {
		
		super(x,y,size,xCord,yCord);
		

		
		Rectangle2D.Double base =
	    		new Rectangle2D.Double(xCord, yCord, size*20, size*20);
		
		GeneralPath HousePart = this.get();
		HousePart.append(base,false);
		

		}


    

}
