package edu.ucsb.cs56.w15.drawings.fengyuwang.advanced;
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
A vector drawing of a house that implements
the Shape interface, and so can be drawn, as well as
rotated, scaled, etc.
@author Fengyu Wang	
@version for CS56, Spring 15 UCSB
*/
public class BearHead extends GeneralPathWrapper implements Shape
{
/**
Constructor
@param x x coord of upper left corner of bearface
@param y y coord of upper left corner of bearface
@param width width of the bearface
@param height height of the bearface
*/
public BearHead(double x, double y, double width, double height)
{
   
//for the ears
double earWidth = width/3;
double earHeight = height/3;
double leftEarX = x - earWidth/1.414;
double leftEarY = y + earHeight/1.414 - earWidth/2;
double rightEarX = leftEarX + width + earWidth/2;
double rightEarY = leftEarY;

//for the eyes
double eyeWidth = width/5;
double eyeHeight = height/5;
double leftEyeX = x + width/3 - eyeWidth;
double leftEyeY = y + height/3;
double rightEyeX = leftEyeX + width/3 + eyeWidth;
double rightEyeY = leftEyeY;

//for the nose
double noseWidth = width/6;
double noseHeight = height/6;
double noseX = x + width/2 - noseWidth/2;
double noseY = y + height/2;


Ellipse2D.Double bearFace=
new Ellipse2D.Double(x,y,width, height);

Ellipse2D.Double leftEar=
new Ellipse2D.Double(leftEarX,leftEarY,earWidth,earHeight);

Ellipse2D.Double rightEar=
new Ellipse2D.Double(rightEarX,rightEarY,earWidth,earHeight);

Ellipse2D.Double leftEye=
new Ellipse2D.Double(leftEyeX,leftEyeY,eyeWidth,eyeHeight);

Ellipse2D.Double rightEye=
new Ellipse2D.Double(rightEyeX,rightEyeY,eyeWidth,eyeHeight);

Ellipse2D.Double nose=
new Ellipse2D.Double(noseX,noseY,noseWidth,noseHeight);

Line2D.Double topMouth =
    new Line2D.Double (x + width/2, noseY + noseHeight,x + width/2, noseY + 3*noseHeight/2);
Line2D.Double leftMouth =
    new Line2D.Double (x + width/2, noseY + 3*noseHeight/2, x + width/4, noseY + 2*noseHeight);
Line2D.Double rightMouth =
    new Line2D.Double (x + width/2, noseY + 3*noseHeight/2, x + 3*width/4, noseY + 2*noseHeight);



// put the bear face together
GeneralPath bearHead= this.get();
bearHead.append(bearFace, false);
bearHead.append(leftEar, false);
bearHead.append(rightEar, false);
bearHead.append(leftEye, false);
bearHead.append(rightEye, false);
bearHead.append(nose, false);
bearHead.append(topMouth, false);
bearHead.append(leftMouth, false);
bearHead.append(rightMouth, false);

}
}
