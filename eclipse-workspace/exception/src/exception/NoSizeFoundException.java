package exception;

@SuppressWarnings("serial")
public class NoSizeFoundException extends Exception{
	private int size;
	
	public NoSizeFoundException(int size) {
		this.size = size;
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No stock for size " + size;
	}
	
	
}
