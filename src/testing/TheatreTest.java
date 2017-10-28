package testing;

import java.time.*;

import org.junit.Before;
import org.junit.Test;

import seating.SeatingConfiguration;
import thalia.Show;

public class TheatreTest {
	SeatingConfiguration[] theatres;
	Show[] shows;

	@Before
	public void setUp(){
		theatres= new SeatingConfiguration[3];
		shows = new Show[3];
		LocalTime time = LocalTime.of(11, 40, 50);
		LocalDate date = LocalDate.of(2017, 10, 28);
		int length = 120;
		String description = "Test Description";
		
		
		for (int j = 0; j < theatres.length; j++) {
			if(j==0){
				theatres[j]= new SeatingConfiguration();
				shows[j] = new Show(time, date, theatres[j], j, length, description);
			}
			if(j==1){
				int[] s = {1};
				theatres [j]= new SeatingConfiguration(s);
				shows[j] = new Show(time, date, theatres[j], j, length+1, description);
			}
			if(j==2){
				int[] s = {0,3};
				theatres [j]= new SeatingConfiguration(s);
				shows[j] = new Show(time, date, theatres[j], j, length+2, description);
			}
		}
		for (int i = 0; i < shows[1].getSeatingConfiguration().getSections()[0].getRows()[0].getSeats().length; i++){
			shows[1].getSeatingConfiguration().getSections()[0].getRows()[0].getSeats()[i].setTaken(true);
		}
		for (int l = 0; l < shows[1].getSeatingConfiguration().getSections()[0].getRows().length; l ++){
			System.out.println(shows[1].getSeatingConfiguration().getSections()[0].getRows()[l].toString());
		}
		for (int m = 0; m < shows[0].getSeatingConfiguration().getSections()[0].getRows().length; m ++){
			System.out.println(shows[0].getSeatingConfiguration().getSections()[0].getRows()[m].toString());
		}
	}

	@Test
	public void test() {

	}

}
