package Game;

public class Collision
{
	public static boolean circleToRect(float cx, float cy, int radius, float rectx, float recty, int width, int height)
	{
		if(cx >= rectx && cx <= rectx + width)
		{
			if((cy - recty) * (cy - recty) <= radius * radius) return true;
			if((cy - (recty + height)) * (cy - (recty + height)) <= radius * radius) return true;
			
		}
		if(cy >= recty && cy <= recty + height)
		{
			if((cx - rectx) * (cx - rectx) <= radius * radius) return true;
			if((cx - (rectx + width)) * (cx - (rectx + width)) <= radius * radius) return true;			
		}
		
		for(int x = 0; x < 2; x++)
		{
			for(int y = 0; y < 2; y++)
			{
				float absx = cx - (rectx + x * width);
				float absy = cy - (recty + y * height);
				float abs = absx * absx + absy * absy;
				if(abs <= radius * radius) return true;
			}
		}
		if(cx >= rectx && cx <= rectx + width && cy >= recty && cy <= recty + height) return true;
		return false;
	}
}
