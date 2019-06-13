package holdthedoor;

public class Light implements Listener{
	
	public void switchOn(int floor,int num) {
		System.out.println("Light On of door " +num+ "|floor " + floor);
	}
	
	public void switchOff(int floor,int num) {
		System.out.println("Light Off of door " +num+ "|floor " + floor);
	}

}
