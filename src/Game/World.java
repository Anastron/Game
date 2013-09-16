package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class World 
{
	private float worldx;
	private float worldy;

	private Player player;
	private Tile[][] tiles;
	static int level = 0;
	static int width;
	static int height;
	public World()
	{
		player = new Player(Main.width/2 - 15, Main.height/2  - 15);
		
		loadNextLevel();
	}
	public void loadNextLevel()
	{
		BufferedImage map = Imageloader.loadImage("Map" + level);
		
		width = map.getWidth();
		height = map.getHeight();
		
		tiles = new Tile[width][height];
		
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				Color c = new Color(map.getRGB(x, y));
				if(c.getRed() == 0 && c.getGreen() == 255 && c.getBlue() == 0) tiles[x][y] = new Tile(x, y, 0);
				if(c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 255) tiles[x][y] = new Tile(x, y, 1);
				if(c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 0) tiles[x][y] = new Tile(x, y, 2);
				if(c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0) tiles[x][y] = new Tile(x, y, 3);
			}
		}
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
		int mapwidth = width * Texture.tilesize;
		int mapheight = height * Texture.tilesize;
		if(worldx > mapwidth - Main.width)
		{
			worldx = mapwidth - Main.width;
			onwallx = true;
		}
		if(worldy > mapheight - Main.height)
		{
			worldy = mapheight - Main.height;
			onwally = true;
		}
		
		if((player.getXpos() < Main.width/2 - 15 && worldx == 0) || (player.getXpos() > Main.width/2 - 15 && worldx == mapwidth - Main.width)) onwallx = true;
		else player.setXpos(Main.width/2 -15);
		
		if((player.getYpos() < Main.height/2 - 15 && worldy == 0)|| (player.getYpos() > Main.height/2 - 15 && worldy == mapheight - Main.height)) onwally = true;
		else player.setYpos(Main.height/2 -15);
		
		
		player.update(tslf, onwallx, onwally);
	}
	public void draw(Graphics g)
	{	
		int minx = (int) (worldx / Texture.tilesize);
		int maxx = (int) ((worldx + Main.width) / Texture.tilesize) + 1;
		int miny = (int) (worldy / Texture.tilesize);
		int maxy = (int) ((worldy + Main.height) / Texture.tilesize) + 1;
		if(maxx > width) maxx = width;
		if(maxy > height) maxy = height;
		for(int x = minx; x < maxx; x++)
		{
			for (int y = miny; y < maxy; y++) 
			{
				tiles[x][y].draw(g, (int) worldx * -1, (int) worldy * -1);
			}
			
			player.draw(g);
		}	
	}
}
