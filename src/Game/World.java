package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class World 
{
	private float worldx;
	private float worldy;
	private BufferedImage background;
	private Player player;
	public World()
	{
		background = Imageloader.loadImage("Hintergrund");
		player = new Player(Main.width/2 - 15, Main.height/2  - 15);
	}
	public void update(float tslf)
	{
		if(player.getXpos() == Main.width/2 - 15)worldx += player.getXSpeed() * tslf;
		if(player.getYpos() == Main.height/2 -15)worldy += player.getYSpeed() * tslf;
		
		boolean onwallx = false;
		boolean onwally = false;
		if(worldx < 0)
		{
			worldx = 0;
			onwallx = true;
		}
		if(worldy < 0)
		{
			worldy = 0;
			onwally = true;
		}
		
		if(worldx > background.getWidth() - Main.width)
		{
			worldx = background.getWidth() - Main.width;
			onwallx = true;
		}
		if(worldy > background.getHeight() - Main.height)
		{
			worldy = background.getHeight() - Main.height;
			onwally = true;
		}
		
		if((player.getXpos() < Main.width/2 - 15 && worldx == 0) || (player.getXpos() > Main.width/2 - 15 && worldx == background.getWidth() - Main.width)) onwallx = true;
		else player.setXpos(Main.width/2 -15);
		
		if((player.getYpos() < Main.height/2 - 15 && worldy == 0)|| (player.getYpos() > Main.height/2 - 15 && worldy == background.getHeight() - Main.height)) onwally = true;
		else player.setYpos(Main.height/2 -15);
		
		
		player.update(tslf, onwallx, onwally);
	}
	public void draw(Graphics g)
	{
		g.drawImage(background, (int) worldx * -1, (int) worldy * -1, null);
		player.draw(g);
	}
}
