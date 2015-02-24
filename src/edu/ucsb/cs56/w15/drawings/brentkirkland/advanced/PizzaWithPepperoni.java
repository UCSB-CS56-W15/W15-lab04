package edu.ucsb.cs56.w15.drawings.brentkirkland.advanced;
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
import java.awt.geom.Ellipse2D;

//random peps
import java.util.Random;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Pizza
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class PizzaWithPepperoni extends Pizza implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public PizzaWithPepperoni(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	//A pizza never has the same amount of pepperonis so we are going to make
	//the a random ammount between 50-200.
	
	Random r = new Random();
	int i1 = r.nextInt(200 - 50 + 1) + 50;
	
	 
        GeneralPath wholePizza = this.get();

	//create a temp cheese circle to test if a pepperoni exist ontop of cheese
	Ellipse2D.Double tempCheese = new Ellipse2D.Double(x - width*0.85/2, y-height*0.85/2, width * 0.85, height*0.85);	

	Ellipse2D.Double z;
	double x0;
	double x1; 
	double y0; 
	double y1; 
	double i2; 
	double i3;
	//add random pepperonis to GeneralPath
	//WARNING SOME CAN EASILY MISS THE CHEESE AND WONT MAKE IT ONTO THE PIZZA :)
	for (int i = 0; i < i1; i++){

		x0 = x - width*0.85;
     	   	x1 = x + width*0.85;
       		y0 = y - height*0.85;
       		y1 = y + height*0.85;
        	// x coordinate
         	i2 = r.nextDouble()*(x1-x0) + x0;
        	//y coordinate
       		i3 = r.nextDouble()*(y1-y0) + y0;

		if (tempCheese.contains(i2, i3, width*0.05, height * 0.05)){
			z = new Ellipse2D.Double(i2,i3,width*0.05, height*0.05);
			wholePizza.append(z, false);			
		}
	
			

	}
    }

}
