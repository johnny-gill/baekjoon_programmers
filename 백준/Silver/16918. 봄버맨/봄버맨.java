import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, S;
	private static char[][] input;
	private static boolean[][] visit;
	private final static int[] dx = {1, 0, -1, 0};
	private final static int[] dy = {0, 1, 0, -1};
    private final static char BOMB = 'O';
    private final static char EMPTY = '.';
    
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        input = new char[N][M];
        visit = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
        	String readLine = br.readLine();
        	for (int j = 0; j < M; j++) {
        		input[i][j] = readLine.charAt(j);
        	}
        }
        
        if (S == 1) {
    		print(input);
    	} else if (S % 2 == 0) {
    		print(BOMB);
    	} else {
    		int length = S / 2;
    		for (int s = 0; s < length; s++) {
           		Queue<int[]> q = new LinkedList<>();
           		for (int i = 0; i < N; i++) {
           			for (int j = 0; j < M; j++) {
           				if (input[i][j] == BOMB) {
           					input[i][j] = EMPTY;
           					q.offer(new int[] {i, j});
               				visit[i][j] = true;
           				} else if (input[i][j] == EMPTY) {
           					input[i][j] = BOMB;
           				}
           			}
           		}
           		
           		while(!q.isEmpty()) {
           			int[] poll = q.poll();
           			int x = poll[0];
           			int y = poll[1];
           			
           			for (int i = 0; i < 4; i++) {
           				int nx = x + dx[i];
           				int ny = y + dy[i];
           				
           				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
           				if (input[nx][ny] == EMPTY) continue;
           				input[nx][ny] = EMPTY;
           			}
           		}
    		}
    		print(input);
    	}
    }

	private static void print(char bomb) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(bomb);
			}
			System.out.println();
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}