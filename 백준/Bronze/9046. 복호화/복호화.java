import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[] alpha = new int[26];
	private static int max = 0;
	private static char result = 0;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int line = Integer.parseInt(br.readLine());
    	for (int i = 0; i < line; i++) {
    		String str = br.readLine();
    		for (char c : str.toCharArray()) {
    			if (c == ' ') continue;
				alpha[c - 'a']++;
			}
    		
    		for (int j = 0; j < 26; j++) {
    			max = Math.max(max, alpha[j]);
        	}
    		
    		for (int k = 0; k < 26; k++) {
    			if (alpha[k] == max) {
    				if (result != 0) {
    					result = '?';
    					break;
    				}
    				result = (char)('a' + k);
    			}
    		}
    		
    		System.out.println(result);
    		max = 0;
    		result = 0;
    		Arrays.fill(alpha, 0);
    	}
    }
}