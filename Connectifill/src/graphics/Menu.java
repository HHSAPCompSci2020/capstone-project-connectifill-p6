package graphics;
import java.awt.event.*;
import javax.swing.*;

public class Menu implements ActionListener
{
	JFrame frame;
	JMenuBar menuBar;
	JMenu first;
	JMenuItem firstItem, secondItem, thirdItem, fourthItem, fifthItem;
	
	public Menu()
	{
		menuBar = new JMenuBar();
		
		first = new JMenu("Models");
		menuBar.add(first);
		
		firstItem = new JMenuItem("RandomModel");
		first.add(firstItem);
		
		secondItem = new JMenuItem("AggressiveModel");
		first.add(secondItem);
		
		thirdItem = new JMenuItem("DefensiveModel");
		first.add(thirdItem);
		
		fourthItem = new JMenuItem("MiniMaxModel");
		first.add(fourthItem);
		
		fifthItem = new JMenuItem("CombinedModel");
		first.add(fifthItem);
		
				
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(420,420);
		frame.setJMenuBar(menuBar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
