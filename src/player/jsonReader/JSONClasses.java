package player.jsonReader;

import org.json.*;
import player.PlayerClass;

public class JSONClasses {

	
	static public PlayerClass readClass(String name){
		
		String str = "{ \"name\": \"Alice\", \"age\": 20 }";
		JSONObject obj = new JSONObject(str);
		String n = obj.getString("name");
		int a = obj.getInt("age");
		System.out.println(n + " " + a);  // prints "Alice 20"
		
		return null;
				
	}
	
	
	
}
