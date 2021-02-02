import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject {
	
	Handler handler;
	Game game;

	public Wizard(int x, int y, ID id, Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
	}

	public void tick() {
		
		collision();
		
		x += velX;
		y += velY;
		
		//movement
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
		
	}
	
	
	
	 public boolean place_free(int x, int y, Rectangle myRect, Rectangle otherRect) {
		  myRect.x = x;
		  myRect.y = y;
		  if (myRect.intersects(otherRect)) {
		   return false;
		  }
		  return true;
	}
		 
	 public void collision() {
		 
		 for (int i = 0; i < handler.object.size(); i++) {
			 GameObject tempObject = handler.object.get(i);

			 if (tempObject.getId() == ID.Block) {
				 if (!place_free((int) (x + velX), y, getBounds(), tempObject.getBounds())) {
					 velX = 0;
		     		}

				 if (!place_free(x, (int) (y + velY), getBounds(), tempObject.getBounds())) {
					 velY = 0;
				 	}
			 	}
			 
			 if(tempObject.getId() == ID.Crate) {
				 
				 if(getBounds().intersects(tempObject.getBounds())) {
					 game.ammo += 10;
					 handler.removeObject(tempObject);
				 	}
			 	}
		 	}
	 }

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 48);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
