package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button 
{
	private int x;
	private int y;
	private Font font;
	private FontMetrics fm;
	private String name;
	private BufferedImage[] look;
	private int show;
	public Button(int y, String name, BufferedImage[] look, Font font)
	{
		this.y = y;
		this.name = name;
		this.look = look;
		this.font = font;
		
		x = Main.width / 2 - look[0].getWidth() / 2;
	}
	public void draw(Graphics g)
	{
		g.setFont(font);
		fm = g.getFontMetrics();
		g.drawImage(look[show], x, y, null);
		g.setColor(Color.BLACK);
		g.drawString(name, x + look[show].getWidth() / 2 - fm.stringWidth(name) / 2, y + look[show].getHeight() / 2 + font.getSize() / 2);
	}
	public boolean update()
	{
		if(Keyboard.getButton() != 1 && show == 2)
		{
			show = 0;
			return true;
		}
		show = 0;
		int mx = Keyboard.getMouseX();
		int my = Keyboard.getMouseY();
		
		if(Collision.recToRect(mx, my, 0, 0, x, y, look[show].getWidth(), look[show].getHeight()))
		{
			if(Keyboard.getButton() == 1) show = 2;
			else show = 1;
		}
		return false;
	}
}
