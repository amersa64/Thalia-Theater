package edu.iit.cs445.thalia;

public class tst {
	
	public static void main(String[]args){
		 testVals tv = new testVals();
		 testVals[] tva = {tv};
		 
		 Test testing = new Test();
		 testing.getStringAsJSON(tva);
			 
	}

}
