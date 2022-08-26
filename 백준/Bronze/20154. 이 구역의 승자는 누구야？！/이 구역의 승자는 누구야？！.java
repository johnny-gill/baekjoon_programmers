import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int[] alpha = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	int sum = 0;
    	for (int i = 0; i < str.length(); i++) {
    		 sum += alpha[str.charAt(i) - 'A'];
    	}
    	
    	System.out.println((sum % 2 == 0)? "You're the winner?" : "I'm a winner!");
    }
}