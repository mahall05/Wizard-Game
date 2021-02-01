import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public Window(int width, int height, String title, Game game) {
		
		JFrame frame = new JFrame(title);     // Creating new frame with the title in the parameters when this class is called
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.add(game);     // Adding the game class to the actual window
		frame.setResizable(false);     // Cannot resize window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Allows the x button to work
		frame.setLocationRelativeTo(null);     // Box will start in the center
		frame.setVisible(true);     // Showing the window
		
	}

}
