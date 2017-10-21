package seating;

import utility.TheaterIDGenerator;

public class Theatre {
	Section[] Sections;
	int id;
	private static String[] sectionNames = {"A", "B", "C", "D"};
	
	public Theatre(){
		this.id = TheaterIDGenerator.getInstance().getNext();
		Sections = new Section[4];
		
		for (int i = 0; i < Sections.length; i++){
			if (i == 0 || i == 3){
				Sections[i] = new Section(sectionNames[i], 5, 3);
			}
			else{
				Sections[i] = new Section(sectionNames[i], 4, 2);
			}
		}
	}
	
	public Theatre(int[] activatedSections){
		this.id = TheaterIDGenerator.getInstance().getNext();
		Sections = new Section[activatedSections.length];
		int counter = 0;
		
		for (int i : activatedSections){
			if (i == 0 || i == 3){
				Sections[counter] = new Section(sectionNames[i], 5, 3);
			}
			else{
				Sections[counter] = new Section(sectionNames[i], 4, 2);
			}
			counter++;
		}
	}

}
