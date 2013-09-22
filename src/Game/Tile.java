package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	private int x;
	private int y;
	private int lookid;
	private BufferedImage look;
	public Tile(int x, int y, int lookid)
	{
		this.x = x;
		this.y = y;
		this.lookid = lookid;
		if(lookid == 0) look = Texture.gras;
		if(lookid == 1) look = Texture.wasser;
		if(lookid == 2) look = Texture.sand;
		if(lookid == 3) look = Texture.mauer;
		
	}
	
	public void draw(Graphics g, int worldx, int worldy)
	{
		g.drawImage(look, x * Texture.tilesize + worldx + Frame.transx, y *Texture.tilesize + worldy + Frame.transy, null);
	}
	public int getLookID()
	{
		return lookid;
	}
}
