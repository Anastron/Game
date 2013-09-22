package Game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Menu 
{
	private Soundplayer sound;
	private BufferedImage background;
	private BufferedImage title;
	private Button[] buttons;
	private float x;
	private float xspeed;
	
	public Menu()
	{
		buttons = new Button[3];
		
		BufferedImage[] textures = {Texture.button, Texture.buttonmouseover, Texture.buttonpressed};
		
		Font f = new Font("SanSerif", 0, 30);
		
		buttons[0] = new Button(200, "Spielen", textures,f);
		buttons[1] = new Button(350, "Optionen", textures, f);
		buttons[2] = new Button(500, "Beenden", textures, f);
		
		background = Texture.background;
		title = Texture.title;
		
		xspeed = 50;
		
		sound = new Soundplayer("sfx/select.wav");
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(background, Frame.transx, Frame.transy, Main.width + Frame.transx, Main.height + Frame.transy,
				(int) -x, 0, (int) -x + Main.width, Main.height, null);
		g.drawImage(title, Main.width / 2 - title.getWidth() / 2 + Frame.transx, 10 + Frame.transy, null);
		for(int i = 0; i < buttons.length; i++)
		{
			buttons[i].draw(g);
		}
	}
	public void update(float tslf)
	{
		x += xspeed * tslf;
		if(x > 0)
		{
			x = 0;
			xspeed *= -1;
		} else if(x < -background.getWidth() + Main.width)
		{
			x = -background.getWidth() + Main.width;
			xspeed *= -1;
		}
		for(int i = 0; i < buttons.length; i++)
		{
			if(buttons[i].update())
			{
				sound.play();
				sound.setVolume(6);
				if(i == 0) Frame.gamestate = 1;
				else if(i == 1);
				else if(i == 2) System.exit(0);
			}
		}
			
	}
	
}
