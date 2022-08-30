import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str1 = br.readLine();
    	String str2 = br.readLine();
    	
    	String newStr1 = "";
    	for (char c : str1.toCharArray()) {
			if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z') {
				newStr1 += c;
			}
		}
    	
    	int str1Len = newStr1.length();
    	int str2Len = str2.length();
    	int isExist = 0;
		for (int i = 0; i < str1Len; i++) {
			if (str1Len < i + str2Len) break;
			String subStr = newStr1.substring(i, i + str2Len);
    		if (str2.equals(subStr)) {
    			isExist = 1;
    			break;
    		}
    	}
		
		System.out.println(isExist);
    }
}