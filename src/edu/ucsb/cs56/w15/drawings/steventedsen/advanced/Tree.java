package edu.ucsb.cs56.w15.drawings.steventedsen.advanced;
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
   A vector drawing of a Christmas Tree that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Steven Tedsen
   @version for CS56, Winter 15, UCSB
   
*/
public class Tree extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of tree trunk
       @param y y coord of lower left corner of tree trunk
       @param width width of the bottom of the tree
       @param height height of tree
     */
    public Tree(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        double trunkWidth = .2*width;
        double trunkHeight = .2 * height;
        double treeHeight = height - trunkHeight;
        
        double trunkUpperLeftY = y + treeHeight;
        
        // Make the tree trunk
        
        Rectangle2D.Double Trunk = 
            new Rectangle2D.Double(x, trunkUpperLeftY ,
                          trunkWidth, trunkHeight);
                          
        // make the tree.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double lefttree = 
            new Line2D.Double (x - width/3.0, y + treeHeight,
                               x + trunkWidth/2.0, y);
                               
        Line2D.Double righttree =
            new Line2D.Double (x + trunkWidth/2.0, y,
                               x + trunkWidth + width/3.0, y + treeHeight);
	Line2D.Double bottomtree = new Line2D.Double (x - width/3.0, y + treeHeight, x + trunkWidth + width/3.0, y + treeHeight);

        // put the whole tree together
       
        GeneralPath wholeTree = this.get();
        wholeTree.append(Trunk, false);
        wholeTree.append(lefttree, false);
       wholeTree.append(righttree, false); 
       wholeTree.append(bottomtree, false);   
    }

}
