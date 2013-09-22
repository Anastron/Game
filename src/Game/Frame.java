package Game;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
	private BufferedImage cursor;
	private World world;
	private Menu menu;
	private Soundplayer sound;
	static int gamestate;
	static int transx;
	static int transy;
	
	public Frame()
	{
		super("Game");
		
		Keyboard kb = new Keyboard();
		addKeyListener(kb);
		addMouseMotionListener(kb);
		addMouseListener(kb);
		
		cursor = Imageloader.loadImage("Cursor");
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(), "INVISIBLE"));
		
		world = new World();
		menu = new Menu();
		
		sound = new Soundplayer("sfx/background.wav");
		sound.loop();
		sound.setVolume(-10);
	}
	public void makscreen()
	{
		createBufferStrategy(2);
		strat = getBufferStrategy();
		
		Insets i = getInsets();
		transx = i.left;
		transy = i.top;
		setSize(Main.width + transx + i.right, Main.height + transy + i.bottom);
		setLocationRelativeTo(null);
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
		switch (gamestate) {
		case 0:
			menu.draw(g);
			break;
			
		case 1:
			world.draw(g);
			break;

		default:
			break;
		}
		g.drawImage(cursor, Keyboard.getMouseX() - 8, Keyboard.getMouseY() - 8, null);
	}
	public void update(float tslf)
	{
		
		switch (gamestate) {
		case 0:
			menu.update(tslf);
			break;
			
		case 1:
			world.update(tslf);
			if(Keyboard.isKeyPressed(KeyEvent.VK_ESCAPE)) gamestate = 0;
			break;

		default:
			break;
		}
		world.update(tslf);
	}
}
