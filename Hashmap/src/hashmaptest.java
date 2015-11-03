import java.util.HashMap;
import java.util.Iterator;

public class hashmaptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("1111", 1);
		map.put("22222", 2);
		map.put("333", 3);
		
		for (Iterator<String> i = map.keySet().iterator(); i.hasNext();)
		{
			String key = i.next();
			System.out.println("Key = " + key);
			int value = map.get(key);
			System.out.println("value = " + value);
		}

	}

}
