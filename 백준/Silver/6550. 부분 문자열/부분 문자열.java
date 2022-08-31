import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = "";
    	while ((str = br.readLine()) != null) {
    		StringTokenizer st = new StringTokenizer(str);
        	String s = st.nextToken();
        	String t = st.nextToken();
        	
        	int cnt = 0;
        	int tIdx = 0;
        	
        	for (int i = 0; i < s.length(); i++) {
        		char left = s.charAt(i);
        		
        		boolean isExist = false;
        		for (int j = tIdx; j < t.length(); j++) {
        			char right = t.charAt(j);
        			
        			if (left == right) {
        				cnt++;
        				tIdx = j + 1;
        				isExist = true;
        				break;
        			}
        		}
        		
        		if (!isExist) {
        			break;
        		}
        	}
        	
        	System.out.println(s.length() == cnt ? "Yes" : "No");
    	}
    }
}