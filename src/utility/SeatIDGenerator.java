package utility;

public class SeatIDGenerator {
	private static SeatIDGenerator instance = null;
	int idCounter;

	protected SeatIDGenerator() {
		idCounter=0;
		// Exists only to defeat instantiation.
	}
	public int getNext(){
		return idCounter++;
	}
	public void reset(){
		idCounter =0;
	}

	public static SeatIDGenerator getInstance() {
		if (instance == null) {
			instance = new SeatIDGenerator();
		}
		return instance;
	}
}
