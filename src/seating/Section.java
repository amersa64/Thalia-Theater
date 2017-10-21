package seating;

import java.util.Arrays;

public class Section {
	String Name;
	Row[] Rows;
	static double sideSectionPrice = 2;
	static double regularSectionPrice = 5;
	
	public Section(String Name, int rows, int seats){
		this.Name = Name;
		this.Rows = new Row[rows];
		for (int i =0;i<rows;i++){
			this.Rows[i] = new Row(seats, i);
		}
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Row[] getRows() {
		return Rows;
	}
	public void setRows(Row[] rows) {
		Rows = rows;
	}
	@Override
	public String toString() {
		return "Section [Name=" + Name + ", Rows=" + Arrays.toString(Rows) + "]";
	}
	
}
