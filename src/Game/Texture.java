package Game;

import java.awt.image.BufferedImage;

public class Texture 
{
	static BufferedImage gras = Imageloader.loadImage("Gras");
	static BufferedImage wasser = Imageloader.loadImage("Wasser");
	static BufferedImage sand = Imageloader.loadImage("Sand");
	static BufferedImage mauer = Imageloader.loadImage("Mauer");
	static int tilesize = gras.getHeight();
}
