package week5;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SlickFlyingGame extends BasicGame 
	{ 
        int count = 0;
        Image background;
        Image plane;
        Image balloon;
        Random randPos = new Random();
    	int x = randPos.nextInt(800);
    	int y = randPos.nextInt(600);
    	float xPlane = 800/2;
    	float yPlane = 600/2;
    	float xmax = 800;
    	float ymax = 600;
    	float xmin = 0;
    	float ymin = 0;
    	float yMove = 1;
    	
    	
	
		public SlickFlyingGame() {
				super("SlickFLyingGame"); 
	    } 
		
		@Override 
	    public void init(GameContainer container) 
	    	throws SlickException {
			
			 background = new Image("assets/land.jpeg");
			 plane = new Image("assets/plane.png");
			 balloon = new Image("assets/balloon.png");

		} 
	    
	    @Override public void update(GameContainer gc, int delta) 
	    throws SlickException {
            Input input = gc.getInput();
          
	        if(input.isKeyDown(Input.KEY_UP))
	        { 
	        	
	        	
	        	if (yPlane > 0) {
	        		yPlane--;
	        		plane.draw(xPlane, yPlane);
	        	}
	        	else if (yPlane <= 0) {
	        		plane.draw(xPlane, 0);
	        		
	 
	        	}
	       
	        }
	 
	        if(input.isKeyDown(Input.KEY_DOWN))
	        {
	        	plane.draw(xPlane, yPlane++);
	        }
	        
	    } 
	    
	    @Override public void render(GameContainer container, Graphics g) 
	    throws SlickException { 
	    	background.draw(0,0);
	    	//plane.drawCentered((float) background.getWidth()/2, (float) background.getHeight()/2);
	    	plane.drawCentered(xPlane,yPlane);
	    	balloon.draw(x, y);
	    	g.drawString("Count = " + count, 100, 100); 
	    	
	    	
	    } 
	    
	    public static void main(String[] args) { 
	    	
	    	try { 
	    		AppGameContainer app = new AppGameContainer(new SlickFlyingGame()); 
	    		app.setDisplayMode(800, 600, false);
	            app.start();

	    		
	    	} catch (SlickException e) { 
	    		e.printStackTrace(); 
	    	} 
	    }
}
