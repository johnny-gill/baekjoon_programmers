import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final boolean[] alpha = new boolean[26];
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int line = Integer.parseInt(br.readLine());
    	int cnt = 0;
    	while (line-- > 0) {
    		String str = br.readLine();
    		
    		char before = 0;
    		boolean isNotGrp = true;
    		for (char c : str.toCharArray()) {
				if (!alpha[c - 'a']) {
					alpha[c - 'a'] = true;
					before = c;
				} else if (alpha[c - 'a'] && c == before) {
					continue;
				} else {
					isNotGrp = false;
					break;
				}
			}
    		
    		Arrays.fill(alpha, false);
    		
    		if (isNotGrp) {
    			cnt++;
    		}
    	}
    	
    	System.out.println(cnt);
    }
}