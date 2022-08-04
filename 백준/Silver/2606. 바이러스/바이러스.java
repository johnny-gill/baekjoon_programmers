import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int node = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());
		int nodeLength = node + 1;
		
		boolean[][] arr = new boolean[nodeLength][nodeLength];
		boolean[] check = new boolean[nodeLength];
		
		for (int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = true;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		check[1] = true;
		int res = 0;
		
		while(!q.isEmpty()) {
			int nowVal = q.poll();
			for (int i = 1; i < nodeLength; i++) { // 
				if (!check[i] && arr[nowVal][i]) { // !check[2] && arr[1][2]
					q.offer(i);
					check[i] = true;
					res++;
				}
			}
		}
		
		System.out.println(res);
//		bw.write(String.valueOf(res));
//		bw.flush();
//		bw.close();
		br.close();
	}
}