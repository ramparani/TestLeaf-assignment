package week3.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			Map<String,String>mp = new HashMap<String,String>();
			mp.put("AC001", "Babu");
			mp.put("AC002", "Gopi");
			mp.put("AC003", "Sarath");
			mp.put("AC004", "Balaji");
			
//count
			System.out.println(mp.size());
/*			
//Pick value from map
			System.out.println(mp.get("AC003"));
//remove entry
			mp.remove("ACOO2");
			System.out.println(mp.size());
//validation
			System.out.println(mp.containsKey("AC001"));
			System.out.println("Balaji");
//Remove all entries
			mp.clear();
//Validate whether is empty or not
			System.out.println(mp.isEmpty());
*/
//To print all key and value
			for(Entry<String, String> eachItem : mp.entrySet()) {
			System.out.println(eachItem);
			System.out.println(eachItem.getKey());
			System.out.println(eachItem.getValue());
			}
			

			
			
	}

}
