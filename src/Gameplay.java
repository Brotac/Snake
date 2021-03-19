import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
	
	private ImageIcon enemyimage;
	
	private Random random = new Random();
	
	private Timer timer;
	private int delay = 100;
	
	private int moves = 0;
	
	private ImageIcon snakeimage;

	private ImageIcon titleImage;
	
	private int [] enemyXpos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 
					275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 
					575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
	private int [] enemyYpos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
			325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
	
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);

	
			
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
		
		enemyimage = new ImageIcon("assets/enemy.png");
				
		if((enemyXpos[xpos] == snakeXlength[0] && enemyYpos[ypos] == snakeYlength[0]))
		{
			lengthOfSnake++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}
		
		enemyimage.paintIcon(this, g, enemyXpos[xpos], enemyYpos[ypos]);
				
		g.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			right = true; 
			if(!left)
				right = true;
			else {
				right = false;
				left = true;
			}
			down = false;
			up = false; 
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			left = true; 
			if(!right)
				left = true;
			else {
				left = false;
				right = true;
			}
			down = false;
			up = false; 
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			up = true; 
			if(!down)
				up = true;
			else {
				up = false;
				down = true;
			}
			left = false;
			right = false; 
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			down = true; 
			if(!up)
				down = true;
			else {
				down = false;
				up = true;
			}
			left = false;
			right  = false; 
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right)
		{
			for(int i = lengthOfSnake-1; i>=0; i--)
				snakeYlength[i+1] = snakeYlength[i];
			for(int i = lengthOfSnake; i>=0; i--)
			{
				if(i == 0)
					snakeXlength[i] = snakeXlength[i] + 25;
				else
					snakeXlength[i] = snakeXlength[i-1];
				if(snakeXlength[i] > 850)
					snakeXlength[i] = 25;
			}	
			repaint();
		}
		if(left)
		{
			for(int i = lengthOfSnake-1; i>=0; i--)
				snakeYlength[i+1] = snakeYlength[i];
			for(int i = lengthOfSnake; i>=0; i--)
			{
				if(i == 0)
					snakeXlength[i] = snakeXlength[i] - 25;
				else
					snakeXlength[i] = snakeXlength[i-1];
				if(snakeXlength[i] < 25)
					snakeXlength[i] = 850;
			}	
			repaint();
		}
		if(up)
		{
			for(int i = lengthOfSnake-1; i>=0; i--)
				snakeXlength[i+1] = snakeXlength[i];
			for(int i = lengthOfSnake; i>=0; i--)
			{
				if(i == 0)
					snakeYlength[i] = snakeYlength[i] - 25;
				else
					snakeYlength[i] = snakeYlength[i-1];
				if(snakeYlength[i] < 75)
					snakeYlength[i] = 625;
			}	
			repaint();
		}
		if(down)
		{
			for(int i = lengthOfSnake-1; i>=0; i--)
				snakeXlength[i+1] = snakeXlength[i];
			for(int i = lengthOfSnake; i>=0; i--)
			{
				if(i == 0)
					snakeYlength[i] = snakeYlength[i] + 25;
				else
					snakeYlength[i] = snakeYlength[i-1];
				if(snakeYlength[i] > 625)
					snakeYlength[i] = 75;
			}	
			repaint();
		}


	}
}
