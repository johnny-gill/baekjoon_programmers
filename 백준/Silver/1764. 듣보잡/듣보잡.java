import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	Set<String> set = new HashSet<>();
    	for (int i = 0; i < N; i++) {
    		set.add(br.readLine());
    	}
    	
    	List<String> result = new ArrayList<>();
    	for (int i = 0; i < M; i++) {
    		String str = br.readLine();
			if (set.contains(str)) {
				result.add(str);
			}
    	}
    	
    	Collections.sort(result);
    	System.out.println(result.size());
    	result.forEach(t -> System.out.println(t));
    }
}