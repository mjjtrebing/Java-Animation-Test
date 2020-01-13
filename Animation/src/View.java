/*
 * Matt Trebing
 * 3/28/16
 * View.java
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class View extends JPanel
{
	private final int H=500;
	private final int L=200;
	private boolean hideStuff = false;
	private JFrame showFrame = new JFrame("lllllllllll");
	private final JLabel label = new JLabel("OOOOOO");
	private Show finale = new Show();
	private JCheckBoxMenuItem boatBox = new JCheckBoxMenuItem("Boat", false);
	private JCheckBoxMenuItem airplaneBox = new JCheckBoxMenuItem("Airplane", false);
	private JCheckBoxMenuItem clockBox = new JCheckBoxMenuItem("Clock", false);
	private boolean boolShow = false;
	
	/**Constructor
	 * This constructor adds all the buttons and check boxes to the frame, and sets the layout to null.
	 * ActionListeners are also set for each of the buttons 
	 */
	public View()
	{
		JButton show = new JButton("Show");
		JButton exit = new JButton("Exit");
		JButton remove = new JButton("Remove");
		JButton add = new JButton("Add");
		this.setLayout(null);
		this.setSize(H,L);
		
		show.setSize(75,30);
		show.setLocation(40,50);
		this.add(show);
		show.addActionListener(finale);
		
		exit.setSize(75,30);
		exit.setLocation(150,50);
		this.add(exit);
		exit.addActionListener(new Exit());
		
		remove.setSize(80,30);
		remove.setLocation(250,50);
		this.add(remove);
		remove.addActionListener(new Remove());
		
		add.setSize(75,30);
		add.setLocation(370,50);
		this.add(add);
		add.addActionListener(new Add());
		
		
		
		airplaneBox.setSize(70,30);
		airplaneBox.setLocation(340,120);
		this.add(airplaneBox);
		
		clockBox.setSize(70,30);
		clockBox.setLocation(100,120);
		this.add(clockBox);
		
		boatBox.setSize(70,30);
		boatBox.setLocation(230,120);
		this.add(boatBox);
	}
	
	/**
	 * This method builds the first initial menu frame
	 */
	public void frameBuilder()
	{
		JFrame frame = new JFrame("iabfjbajkbsfwavgf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(H,L);
		frame.setContentPane(this);
		frame.setResizable(false);
	}
		
	/**
	 * This private class is here for use of the exit button once clicked
	 * @author Matt
	 *
	 */
	private class Exit implements ActionListener 
	{
		/**
		 * Once the exit button is clicked, this method will stop the program
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	/**
	 * This private class is here for use of the Add button once clicked
	 * @author Matt
	 *
	 */
	private class Add implements ActionListener 
	{
		/**
		 * once the add button is clicked this method will add a shape to the new frame depending on the state of each check box
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(airplaneBox.getState())
				finale.addAPlane();
			if(boatBox.getState())
				finale.addABoat();
			if(clockBox.getState())
				finale.addAClock();

		      
		}
	}
	
	/**
	 * This private class is here for use of the Remove button once clicked
	 * @author Matt
	 *
	 */
	private class Remove implements ActionListener 
	{
		/**
		 * Once the remove button has been clicked this method will remove a shape from the top of the arrayList in the Show class
		 */
		public void actionPerformed(ActionEvent e)
		{
			finale.remove();
		}
	}
}
