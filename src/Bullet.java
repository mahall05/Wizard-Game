import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

	private Handler handler;
	
	public Bullet(int x, int y, ID id, Handler handler, int mx, int my, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		
		//velX = (mx - x) / 10;
		//velY = (my - y) / 10;
		
		double distance = Math.sqrt(Math.pow((mx - x), 2) + Math.pow((my - y), 2));
		double speed = 10; //set the speed in [2,n)  n should be < 20 for normal speed
		//find Y
		velY = (float)((my - y) * speed / distance);
		//find X
		velX = (float)((mx - x) * speed / distance);
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.object.size(); i ++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}
	
	

}
