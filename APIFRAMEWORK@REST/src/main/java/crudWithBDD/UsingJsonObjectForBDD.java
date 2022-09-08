package crudWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;

public class UsingJsonObjectForBDD {


	public Object jsonObjectUsing() {
		Random ran = new Random();
		int randomNo = ran.nextInt(100);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sachin11");
		jobj.put("projectName", "India1"+randomNo);
		jobj.put("status", "playing");
		jobj.put("teamSize", 11);
		return jobj;
	}
}
