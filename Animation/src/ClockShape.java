/*
 * Matt Trebing
 * 3/28/16
 * ClockShape.java
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;


public class ClockShape implements MoveableShape
{
	/**
    Constructs a car item.
    @param x the left of the bounding rectangle
    @param y the top of the bounding rectangle
    @param width the width of the bounding rectangle
 */
	 private int x;
	 private int y;
	 private int width;
	 /**
	  * Constructor
	  * @param x
	  * @param y
	  * @param width
	  */
 public ClockShape(int x, int y, int width)
 {
    this.x = x;
    this.y = y;
    this.width = width;
    
 }

 /**
  * this method shifts the x and y values across the shows frame
  */
 public void translate(int dx, int dy)
 {
	 x += dx;
	   y += dy;
	   if(x>=500)
	   {
		   x=0;
	   }
	   if(y>=500)
	   {
	  	  y=0;
	   }
	  if(y<=-1)
	  {
	  	  y=499;
	  }
	  if(x<=-1)
	  {
		  x=499;
	  }
 }

 /**
  * this method actually creates and draws the clock
  */
 public void draw(Graphics2D g2)
 {
	 Random rando = new Random();
	  int varColor = rando.nextInt(7);
	  if(varColor==1)
		  g2.setColor(Color.RED);
	  if(varColor==2)
		  g2.setColor(Color.BLUE);
	  if(varColor==0)
		  g2.setColor(Color.GREEN);
	  if(varColor ==3)
		  g2.setColor(Color.ORANGE);
	  if(varColor ==4)
		  g2.setColor(Color.BLACK);
	  if(varColor ==6)
		  g2.setColor(Color.PINK);
	 
	 
    Ellipse2D.Double frontTire= new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6, width / 6);

    Point2D.Double p1 = new Point2D.Double(x + width  / 6 +16, y + width/2 -32 );
    Point2D.Double p2 = new Point2D.Double(x + width  / 6 +16, y + width/2 -15 );
    Line2D.Double minutes= new Line2D.Double(p1, p2);
    
    Point2D.Double p3 = new Point2D.Double(x + width  / 6 +10, y + width/2 -23 );
    Point2D.Double p4 = new Point2D.Double(x + width  / 6 +16, y + width/2 -15 );
    Line2D.Double hours= new Line2D.Double(p3, p4);
    
    g2.draw(minutes);
    g2.draw(frontTire);
    g2.draw(hours);
 }
}

