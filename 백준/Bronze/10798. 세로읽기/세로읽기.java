import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final char[][] map = new char[15][15];
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for (int i = 0; i < 5; i++) {
    		String line = br.readLine();
    		for (int j = 0; j < line.length(); j++) {
    			map[j][i] = line.charAt(j);
    		}
    	}
    	
    	for (int i = 0; i < 15; i++) {
    		for (int j = 0; j < 15; j++) {
    			if (map[i][j] == 0) continue;
    			System.out.print(map[i][j]);
    		}
    	}
    }
}