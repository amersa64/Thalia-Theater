package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import seating.Section;

public class TestSeat {

	@Test
	public void testSeat() {
		Section sec = new Section("A", 4,2);
		System.out.println(sec.toString());
	}
	
	@Test
	public void seatInRow() {
		Section sec = new Section("A", 4,2);
		for (int i = 0; i < sec.getRows().length; i++){
			if (sec.getRows()[i].getSeats()[0].getId()== 0){
				System.out.println("Right");
			}
			else{
				System.out.println(sec.getRows()[i].getSeats()[0].getId());
			}
		}
	}

}
