package holdthedoor;

public class AC implements Listener {

	@Override
	public void switchOn(int floor, int num) {
		System.out.println("AC On of door " +num+ "|floor " + floor);
		
	}

	@Override
	public void switchOff(int floor, int num) {
		System.out.println("Ac Off of door " +num+ "|floor " + floor);
		
	}
	
}
