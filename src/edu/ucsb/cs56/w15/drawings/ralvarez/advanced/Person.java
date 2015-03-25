package edu.ucsb.cs56.w15.drawings.ralvarez.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/** A drawing of a person that implements the Shape interface to be drawn
 


    @author Richard Alvarez
    @version cs56 2/12/15
*/
public class Person extends GeneralPathWrapper implements Shape {

    /**
       Constructor

       @param x x coord of upper left corner of the drawing
       @param y y coord of upper left corner of the drawing
       @param width Widths of the box to draw in
       @param height Height of the box to draw in
     */


    public Person(double x, double y, double width, double height){
	double diam = ( width/3);
	double rad = (diam/2);
	double Jx =(x + width/2 ); //x coordinate of the neck joint
	double Jy =(y+diam);      //y coordinate of the neck joint

	//make the circle for the head
	Circle head = 
	    new Circle (x+diam+rad, y+rad, rad);

	//make the body 
        Line2D.Double body = 
            new Line2D.Double (Jx, Jy, Jx, Jy+(.60* height));
	
	//make the right arm
        Line2D.Double Rarm = 
            new Line2D.Double (Jx, Jy+.1*height, Jx+rad, Jy+diam+.1*height);
	
	//make the left arm
        Line2D.Double Larm = 
            new Line2D.Double (Jx, Jy+ .1*height, Jx-rad , Jy+diam+.1*height);


	//make the right leg
        Line2D.Double Rleg = 
            new Line2D.Double (Jx, Jy+.60*height, Jx+rad, Jy+diam+.60*height);

	//make the left leg
        Line2D.Double Lleg = 
            new Line2D.Double (Jx, Jy+.60*height, Jx-rad, Jy+diam+.60*height);
	
	//join the whole figure
	GeneralPath Figure = this.get();
	Figure.append(head, false);
	Figure.append(body, false);
	Figure.append(Rarm, false);
	Figure.append(Larm, false);
	Figure.append(Rleg, false);
	Figure.append(Lleg, false);
	
    }
    public Person(double x, double y, double width, double height, int i){
	double diam = ( width/3);
	double rad = (diam/2);
	double Jx =(x + width/2 ); //x coordinate of the neck joint
	double Jy =(y+diam);      //y coordinate of the neck joint
	Line2D.Double Rarm = null;


	//make the circle for the head
	Circle head = 
	    new Circle (x+diam+rad, y+rad, rad);

	//make the body 
        Line2D.Double body = 
            new Line2D.Double (Jx, Jy, Jx, Jy+(.60* height));
	
	//make the right arm
        if (i == 0){
	    Rarm = 
		new Line2D.Double (Jx, Jy+.1*height, Jx+rad, Jy+diam+.1*height);
	}
	else 
	    {
		Rarm = 
            new Line2D.Double (Jx, Jy+.1*height, Jx+.7*diam, Jy-rad+.1*height);
	    }
	//make the left arm
        Line2D.Double Larm = 
            new Line2D.Double (Jx, Jy+ .1*height, Jx-rad , Jy+diam+.1*height);


	//make the right leg
        Line2D.Double Rleg = 
            new Line2D.Double (Jx, Jy+.60*height, Jx+rad, Jy+diam+.60*height);

	//make the left leg
        Line2D.Double Lleg = 
            new Line2D.Double (Jx, Jy+.60*height, Jx-rad, Jy+diam+.60*height);
	
	//join the whole figure
	GeneralPath Figure = this.get();
	Figure.append(head, false);
	Figure.append(body, false);
	Figure.append(Rarm, false);
	Figure.append(Larm, false);
	Figure.append(Rleg, false);
	Figure.append(Lleg, false);
	if (i != 0){
	    Line2D.Double RarmTwo = 
		new Line2D.Double (Jx+.7*diam, Jy-rad+.1*height, 
				   Jx + .8*diam, Jy-1.1*diam+.1*height );
	    Figure.append(RarmTwo, false);
	    }
    }




}
