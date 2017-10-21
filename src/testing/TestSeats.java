package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import seating.Section;

public class TestSeats {

	@Test
	public void test() {
		Section mySec = new Section("A",5, 10);
		System.out.println(mySec.toString());
	}
	

}
