package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player
{
	private float xpos;
	private float ypos;
	private int xspeed;
	private int yspeed;
	private int width = 30;
	private int height = 30;
	
	public Player(int xpos, int ypos)
	{
		this.xpos = xpos;
		this.ypos = ypos;
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect((int)xpos, (int)ypos, width, height);
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
