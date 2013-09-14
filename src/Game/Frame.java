package Game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
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
	private BufferedImage cursor;
	
	public Frame()
	{
		super("Game");
		
		Keyboard kb = new Keyboard();
		addKeyListener(kb);
		addMouseMotionListener(kb);
		
		background = Imageloader.loadImage("Hintergrund");
		cursor = Imageloader.loadImage("Cursor");
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(), "INVISIBLE"));
		
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
		g.drawImage(cursor, Keyboard.getMouseX(), Keyboard.getMouseY(), null);
	}
	public void update(float tslf)
	{
		player.update(tslf);
	}
}
