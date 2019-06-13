package application;
import exception.*;
public class Order {
	
	public boolean orderItem(int size,String color) throws NoSizeFoundException,NoColorFoundException{
		if(size <= 15) {
			throw new NoSizeFoundException(size);
		}
		else if(color.equals("black")==false) {
			throw new NoColorFoundException(color);
		}
		else {
			return true;
		}
	}
}
