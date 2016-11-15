import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener{

	Model model;
	
	public Controller(Model m)
	{
		this.model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] position = e.getActionCommand().split(" ");
		
		JButton butt = (JButton)e.getSource();
		
		//butt.setText(text);
		
		Player turn = model.getPlayerTurn();
		
		butt.setText(turn.name());
		butt.setEnabled(false);
		
		model.play(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
	}

}
