package Game;

import java.awt.image.BufferedImage;

public abstract class MovingObject 
{
	protected float xpos;
	protected float ypos;
	protected float xspeed;
	protected float yspeed;
	protected BufferedImage look;
	public MovingObject(float xpos, float ypos, float xspeed, float yspeed)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		this.xspeed = xspeed;
		this.yspeed = yspeed;
	}

}
