/*
 * Matt Trebing
 * 3/28/16
 * ShapeIcon.java
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ShapeIcon implements Icon
{
	private int NumberOfShapes=-1;
	private ArrayList<MoveableShape> shapes = new ArrayList<MoveableShape>();
	private int width;
	private int height;
	
	/**Constructor
	 * 
	 * @param width
	 * @param height
	 */
   public ShapeIcon(int width, int height)
   {

	   this.width = width;
	   this.height = height;
	   

   }
   
   /**
    * this method adds a shape to the array list and adds 1 to the NumberOfShapes var
    * @param shape
    */
   public void addShape(MoveableShape shape)
   {
	   shapes.add(shape);
	   NumberOfShapes++;
	   
   }
   
   /**
    * this method removes the top shape from the array list
    */
   public void removeTop()
   {
	  
	  shapes.remove(NumberOfShapes);
	  NumberOfShapes--;
	  
   }
   
   /**
    * this method returns the width of the Icon
    */
   public int getIconWidth()
   {
      return width;
   }

   /**
    * this method returns the height of the Icon
    */
   public int getIconHeight()
   {
      return height;
   }
   
   /**
    * this method returns the arraylist of moveableshapes
    * @return
    */
   public ArrayList<MoveableShape> getShapes()
   {
	   return shapes;
   }
   
   /**
    * this method sets the shapes arraylist to the arraylist given in the parameters
    * @param list
    */
   public void newList(ArrayList<MoveableShape> list)
   {
	   shapes=list;
   }
   

   /**
    * this method displays the shapes in the arraylist of moveableshapes
    */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
	  int paintByNum=NumberOfShapes;
      Graphics2D g2 = (Graphics2D) g;
       
      for(int i=0;i<=paintByNum;i++)
      {
    	  shapes.get(i).draw(g2);  
      }
      
   }

 
}


