package utility;

public class SectionIDGenerator {
	private static SectionIDGenerator instance = null;
	int idCounter;

	protected SectionIDGenerator() {
		idCounter=0;
		
		// Exists only to defeat instantiation.
	}
	public int getNext(){
		return idCounter++;
	}

	public static SectionIDGenerator getInstance() {
		if (instance == null) {
			instance = new SectionIDGenerator();
		}
		return instance;
	}
}
