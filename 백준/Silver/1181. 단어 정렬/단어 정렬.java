import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	private static final List<String> words = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int line = Integer.parseInt(br.readLine());
    	while (line-- > 0) {
    		String str = br.readLine();
    		if (words.contains(str)) continue;
    		words.add(str);
    	}

    	Collections.sort(words, (o1, o2) -> {
    		int o1Len = o1.length();
			int o2Len = o2.length();
			return (o1Len != o2Len) ? o1Len - o2Len : o1.compareTo(o2);
    	});
    	
    	words.forEach(word -> System.out.println(word));
    }
}