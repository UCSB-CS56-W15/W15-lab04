package edu.ucsb.cs56.w15.drawings.jillfarnsworth.advanced;

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


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Jill Farnsworth 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture of some fish in a diagonal pattern 
     */

    public static void drawPicture1(Graphics2D g2) {

	Shape f = new Fish(0,150,30,20);
	Shape fwf= new FishWithFins(150,0,30,20);
	fwf = ShapeTransforms.horizontallyFlippedCopyOf(fwf);
	g2.setColor(Color.ORANGE);
	g2.draw(f);
	g2.draw(fwf);
	for(int i=1, x=30, y=20; i<8; i++, x*=1.25, y*=1.25) { 
	    f = ShapeTransforms.scaledCopyOf(f, 1.25, 1.25);
	    f = ShapeTransforms.translatedCopyOf(f, x, y);
	    fwf = ShapeTransforms.scaledCopyOf(fwf, 1.25, 1.25);
	    fwf = ShapeTransforms.translatedCopyOf(fwf, x, y);
	    float r = (float) Math.random();
	    float g = (float) Math.random();
	    float b = (float) Math.random();
	    Color randColor= new Color(r,g,b);
	    g2.setColor(randColor); 
	    g2.draw(f);
	    g2.draw(fwf);
	}

	g2.setColor(Color.BLACK); 
	g2.drawString("Lines of fish by Jill Farnsworth", 300, 20);
    }
	

    /** Draw various fish of differnt color, size, rotation in a 5x5 grid
     */
    public static void drawPicture2(Graphics2D g2) {
	Shape f = new Fish(0, 0, 30, 20);
	Shape fwf = new FishWithFins(0, 0, 30, 20);
	Stroke orig=g2.getStroke();
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	for (int i=0; i<5; i++) {
	    for (int j=0; j<5; j++) {
		Shape fish = f;
		double changetype = Math.random();
		double stroke = Math.random();
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		Color randColor= new Color(r,g,b);
		double width = Math.random()*2;
		double height = Math.random()*2;
		double angle = Math.random()*6.28;
		if (changetype < 0.5) 
		    fish = fwf;
		if (stroke<0.5) 
		    g2.setStroke(orig);
		else
		    g2.setStroke(thick);
		g2.setColor(randColor);
		fish = ShapeTransforms.translatedCopyOf(fish, i*100, j*100);
		fish = ShapeTransforms.scaledCopyOf(fish, width+1, height+1);
		fish = ShapeTransforms.rotatedCopyOf(fish, angle);
		g2.draw(fish);
	    }
	} 

	g2.setColor(Color.BLACK); 
	g2.drawString("Random fish by Jill Farnsworth", 20,20); 
    }
  
    /** Draw fish in an 'X' pattern
     */

    public static void drawPicture3(Graphics2D g2) {
	
	
	g2.drawString("Crossing fish by Jill Farnsworth",150,20);

	Shape fwf = new FishWithFins(0, 0, 50, 30);
	for (int i=0; i<6; i++) {
	    for (int j=0; j<6; j++) {
		if (i==j || (i+j)==5) {
		    Shape fish = 
			ShapeTransforms.translatedCopyOf(fwf, i*75, j*75);
		    if (i<3 && j<3) 
			fish = ShapeTransforms.rotatedCopyOf
			    (fish, Math.PI*(-3.0/4.0));
		    if (i<3 && j>=3)
			fish = ShapeTransforms.rotatedCopyOf
			    (fish, Math.PI*(3.0/4.0));
		    if (i>=3 && j<3) 
			fish = ShapeTransforms.rotatedCopyOf
			    (fish, Math.PI*(-1.0/4.0));
		    if (i>=3 && j>=3)
			fish = ShapeTransforms.rotatedCopyOf
			    (fish, Math.PI*(1.0/4.0));
		    if (i==0 || i==5) {
			fish = ShapeTransforms.scaledCopyOf(fish, 1.75, 1.75);
			g2.setColor(Color.MAGENTA);
		    }
		    if (i==1 || i==4) {
			fish = ShapeTransforms.scaledCopyOf(fish, 1.25, 1.25);
			g2.setColor(Color.BLUE);
		    }
		    if (i==2 || i==3) 
			g2.setColor(Color.GREEN);

		    g2.draw(fish);
		}
	    }
	}
	    
    }
    

}
