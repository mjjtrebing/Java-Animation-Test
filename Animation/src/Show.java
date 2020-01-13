/*
 * Matt Trebing
 * 3/28/16
 * Show.java
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class Show extends JPanel implements ActionListener 
{
	   private static final int ICON_WIDTH = 500;
	   private static final int ICON_HEIGHT = 500;
	   private static final int PLANE_WIDTH = 25;
	   private static final int CLOCK_WIDTH = 200;
	   private static final int BOAT_WIDTH = 150;
	   private ShapeIcon icon = new ShapeIcon(ICON_WIDTH, ICON_HEIGHT);
	   private final JLabel label = new JLabel(icon);
	   private ArrayList<MoveableShape> things;
	   private Random rando = new Random();
	   private int num1 =rando.nextInt(3)-5;
	   private int num2 =rando.nextInt(3)-5;
	   private static boolean boolShow = false;
	   private JButton res;
	   
	   /**
	    * Once the show button has been click back on the menu, this class will create a new frame with its on JLable.
	    * This method also sets up a time which will access and move shapes around on screen.
	    */
	public void actionPerformed(ActionEvent e)
	{
	    
	    JFrame frame = new JFrame();
	    frame.setLayout(new FlowLayout());
	    frame.add(label);
	    frame.pack();
	    frame.setVisible(true);
	    
	    /*JPanel pane = new JPanel();
	    pane.setLayout(null);
		pane.setSize(500,200);
		frame.add(pane);*/
		
		
		
	    res = new JButton("RESTART");
	    res.setSize(80,30);
		res.setLocation(250,50);
		//label.add(res);
		//pane.add(res);
		frame.add(res);
		res.addActionListener(new Restart());
	      
	     
	      final int DELAY = 100;
	      Timer t = new Timer(DELAY, new
	         ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	            	things = icon.getShapes();
	            	int size =things.size();
	            	for(int i =0; i<size;i++)
	            	{
	            		things.get(i).translate(i-7,i-5);
	            		
	            		label.repaint();
	            	}
	               
	            }
	         });
	      t.start();
	   }
	
	/**
	 * This adds a boat to the Icon
	 */
	 public void addABoat()
	 {
		  icon.addShape(new BoatShape(rando.nextInt(500), rando.nextInt(500), BOAT_WIDTH));
	   }
	 
	 /**
		 * This adds a Plane to the Icon
		 */
	 public void addAPlane()
	   {
		  icon.addShape(new PlaneShape(rando.nextInt(500), rando.nextInt(500), PLANE_WIDTH));
	   }
	 
	 /**
		 * This adds a clock to the Icon
		 */
	 public void addAClock()
	   {
		  icon.addShape(new ClockShape(rando.nextInt(500), rando.nextInt(500), CLOCK_WIDTH));
	   }
	 
	 /**
	  * this method removes the top shape from the arrayList
	  */
	 public void remove()
	 {
			 icon.removeTop();
	 }
	 private class Restart implements ActionListener
	 {
		public void actionPerformed(ActionEvent arg0) 
		{
			things = new ArrayList<MoveableShape>();
			
		}
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}