
package holdthedoor;

import java.util.*;
public class Door {
	private int floor;
	private int num;
	
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private ArrayList<Listener> arr = new ArrayList<Listener>();
	public Door(int floor, int num){
		this.floor = floor;
		this.num = num;
	}
	
	public void open() {
		System.out.println("door open");
		for(Listener lst : arr ) {
			lst.switchOn(floor,num);
		} 
		
	}
	
	public void close() {
		System.out.println("door close");
		for(Listener lst : arr ) {
			lst.switchOff(floor,num);
		} 
	}
	
	public void addListener(Listener lst) {
		System.out.println("Listener is added");
		arr.add(lst);
	}
	
	public void removeListener(Listener lst) {
		arr.remove(lst);
	}
}

