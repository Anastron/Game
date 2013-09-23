package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Enemy extends MovingObject
{
	public double rotation;
	static int size;
	private final int SPEED = 75;
	public Enemy(float xpos, float ypos, float xspeed, float yspeed)
	{
		super(xpos, ypos, xspeed, yspeed);
		
		look = Imageloader.loadImage("Gegner");
		size = look.getWidth() / 2;
	}
	public void draw(Graphics g, int worldx, int worldy)
	{
		g.drawImage(rotate(), (int) xpos + worldx + Frame.transx, (int) ypos + worldy + Frame.transy, null);
	}
	public boolean update(float tslf, float targetx, float targety, LinkedList<Bullet> bullets)
	{
		float absx = targetx - xpos;
		float absy = targety - ypos;
		rotation = Math.atan2(absy, absx);
		
		xspeed = (float) (Math.cos(rotation) * SPEED);
		yspeed = (float) (Math.sin(rotation) * SPEED);
		
		xpos += xspeed * tslf;
		ypos += yspeed * tslf;
		
		for(int i = 0; i < bullets.size(); i++)
		{
			if(Collision.circleToCircle(bullets.get(i).getX(), bullets.get(i).getY(), 2, xpos + size, ypos + size, size))
			{
				bullets.remove(i);
				return true;
			}
		}
		return false;
	}
	public BufferedImage rotate()
	{
		AffineTransform at = AffineTransform.getRotateInstance(rotation + Math.PI/2, size, size);
		BufferedImage rotatedImage = new BufferedImage(look.getWidth(), look.getHeight(), look.getType());
		Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
		g.setTransform(at);
		g.drawImage(look, 0, 0, null);
		return rotatedImage;
		
	}
	
}
