import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	
	static int N, M, V;
	static List<List<Integer>> node;
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
		
		node = new ArrayList<>();
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			node.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node.get(a).add(b);
			node.get(b).add(a);
		}
		
		
		for (int i = 0; i < N; i++) {
			Collections.sort(node.get(i));
		}
		
		dfs(V);
		bw.newLine();
		visit = new boolean[N];
		bfs(V);
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int v) throws IOException {
		bw.write(String.valueOf(v) + " ");
		visit[v] = true;
		
		for (int val : node.get(v)) {
			if(!visit[val]) {
				dfs(val);
			}
		}
	}
	
	private static void bfs(int v) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visit[v] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			bw.write(String.valueOf(poll) + " ");
			
			for (int val : node.get(poll)) {
				if(!visit[val]) {
					visit[val] = true;
					q.offer(val);
				}
			}
		}
	}
}