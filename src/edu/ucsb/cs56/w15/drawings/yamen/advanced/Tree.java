package edu.ucsb.cs56.w15.drawings.yamen.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a tree that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Yamen Alghrer 
   @version for CS56, Winter 15, UCSB
   
*/
public class Tree extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of Tree
       @param y y coord of upper left corner of Tree
       @param width width of the Tree
       @param height of tree (The whole tree)
     */
    public Tree(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.  
        // Make the bottom of the tree
        
	double treeBarkHeight = height * .30;
	double treeBarkWidth = width * .25;
	double treeTopHeight = height - treeBarkHeight;
	double treeTopWidth = width - treeBarkWidth;
	
        Rectangle2D.Double bottom = 
            new Rectangle2D.Double(x + treeTopWidth/3, y,
                          treeBarkWidth, treeBarkHeight);
                          
        
        Ellipse2D.Double top = 
            new Ellipse2D.Double (x,y - treeTopHeight,
                             treeTopWidth, treeTopHeight);

        // put the tree together
       
        GeneralPath wholeTree = this.get();
        wholeTree.append(bottom, false);
        wholeTree.append(top, false); 
        
    }

}
