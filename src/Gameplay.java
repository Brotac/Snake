import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	
	private int moves = 0;
	
	private ImageIcon snakeimage;

	private ImageIcon titleImage;
	
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
	}
	
	public void paint(Graphics g)
	{
		if(moves == 0)
		{
			snakeXlength[2] = 50;
			snakeXlength[1] = 75;
			snakeXlength[0] = 100;
			
			snakeYlength[2] = 100;
			snakeYlength[1] = 100;
			snakeYlength[0] = 100;


		}
		
		//Draw title image border :)
		g.setColor(Color.white);
		g.drawRect(24, 10, 852, 55);
		
		//Draw the title image
		titleImage = new ImageIcon("assets/snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//Draw the border of the playing area
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//Draw backgrownd 
		g.setColor(Color.GREEN);
		g.fillRect(25, 75, 850, 575);
		
		rightmouth = new ImageIcon("assets/rightmouth.png");
		rightmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
		
		for (int i = 0; i < lengthOfSnake; i++)
		{
			if (i == 0 && right)
			{
				rightmouth = new ImageIcon("assets/rightmouth.png");
				rightmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i == 0 && left)
			{
				leftmouth = new ImageIcon("assets/leftmouth.png");
				leftmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i == 0 && down)
			{
				downmouth = new ImageIcon("assets/downmouth.png");
				downmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i == 0 && up)
			{
				upmouth = new ImageIcon("assets/upmouth.png");
				upmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if(i != 0)
			{
				snakeimage = new ImageIcon("assets/snakeimage.png");
				snakeimage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
		}
		
		g.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
