package serilizationAndDeserilization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOClassForSerializationAndDeserialization.MoreDetailsOfEmployee;

public class Employee1Ser {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		String [] emails={"sachi@gmail.com","sachi@ty.com"};
		long [] phoneNumber={010101010101,2020202020};
		MoreDetailsOfEmployee emp1 = new MoreDetailsOfEmployee("sachin1225",emails,phoneNumber,999);
		ObjectMapper objectmapper = new ObjectMapper();
		objectmapper.writeValue(new File("./MoreEmployeeDetails.json"), emp1);
	}
}
