#include <cstdio>
#include <queue>
using namespace std;
int n, m, map[101][101];
bool visited[101][101];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
struct Maze {
	int x, y, cnt;
};

void solve() {
	queue<Maze> q;
	q.push({ 0,0,1 });
	visited[0][0] = true;
	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		int cnt = q.front().cnt;
		if (x == n - 1 && y == m - 1) {
			printf("%d\n", cnt);
			return;
		}

		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
			if (map[nx][ny] == 0 || visited[nx][ny]) continue;
			q.push({ nx,ny, cnt + 1 });
			visited[nx][ny] = true;
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &map[i][j]);
		}
	}
	solve();
	return 0;
}