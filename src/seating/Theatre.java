package seating;

import java.util.Arrays;

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

	public Section[] getSections() {
		return Sections;
	}

	public void setSections(Section[] sections) {
		Sections = sections;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Sections);
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		if (!Arrays.equals(Sections, other.Sections))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
