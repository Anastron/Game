package Game;

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
	private float xspeed;
	private float yspeed;
	private int width = 30;
	private int height = 30;
	private double degrees = 0;
	private BufferedImage look;
	private final int PLAYERSPEED = 200;
	
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
	

	
	public void draw(Graphics g)
	{
		g.drawImage(rotate(degrees + 90), (int) xpos, (int) ypos, null);
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
	public double getRotation()
	{
		int absx = (int) (Keyboard.getMouseX() - (xpos + 15));
		int absy = (int) (Keyboard.getMouseY() - (ypos + 15));
		return Math.atan2(absy, absx);
		
	}
	public void update(float tslf)
	{
		xspeed = 0;
		yspeed = 0;
		
		degrees = (int) Math.toDegrees((getRotation()));
		
		if(Keyboard.isKeyPressed(KeyEvent.VK_W))
		{
			xspeed = (float) Math.cos(getRadianDegrees()) * 200;
			yspeed = (float) Math.sin(getRadianDegrees()) * 200;
		}
		if(Keyboard.isKeyPressed(KeyEvent.VK_S))
		{
			xspeed = (float) Math.cos(getRadianDegrees() + Math.PI) * 200;
			yspeed = (float) Math.sin(getRadianDegrees() + Math.PI) * 200;
		}
		if(Keyboard.isKeyPressed(KeyEvent.VK_D))
		{
			xspeed = (float) Math.cos(getRadianDegrees() + Math.PI/2) * 200;
			yspeed = (float) Math.sin(getRadianDegrees() + Math.PI/2) * 200;
		}
		if(Keyboard.isKeyPressed(KeyEvent.VK_A))
		{
			xspeed = (float) Math.cos(getRadianDegrees() - Math.PI/2) * 200;
			yspeed = (float) Math.sin(getRadianDegrees() - Math.PI/2) * 200;
		}

		xpos += xspeed * tslf;
		ypos += yspeed * tslf;
		
		if(xpos < 0) xpos = 0;
		if(xpos + width > Main.width) xpos = 800 - width;
		if(ypos < 0) ypos = 0;
		if(ypos + height > Main.height) ypos = 600 - height;
	}
	public double getRadianDegrees()
	{
		return Math.toRadians(degrees);
	}
	
}
