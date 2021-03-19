import java.awt.Color;

import javax.swing.JFrame;

public class GameLoop {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();
		obj.setBounds(350, 100, 905, 700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.add(gameplay);
		
		
	}
}
