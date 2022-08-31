import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	Map<String, Integer> map = new HashMap<>();
    	int line = Integer.parseInt(br.readLine());
    	while(line-- > 0) {
    		String ext = br.readLine().split("\\.")[1];
    		map.put(ext, map.getOrDefault(ext, 0) + 1);
    	}
    	
    	List<String> keyList = new ArrayList<>(map.keySet());
    	Collections.sort(keyList);
    	
    	for (String key : keyList) {
			System.out.println(key + " " + map.get(key));
		}
    }
}