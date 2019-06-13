package exception;

@SuppressWarnings("serial")
public class NoColorFoundException extends Exception {
	private String color;
	
	public NoColorFoundException(String color) {
		this.color = color;
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No stock for color " + color;
	}
}
