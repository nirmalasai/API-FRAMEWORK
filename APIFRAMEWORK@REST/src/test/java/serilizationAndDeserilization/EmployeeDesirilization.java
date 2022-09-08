package serilizationAndDeserilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import POJOClassForSerializationAndDeserialization.Employee;

public class EmployeeDesirilization {

	public static void main(String[] args) throws Throwable, JsonMappingException, IOException {

		ObjectMapper obj = new ObjectMapper();
		Employee des = obj.readValue(new File("./emp.json"), Employee.class);
		System.out.println(des.getEmpEmail()+"\t"+des.getEmpId()+"\t"+des.getEmpName()+"\t"+des.getPhoneNumber());
	}

}
