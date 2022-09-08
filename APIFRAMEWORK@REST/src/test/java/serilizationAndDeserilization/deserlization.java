package serilizationAndDeserilization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOClassForSerializationAndDeserialization.Employee;
import POJOClassForSerializationAndDeserialization.Spouse;

public class deserlization {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper object = new ObjectMapper();
		Employee deserilization = object.readValue(new File("./rama.json"), Employee.class);

		Spouse address = deserilization.getSpouse();
		System.out.println(deserilization.getEmpId());
		System.out.println(deserilization.getEmpName());
		for (int i = 0; i < deserilization.getPhoneNumber().length; i++) {
			System.out.println(deserilization.getPhoneNumber()[i]);
		}

		for (int i = 0; i < deserilization.getEmpEmail().length; i++) {

			System.out.println(deserilization.getEmpEmail()[i]);		
		}
		System.out.println(address.getId());
		System.out.println(address.getPhNumber());
		System.out.println(address.getSpEmail());
		System.out.println(address.getSpName());

	}

}
