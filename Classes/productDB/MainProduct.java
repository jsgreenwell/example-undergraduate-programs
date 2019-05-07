package productDB;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.util.ArrayList;
import java.util.HashMap;


public class MainProduct {
	public static void main(String[] args) throws IOException {
		// Connect to GSON and load our data (in Data folder)
		Gson gson = new Gson();
		JsonReader jread = new JsonReader(
				new FileReader("Data/products.json"));
		
		JsonTemplate[] jtemp = gson.fromJson(jread, JsonTemplate[].class);
		// Note because we are going through an array of jsons - 
		//    we need an array class "JsonTemplate[]"
		
		// Load our API & create our table
		ProductAPI pa = new ProductAPI();
		pa.create("product");
		
		// Now lets just check what is already in the Product Table
		// Just going to print it in this case
		ArrayList<HashMap<String, Object>> allResults = pa.selectAll("product");
		for (HashMap<String, Object> hm : allResults) {
			System.out.println("----------------");
			hm.forEach((k, v) -> System.out.println(k + " equals " + v));
			System.out.println("----------------");
		}
		
		// Finally let's insert some data
		// Will use stringBuilder or similar in video to build/map this
		// Main point for both: USE PLACEHOLDERS
		String insertQuery = "INSERT INTO product " + 
				"(oid, product_name,supplier,quantity,unit_cost)" +
				" VALUES (?, ?, ?, ?, ?)";
		
		pa.insertProd(insertQuery, jtemp);
		
		// In video we'll add the search query here
		
		// And close our connection at end
		pa.closeCon();
	}
}
