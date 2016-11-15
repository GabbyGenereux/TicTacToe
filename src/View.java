import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author Gabrielle
 * View of TicTacToe, including GUI
 */
public class View extends JFrame{
	
	Model m;
	Controller c;
	
	JButton[][] buttonArray;
	
	public View()
	{
		m = new Model(this);
		c = new Controller(m);
		
		//This makes the grid a 3x3 layout
		this.setLayout(new GridLayout(3,3));
		
		buttonArray = new JButton[3][3];
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				JButton temp = new JButton();
				buttonArray[i][j] = temp;
				//Defines what position the button is
				temp.setActionCommand(i+" "+j);
				
				//registers controller as listener to the button
				temp.addActionListener(c);
				
				this.add(temp);
			}
		}		
		
		this.setSize(300, 300);
		//puts it at middle of screen
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void reset()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				buttonArray[i][j].setEnabled(true);
				buttonArray[i][j].setText("");
			}
		}		
	}
	
	public void winner()
	{
		//possible error
		JDialog dialog = new JDialog(this, "Winner!!!!!!!!!!!!!!!!!!");
		
		JLabel label = new JLabel("Winner: " + m.getWinner());
		
		JButton reset = new JButton("reset");
		//this is one way of doing the actionListener stuff
		//the other way is in the controller
		//If you do it this way, you don't actually need a controller
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.reset();
				reset();
				dialog.dispose();
			}
			
		});
		
		dialog.add(label, BorderLayout.NORTH);
		
		dialog.add(reset, BorderLayout.SOUTH);
		
		dialog.setSize(100, 150);
		//puts it at middle of screen
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public static void main(String args[])
	{
		new View();
	}

}
