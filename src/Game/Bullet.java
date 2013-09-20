package Game;

import java.awt.Graphics;

public class Bullet extends MovingObject
{
	static final int MAXSPEED = 500;
	public Bullet(float xpos, float ypos, float xspeed, float yspeed)
	{
		super(xpos, ypos, xspeed, yspeed);
		
		look = Imageloader.loadImage("Schuss");
	}
	public boolean update(float tslf)
	{
		xpos += xspeed * tslf;
		ypos += yspeed * tslf;
		
		if(xpos < 0) return true;
		if(ypos < 0) return true;
		if(xpos > World.width * Texture.tilesize) return true;
		if(ypos > World.height * Texture.tilesize) return true;
		return false;
	}
	public void draw(Graphics g, int worldx, int worldy)
	{
		g.drawImage(look, (int) xpos + worldx, (int) ypos + worldy, null);
	}
}
