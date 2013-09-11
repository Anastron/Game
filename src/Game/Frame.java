package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;



public class Frame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferStrategy strat;
	private Player player;
	private BufferedImage background;
	
	public Frame()
	{
		super("Game");
		
		addKeyListener(new Keyboard());
		
		try
		{
			background = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/Hintergrund.jpg"));
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		player = new Player(300, 300);
	}
	public void makstrat()
	{
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	public void repaint()
	{
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}
	public void draw(Graphics g)
	{
		g.drawImage(background, 0, 0, null);
		player.draw(g);
	}
	public void update(float tslf)
	{
		player.update(tslf);
	}
}
