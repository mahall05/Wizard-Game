import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {
	
	ArrayList<GameObject> object = new ArrayList<GameObject>();     // An array of objects
	
	private boolean up = false, down = false, right = false, left = false;
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void tick() {
		for(int i = 0; i < object.size(); i ++) {     // Run the all the game objects
			GameObject tempObject = object.get(i);     // Stores each object inside "tempObject"
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i ++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject tempObject) {
		object.add(tempObject);
	}
	
	public void removeObject(GameObject tempObject) {
		object.remove(tempObject);
	}

}
