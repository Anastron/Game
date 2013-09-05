package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;



public class Frame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferStrategy strat;
	private Player player;
	public Frame()
	{
		super("Game");
		
		addKeyListener(new Keyboard());
		
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.width, Main.height);
		player.draw(g);
	}
	public void update(float tslf)
	{
		player.update(tslf);
	}
}
