import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static boolean[][] node;
	static boolean[] visit;
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		node = new boolean[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = node[b][a] = true;
		}
		
		dfs(V);
		bw.newLine();
		visit = new boolean[N];
		bfs(V);
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int start) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int val = q.poll();
			bw.write(String.valueOf(val) + " ");
			
			for (int i = 1; i < N; i++) {
				if (node[val][i] && !visit[i]) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}


	private static void dfs(int start) throws IOException {
		bw.write(String.valueOf(start) + " ");
		visit[start] = true;
		
		for (int i = 1; i < N; i++) {
			if (node[start][i] && !visit[i]) {
				dfs(i);
			}
		}
	}
}