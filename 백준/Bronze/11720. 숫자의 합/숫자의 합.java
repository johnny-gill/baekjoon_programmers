import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String length = br.readLine();
    	String number = br.readLine();
    	
    	int sum = 0;
    	for (char c : number.toCharArray()) {
			sum += c - '0';
		}
    	System.out.println(sum);
    }
}