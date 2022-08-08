import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	
	static List<Integer>[] node;
	static boolean[] visit;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()) + 1;
		
		node = new ArrayList[N];
		visit = new boolean[N];
		result = new int[N];
		
		for (int i = 0; i < N; i++) {
			node[i] = new ArrayList();
		}
		
		for (int i = 0; i < N - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a].add(b);
			node[b].add(a);
		}
		
		visit[1] = true;
		dfs(1);
		
		for (int i = 2; i < N; i++) {
			bw.write(String.valueOf(result[i]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int parent) {
		for (int child : node[parent]) {
			if (!visit[child]) {
				visit[child] = true;
				result[child] = parent;
				dfs(child);
			}
		}
	}
	
}