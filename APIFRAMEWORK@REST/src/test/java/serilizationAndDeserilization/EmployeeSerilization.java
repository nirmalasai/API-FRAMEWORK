package serilizationAndDeserilization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOClassForSerializationAndDeserialization.Employee;

public class EmployeeSerilization {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Employee emp = new Employee("sanju",108,"ravi@gmail.com",10810810);
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File(".\\src\\test\\resources\\modi1.json"), emp);
	}

}
