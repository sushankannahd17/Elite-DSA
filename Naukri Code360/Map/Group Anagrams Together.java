import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<String>> groupAnagramsTogether(ArrayList<String> strList) {
		// Write your code here.
		Map<String, ArrayList<String>> map=new HashMap<>();

		for (String str : strList) {
			char[] ch=str.toCharArray();
			Arrays.sort(ch);
			map.putIfAbsent(new String(ch), new ArrayList<>());
			map.get(new String(ch)).add(str);
		}

		ArrayList<ArrayList<String>> res=new ArrayList<>();
		for (String key:map.keySet()) {
			res.add(map.get(key));
		}

		return res;
	}
}