package RestAssuredPractice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONObjectUSingJacksonAPI {

	@Test
	public void creatUser() {

		/*
		 * 
		 * { "id": 101, "name": "John Doe", "address": { "street": "MG Road", "city":
		 * "Bangalore", "zip": 560001, "geo": { "lat": 12.9716, "lng": 77.5946 } }
		 */

		ObjectMapper objectmapper = new ObjectMapper();

		ObjectNode objectnode = objectmapper.createObjectNode();

		objectnode.put("id", 101);

		objectnode.put("name", "John Doe");

		ObjectNode objectnestednode = objectmapper.createObjectNode();

		objectnestednode.put("street", "MG Road");

		objectnestednode.put("city", "Bangalore");

		objectnestednode.put("zip", 560001);
		

		ObjectNode objectnestednestednode = objectmapper.createObjectNode();

		objectnestednestednode.put("lat", 12.9716);

		objectnestednestednode.put("lng", 77.5946);
		
		objectnode.set("Hobbies", objectmapper.convertValue(Arrays.asList("cooking","listening"), JsonNode.class));

		objectnode.set("address", objectnestednode);

		objectnode.set("geo", objectnestednestednode);

		try {

			String Userdetailasstring = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectnode);

			System.out.println(Userdetailasstring);
		}

		catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		int id = objectnode.get("id").asInt();

		System.out.println(id);

		String cityname = objectnode.get("address").get("city").asText();

		System.out.println(cityname);

		Iterator<String> firstnamelist = objectnode.fieldNames();

		while (firstnamelist.hasNext()) {

			System.out.println(firstnamelist.next());
		}

		Iterator<JsonNode> valuelist = objectnode.elements();

		while (valuelist.hasNext()) {

			System.out.println(valuelist.next());
		}

		Iterator<Entry<String, JsonNode>> allvaluelist = objectnode.fields();

		while (allvaluelist.hasNext()) {

			System.out.println(allvaluelist.next());
		}

		int removeddata = objectnode.remove("id").asInt();

		System.out.println(removeddata);

		objectnode.put("name", "Ankit");
		
		objectnestednode.put("zip", 57788);
		
		objectnode.set("address", objectnestednode);


		try {

			String Userdetailasstring = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectnode);

			System.out.println(Userdetailasstring);
		}

		catch (JsonProcessingException e) {

			e.printStackTrace();
		}

	}

}
