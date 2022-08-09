import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int n;
	static int[] visited;
	static List<Integer>[] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adj = new ArrayList[n+1];
		visited = new int[n+1];
		for(int i=1; i<n+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
		}

		int max_value = Integer.MIN_VALUE;
		for(int i=1; i<n+1; i++) {
			bfs(i);
		}

		for(int i=1; i<n+1; i++) {
			max_value = Math.max(visited[i], max_value);
		}

		for(int i=1; i<n+1; i++) {
			if(max_value == visited[i]) {
				bw.write(i+" ");
			}
		}
		bw.flush();
		bw.close();
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[n+1];
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()) {
			int pos = q.poll();
			for(int next : adj[pos]) {
				if(!check[next]) {
					check[next] = true;
					visited[next]++;
					q.add(next);
				}
			}
		}
	}
}