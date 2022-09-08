package serilizationAndDeserilization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOClassForSerializationAndDeserialization.MoreDetailsOfEmployee;

public class Employee1Des extends Employee1Ser{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		MoreDetailsOfEmployee des1 = objectMapper.readValue(new File("./MoreEmployeeDetails.json"), MoreDetailsOfEmployee.class);
		System.out.println(des1.getEmpName());
		System.out.println(des1.getId());
		System.out.println(des1.getEmpPhoneNumber()[0]);
		System.out.println(des1.getEmpPhoneNumber()[1]);
	/*	System.out.println(des1.getEmpEmail()[0]);
		System.out.println(des1.getEmpEmail()[1]);*/

		for (int i = 0; i < des1.getEmpPhoneNumber().length; i++) {
			System.out.println(des1.getEmpPhoneNumber()[i]);
		}

		for (int i = 0; i < des1.getEmpEmail().length; i++) {

			System.out.println(des1.getEmpEmail()[i]);		
		}


	}

}
