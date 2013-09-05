package Game;

public class Main 
{
	static int width = 800;
	static int height = 600;
	public static void main(String[] args) 
	{
		Frame frame = new Frame();
		frame.setSize(width, height);	
		frame.setDefaultCloseOperation(3);	//3 = Exit_ON_CLOSE
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		frame.makstrat();
		
		long lastFrame = System.currentTimeMillis();
		while(true)
		{
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = (float) ((thisFrame - lastFrame)/1000.0);
			lastFrame = thisFrame;
			
			
			
			frame.update(timeSinceLastFrame);
			
			frame.repaint();
			
			try
			{
				Thread.sleep(10);
			} catch(InterruptedException e)
			{
				
				e.printStackTrace();
			}
		}
	}
}
