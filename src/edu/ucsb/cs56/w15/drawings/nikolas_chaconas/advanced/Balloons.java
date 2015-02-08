package edu.ucsb.cs56.w15.drawings.nikolas_chaconas.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of five balloons, connected by a string
      
   @author Nikolas Chaconas
   @version for CS56, Winter 15, UCSB
   
*/
public class Balloons extends GeneralPathWrapper implements java.awt.Shape {
    /**
       Constructor

       @param xCordBalloon, x coordinate of center of balloon
       @param yCordBalloon, y coordinate of center of balloon
       @param size, proportional multiplier for width radius of balloon 1 is small, 10 is large
       @param xCordString, x coordinate of bottom of string
       @param yCordString, y coordinate of bottom of string
     */
    public Balloons(double xCordBalloon, double yCordBalloon, double size, double xCordString, double yCordString) {
		
		double widthRadius = size*10;
		double lengthRadius = widthRadius*1.5;

		//make balloon part
		double newXCord = xCordBalloon;
		double newYCord = yCordBalloon;
		for(int i = 0; i<5; i++) {
			
			if(i<2){ xCordBalloon -= widthRadius*3; }
			else if (i==2) {		
				xCordBalloon +=widthRadius*6;
			}
			else { xCordBalloon += widthRadius*3; }

			//make top of balloon
			Ellipse2D.Double balloonEllipse = makeEllipse(xCordBalloon, yCordBalloon, widthRadius, lengthRadius);

		    
			//make triangle for bottom of balloon
			GeneralPath triangle = MakeTriangle(xCordBalloon,yCordBalloon, widthRadius, lengthRadius);
		
			//make string for balloon
			Line2D.Double balloonString =
			    new Line2D.Double (xCordBalloon,yCordBalloon+lengthRadius*1.1,
			                       xCordString,yCordString);

			GeneralPath EntireBalloon = this.get();
			EntireBalloon.append(balloonEllipse,false);
			EntireBalloon.append(triangle, false);
			EntireBalloon.append(balloonString,false);
		
		}
	}

	/**
		MakeTriangle
		This is a function to make a small triangle at the bottom of the ellipse, to make it look more like a balloon
		@param xCordBalloon is the x coordinate of the balloon
		@param yCordBalloon is the y coordinate of the balloon
		@param widthRadius is the horizontal radius of the balloon
		@param lengthRadius is the vertical radius of the balloon
	*/
	public GeneralPath MakeTriangle(double xCordBalloon, double yCordBalloon, double widthRadius, double lengthRadius) {
		GeneralPath triangle = new GeneralPath();
		
			triangle.moveTo(xCordBalloon,yCordBalloon+lengthRadius);
			triangle.lineTo(xCordBalloon-widthRadius/5,yCordBalloon+lengthRadius*1.1);
			triangle.lineTo(xCordBalloon+widthRadius/5,yCordBalloon+lengthRadius*1.1);	
			triangle.lineTo(xCordBalloon,yCordBalloon+lengthRadius);
			return triangle;
	}
	
	/**
		MakeEllipse
		This is a function to make the balloon ellipses.
		@param xCordBalloon is the x coordinate of the balloon
		@param yCordBalloon is the y coordinate of the balloon
		@param widthRadius is the horizontal radius of the balloon
		@param lengthRadius is the vertical radius of the balloon
	*/

	public Ellipse2D.Double makeEllipse(double xCordBalloon, double yCordBalloon, double widthRadius, double lengthRadius) {
		Ellipse2D.Double balloonEllipse = 
			new Ellipse2D.Double(
				xCordBalloon - widthRadius, 
				yCordBalloon - lengthRadius, 
				widthRadius*2, lengthRadius*2
			);
			return balloonEllipse;
	}
	
	
   

}
