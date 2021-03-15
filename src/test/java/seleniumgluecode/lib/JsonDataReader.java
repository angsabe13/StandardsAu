package seleniumgluecode.lib;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {
	private List<Customer> customerList;
	
	public JsonDataReader(){
		customerList = getCustomerData();
	}
	
	public final Customer getCustomerById(String id){
		 return customerList.stream().filter(x -> x.id.equalsIgnoreCase(id)).findAny().get();
	}
	
	private List<Customer> getCustomerData() {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Customer> customerList = null;
		try {
			customerList = objectMapper.readValue(new File("src\\test\\java\\seleniumgluecode\\resources\\jsonTestFile.json"), new TypeReference<List<Customer>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;
	}

}