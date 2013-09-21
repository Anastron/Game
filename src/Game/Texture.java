package Game;

import java.awt.image.BufferedImage;

public class Texture 
{
	static BufferedImage gras = Imageloader.loadImage("Gras");
	static BufferedImage wasser = Imageloader.loadImage("Wasser");
	static BufferedImage sand = Imageloader.loadImage("Sand");
	static BufferedImage mauer = Imageloader.loadImage("Mauer");
	static BufferedImage background = Imageloader.loadImage("Manu");
	static BufferedImage title = Imageloader.loadImage("Titel");
	static BufferedImage button = Imageloader.loadImage("Button");
	static BufferedImage buttonpressed = Imageloader.loadImage("Buttonpressed");
	static BufferedImage buttonmouseover = Imageloader.loadImage("ButtonMaus");
	static int tilesize = gras.getHeight();
}
