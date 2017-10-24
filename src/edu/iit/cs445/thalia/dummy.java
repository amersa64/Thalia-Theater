package edu.iit.cs445.thalia;

import org.json.JSONException;
import org.json.JSONObject;

public class dummy {

	public static void main(String[] args) throws JSONException {
		System.out.println(myF());

	}
	public static String myF() throws JSONException{
		 JSONObject mine = new JSONObject();
		 try{
			 mine.put("hi1", "bye");
			 return mine.getString("hi1");
		 }
		 catch(Exception c){
		 }
		 return "hi";
	}

}
