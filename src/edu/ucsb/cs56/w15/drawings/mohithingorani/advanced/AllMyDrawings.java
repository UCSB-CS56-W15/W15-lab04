package edu.ucsb.cs56.w15.drawings.mohithingorani.advanced;

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
 * @author Mohit Hingorani
 * @version for CS10, lab06, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {


	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	g2.setColor(Color.BLACK);
	g2.setStroke(thick);
	
	Car myCar = new Car(200,50,300,200);
	g2.draw(myCar);
 	/*
	Car secondCar = new Car( 200, 50 , 200 , 150 ) ;
	g2.draw(secondCar);
	*/

	Batmobile batmobile = new Batmobile ( 400, 50, 200,150) ;
	g2.draw( batmobile) ;
	
	
	Batmobile[] batmobiles = new Batmobile[5];
		
	for ( int i  = 0 ; i < 5; i++ )
		{       
			
			Color randomColor = new Color(i*60, 0 , 255 );	
			g2.setColor(randomColor);
			batmobiles[i] = new Batmobile( i* 100, 200  , 100 ,  60 );
			g2.draw(batmobiles[i]) ;
	}

	g2.drawString("Started out trying to create the 1989 batmobile, ended up with a car and a missile on top", 20,20);

    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);      
	Batmobile bat = new Batmobile ( 0,0, 110, 50);
	
	Shape batShape = ShapeTransforms.scaledCopyOfLL( bat , 1.0, 1.0);
	batShape = ShapeTransforms.translatedCopyOf( batShape, 100,100);
	g2.setColor(Color.RED);
	g2.draw(batShape);

	
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	
 	 Batmobile[] batmobiles = new Batmobile[7];
		
	for ( int i  = 0 ; i < 7; i++ )
		{       
			
		batmobiles[i] = new Batmobile( 0, 0 , 110 ,  60 );
			//g2.draw(batmobiles[i]) ;
		}

	for ( int i = 0 ; i < 7 ; i++)
	    {	
		Shape batCopy = ShapeTransforms.translatedCopyOf(batmobiles[i] , 200 + 200*Math.sin( Math.PI/7*i)  , 200 + 200*Math.cos( Math.PI/7 * i )  );
		Shape rotateBat = ShapeTransforms.rotatedCopyOf( batCopy, -Math.PI/3 * i );
       		Color randomColor = new Color(i*30, 0 , 255 );	
		g2.setColor(randomColor);
		g2.draw(rotateBat);


	    }
	g2.drawString( "Batmobile doing stunts and stuff by Mohit Hingorani", 40,40);	

		
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
      	
 	Batmobile[] batmobiles = new Batmobile[7];
		
	for ( int i  = 0 ; i < 7; i++ )
		{       
			
		batmobiles[i] = new Batmobile( 0, 0 , 110 ,  60 );
			//g2.draw(batmobiles[i]) ;
		}

	for ( int i = 0 ; i < 7 ; i++)
	    {	
		Shape batCopy = ShapeTransforms.translatedCopyOf(batmobiles[i] , 200 + 200*Math.sin( Math.PI/7*i)  , 200 + 200*Math.cos( Math.PI/7 * i )  );
		Shape rotateBat = ShapeTransforms.rotatedCopyOf( batCopy, -Math.PI/3 * i );
       		Shape scalerBat = ShapeTransforms.scaledCopyOfLL(rotateBat,0.1 * i , 0.1 *i );
		Color randomColor = new Color(i*30, 0 , 255 );	
		g2.setColor(randomColor);
		g2.draw(scalerBat);


	    }
	g2.drawString( "Batmobile doing stunts and stuff, now getting bigger by Mohit Hingorani", 40,40);	



    }
    

}
