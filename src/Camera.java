
public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObject object) {
		
		// An algorithm to move the camera
		x += ((object.getX() - x) - 1000/2) * 0.05f;
		y += ((object.getY() - y) - 563/2) * 0.05f;
		
		if(x <= 0) x = 0;
		if(x >= 1032+32) x = 1032+32;
		if(y <= 0) y = 0;
		if(y >= 563+64) y = 563+64;
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
