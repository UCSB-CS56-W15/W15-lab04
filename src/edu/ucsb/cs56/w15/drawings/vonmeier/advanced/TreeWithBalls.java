package edu.ucsb.cs56.w15.drawings.vonmeier.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Tree
      
   @author Ishi von Meier 
   @version for CS56, W15, UCSB, 02/20/2015
   
*/
public class TreeWithBalls extends Tree implements Shape
{
    /**
     * Constructor for objects of class TreeWithBalls
     */
    public TreeWithBalls(double x, double y, double width, double height)
    {
	// construct the basic tree shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	

	double startX = x + 0.25 * width;
	double startY = y + 0.8 * height;
	double winHt =  0.25 * height;
	double xRad = width/20;
	double yRad = height/20;
	
	Line2D.Double leftSide = new Line2D.Double (startX, startY, startX, startY + .75*yRad);
	Line2D.Double rightSide = new Line2D.Double (startX+xRad, startY, startX+xRad, startY + .75*yRad);
	
	Arc2D leftNut=new Arc2D.Double(startX-.5*xRad, startY+.75*yRad, xRad, yRad, 90, 270,  Arc2D.OPEN);
  	Arc2D rightNut=new Arc2D.Double(startX+.5*xRad, startY+.75*yRad, xRad, yRad, 90, -270,  Arc2D.OPEN);


	
	// add the balls to the tree
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeTree = this.get();
        wholeTree.append(leftSide, false);
        wholeTree.append(rightSide, false);
        wholeTree.append(leftNut, false); 
        wholeTree.append(rightNut, false); 
    }

}
