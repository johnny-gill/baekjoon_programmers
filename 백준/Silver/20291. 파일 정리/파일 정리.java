import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	Map<String, Integer> map = new TreeMap<>();
    	int line = Integer.parseInt(br.readLine());
    	while(line-- > 0) {
    		String str = br.readLine();
    		String ext = str.substring(str.indexOf(".") + 1);
    		map.put(ext, map.getOrDefault(ext, 0) + 1);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	map.forEach((k, v) -> sb.append(k).append(" ").append(v).append("\n"));
    	System.out.println(sb);
    }
}