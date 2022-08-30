import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = "";
    	while(!"end".equals(str = br.readLine())) {
    		
    		boolean isAccept = true;
    		int vowelCnt = 0;
    		int consonantCnt = 0;
    		boolean hasVowel = false;
    		char prev = 0;
    		
    		for (char c : str.toCharArray()) {
    			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { // 모음
    				if (++vowelCnt == 3) {
    					isAccept = false;
        				break;
    				}
    				consonantCnt = 0;
    				hasVowel = true;
    			} else { // 자음
    				if (++consonantCnt == 3) {
    					isAccept = false;
        				break;
    				}
    				vowelCnt = 0;
    			}

    			if (prev == c && c != 'e' && c != 'o') {
    				isAccept = false;
    				break;
    			}
    			prev = c;
			}
    		
    		if (isAccept && !hasVowel) {
    			isAccept = false;
    		}
    		
    		System.out.println("<" + str + "> " + (isAccept ? "is acceptable." : "is not acceptable."));
    	}
    }
}