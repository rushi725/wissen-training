package quiz;

public class Ex1 {

	public static void main(String[] args) {
		String[] records= {
				"E1,IT,1000",
				"E2,HR,1000",
				"E3,IT,2000",
				"E4,SALES,4000"
		};
		
		
		int highest=0,secondHighest=0;
		for(String record:records) {
			String[] token=record.split(",");
			Double sal=Double.parseDouble(token[2]);
			
		}
	}
	
	

}
