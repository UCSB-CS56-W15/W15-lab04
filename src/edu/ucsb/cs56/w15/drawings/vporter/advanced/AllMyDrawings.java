package edu.ucsb.cs56.w15.drawings.vporter.advanced;

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
import java.util.ArrayList;
import java.util.Random;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Victor Porter
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Robots
     */

    public static void drawPicture1(Graphics2D g2) {

    //Create a single Robot
	Robot h1 = new Robot(100,250,100);
	g2.setColor(Color.CYAN); 
	g2.draw(h1);

	//Create a friend for the first Robot
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,.5,.5);
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Create two more advanced Robots
	
	RobotWithFeatures hw1 = new RobotWithFeatures(500,250,100,5);
	RobotWithFeatures hw2 = new RobotWithFeatures(400,275,75,20);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 
	g2.draw(hw2);

	//Sign my picture	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Robot Friends by Victor Porter", 20,20);
    }


    /** Draw a Colorful Robot Rainbow
     */
    public static void drawPicture2(Graphics2D g2) {
	
	//
	Random rand = new Random();
    int r, g, b;
    Shape h3;

	Stroke thick = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.BLACK); 

    ArrayList<RobotWithFeatures> myRobotArmy = new ArrayList<RobotWithFeatures>();
	int positiony = 50, positionx = 50;
	for(int i = 0; i<=100; i++) { 
		RobotWithFeatures test = new RobotWithFeatures(positionx + i ,positiony + i ,i,3);
		myRobotArmy.add(i,test);

   		r = rand.nextInt(200);
	    g = rand.nextInt(200);
	    b = rand.nextInt(200);
	    Color randomColor = new Color(r, g, b);
	    g2.setColor(randomColor);

		if(i%2 == 0) {
			h3 = ShapeTransforms.rotatedCopyOf(test, Math.PI/4.0);
			g2.draw(h3); }
		else g2.draw(myRobotArmy.get(i));
		positiony = positiony + 50;
		if(positiony >= 400) {
			positiony = 50;
			positionx += 100;
		}
	}	

	//Sign my picture
	orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Robot Rainbow by Victor Porter", 20,20);
    }
  

    /** Draw a picture of a robot army
     */
    public static void drawPicture3(Graphics2D g2) {
	
	// Add caption for drawing 3
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
        g2.setColor(Color.BLACK);	
	g2.drawString("The Robot Army by Victor Porter", 20,20);


	//Declare an arraylist to hold Robot Army
	ArrayList<RobotWithFeatures> myRobotArmy = new ArrayList<RobotWithFeatures>();
	int positiony = 50, positionx = 50;
	for(int i = 0; i<=500; i++) { 
		RobotWithFeatures test = new RobotWithFeatures(positionx ,positiony,50,3);
		myRobotArmy.add(i,test);

		if(i%2 == 0) g2.setColor(Color.RED);  
		else g2.setColor(Color.BLUE); 
		g2.draw(myRobotArmy.get(i));

		positiony = positiony + 50;
		if(positiony >= 500) {
			positiony = 50;
			positionx += 50;
		}
	}
         
    }
    

}
