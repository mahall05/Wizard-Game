import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();     // An array of objects
	
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
