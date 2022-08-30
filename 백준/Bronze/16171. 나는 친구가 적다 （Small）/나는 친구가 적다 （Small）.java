import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str1 = br.readLine().replaceAll("[0-9]", "");
    	String str2 = br.readLine();
    	System.out.println(str1.contains(str2) ? 1 : 0); 
    }
}