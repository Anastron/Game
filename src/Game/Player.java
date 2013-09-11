package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player
{
	private float xpos;
	private float ypos;
	private int xspeed;
	private int yspeed;
	private int width = 30;
	private int height = 30;
	private BufferedImage look;
	
	public Player(int xpos, int ypos)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		try
		{
			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/Spieler.png"));
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private int degrees = 0;
	
	public void draw(Graphics g)
	{
		degrees++;
		if(degrees == 360)
		{
			degrees = 0;
		}
			
		g.drawImage(rotate(degrees), (int) xpos, (int) ypos, null);
	}
	public BufferedImage rotate(double degreese)
	{
		AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(degreese), look.getWidth()/2, look.getHeight()/2);
		BufferedImage rotatedImage = new BufferedImage(look.getWidth(), look.getHeight(), look.getType());
		Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
		g.setTransform(at);
		g.drawImage(look, 0, 0, null);
		return rotatedImage;
		
	}
	public void update(float tslf)
	{
		xspeed = 0;
		yspeed = 0;
		
		if(Keyboard.isKeyPressed(KeyEvent.VK_W)) yspeed = -100;
		if(Keyboard.isKeyPressed(KeyEvent.VK_S)) yspeed = 100;
		if(Keyboard.isKeyPressed(KeyEvent.VK_D)) xspeed = 100;
		if(Keyboard.isKeyPressed(KeyEvent.VK_A)) xspeed = -100;

		xpos += xspeed * tslf;
		ypos += yspeed * tslf;
		
		if(xpos < 0) xpos = 0;
		if(xpos + width > Main.width) xpos = 800 - width;
		if(ypos < 0) ypos = 0;
		if(ypos + height > Main.height) ypos = 600 - height;
	}
}
