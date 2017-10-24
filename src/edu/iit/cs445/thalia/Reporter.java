package edu.iit.cs445.thalia;


public class Reporter {
	private Thalia thalia;
	private static Reporter instance = null;
	int idCounter;

	protected Reporter(Thalia thalia) {
		this.thalia=thalia;
		// Exists only to defeat instantiation.
	}
	public void use(Thalia thalia){
		this.thalia =thalia;
	}

	public static Reporter getInstance(Thalia thalia) {
		if (instance == null) {
			instance = new Reporter(thalia);
		}
		return instance;
	}

}
