package serilizationAndDeserilization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOClassForSerializationAndDeserialization.Employee;
import POJOClassForSerializationAndDeserialization.Spouse;

public class AddingSpouseObject {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Spouse spouseObject = new Spouse("sita","sita@gmail.com",420,333366699);
		long[] phoneNumber= {225566997,998877441};
		String[] emails= {"ram@gmail.com","sita@gmail.com"};
		Employee ser = new Employee("rama",141,emails,phoneNumber,spouseObject);
		ObjectMapper objectmapper = new ObjectMapper();
		objectmapper.writeValue(new File("./rama.json"), ser);
	}

}
