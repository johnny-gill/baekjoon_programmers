import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int line = Integer.parseInt(br.readLine());
    	String[] words = new String[line];
    	
    	for (int i = 0; i < line; i++) {
    		words[i] = br.readLine();
    	}

    	Arrays.sort(words, (o1, o2) -> {
    		int o1Len = o1.length();
			int o2Len = o2.length();
			return (o1Len != o2Len) ? o1Len - o2Len : o1.compareTo(o2);
    	});
    	
    	String prev = "";
    	for (String word : words) {
    		if (prev.equals(word)) continue;
    		prev = word;
			System.out.println(word);
		}
    }
}