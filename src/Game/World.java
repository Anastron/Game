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
		worldx += player.getXSpeed() * tslf;
		worldy += player.getYSpeed() * tslf;
		player.update(tslf, false);
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 800, 600);
		g.drawImage(background, (int) worldx * -1, (int) worldy * -1, null);
		player.draw(g);
	}
}
