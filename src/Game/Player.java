package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player
{
	private float xpos;
	private float ypos;
	private float oldxpos;
	private float oldypos;
	private float xspeed;
	private float yspeed;
	private double degrees = 0;
	private BufferedImage look;
	private final int PLAYERSPEED = 200;
	static int size;
	
	public Player(int xpos, int ypos)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		
		look = Imageloader.loadImage("Spieler");
		size = look.getHeight();
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
		int absx = (int) (Keyboard.getMouseX() + 8 - (xpos + size/2));
		int absy = (int) (Keyboard.getMouseY() + 8 - (ypos + size/2));
		return Math.atan2(absy, absx);
		
	}
	public boolean inMouse()
	{
		return Collision.circleToCircle(Keyboard.getMouseX() + 8, Keyboard.getMouseY() + 8, 0, xpos + size/2, ypos + size/2, size/2);
	}
	public void update(float tslf, boolean playermovex, boolean playermovey)
	{
		xspeed = 0;
		yspeed = 0;
		
		boolean inmouse = inMouse();
		
		
		if(Keyboard.isKeyPressed(KeyEvent.VK_W) && !inmouse)
		{
			xspeed = (float) Math.cos(getRadianDegrees()) * PLAYERSPEED;
			yspeed = (float) Math.sin(getRadianDegrees()) * PLAYERSPEED;
		}
		if(Keyboard.isKeyPressed(KeyEvent.VK_S) && !inmouse)
		{
			xspeed = (float) Math.cos(getRadianDegrees() + Math.PI) * PLAYERSPEED;
			yspeed = (float) Math.sin(getRadianDegrees() + Math.PI) * PLAYERSPEED;
		}
		if(Keyboard.isKeyPressed(KeyEvent.VK_D))
		{
			xspeed = (float) Math.cos(getRadianDegrees() + Math.PI/2) * PLAYERSPEED;
			yspeed = (float) Math.sin(getRadianDegrees() + Math.PI/2) * PLAYERSPEED;
		}
		if(Keyboard.isKeyPressed(KeyEvent.VK_A))
		{
			xspeed = (float) Math.cos(getRadianDegrees() - Math.PI/2) * PLAYERSPEED;
			yspeed = (float) Math.sin(getRadianDegrees() - Math.PI/2) * PLAYERSPEED;
		}

		oldxpos = xpos;
		oldypos = ypos;
		
		if(playermovex) xpos += xspeed * tslf;
		if(playermovey) ypos += yspeed * tslf;
		
		degrees = (int) Math.toDegrees((getRotation()));
		
		if(xpos < 0) xpos = 0;
		if(xpos + size > Main.width) xpos = 800 - size;
		if(ypos < 0) ypos = 0;
		if(ypos + size > Main.height) ypos = 600 - size;
	}
	
	public void setToOld()
	{
		xpos = oldxpos;
		ypos = oldypos;
	}
	
	public float getXpos() {
		return xpos;
	}



	public void setXpos(float xpos) {
		this.xpos = xpos;
	}



	public float getYpos() {
		return ypos;
	}



	public void setYpos(float ypos) {
		this.ypos = ypos;
	}



	public float getXSpeed()
	{
		return xspeed;
	}
	public float getYSpeed()
	{
		return yspeed;
	}
	public double getRadianDegrees()
	{
		return Math.toRadians(degrees);
	}
	
}
