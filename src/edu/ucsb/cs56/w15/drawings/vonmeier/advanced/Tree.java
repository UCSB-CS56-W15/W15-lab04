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

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Tree that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Ishi von Meier
   @version for CS56, Winter 15, UCSB
   
*/
public class Tree extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of tree
       @param y y coord of lower left corner of tree
       @param width width of the tree
       @param height of tree (including stump and branches)
     */
    public Tree(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double stumpHeight = .2 * height;
        double branchesHeight = height - stumpHeight;
        
        double stumpUpperLeftY = y + branchesHeight;
        double stumpUpperLeftX = x + width/2 - width/16;
        
        // Make the first story
        
        Rectangle2D.Double stump = 
            new Rectangle2D.Double(stumpUpperLeftX, stumpUpperLeftY ,
                          width/8, stumpHeight);
                          
        // make the Branches.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftBranches = 
            new Line2D.Double (x, y + branchesHeight,
                               x + width/2.0, y);
                               
        Line2D.Double rightBranches =
            new Line2D.Double (x + width/2.0, y,
                               x + width, y + branchesHeight);
        Line2D.Double bottomBranches = 
        	new Line2D.Double (x, y + branchesHeight,
                               x + width, y + branchesHeight);

        // put the whole tree together
       
        GeneralPath wholeTree = this.get();
        wholeTree.append(stump, false);
        wholeTree.append(leftBranches, false);
        wholeTree.append(rightBranches, false);
        wholeTree.append(bottomBranches, false); 
        
    }

}
