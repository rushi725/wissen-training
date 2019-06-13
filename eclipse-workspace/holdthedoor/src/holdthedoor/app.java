package holdthedoor;

public class app {
	public static void main(String[] args) {
		Door door = new Door(12,32);
		
		Light light = new Light();
		AC ac = new AC();
		door.addListener(light);
		door.open();
		door.close();
		door.addListener(ac);
		door.open();
		door.close();
		door.removeListener(light);
		door.open();
		door.close();
	}
}
