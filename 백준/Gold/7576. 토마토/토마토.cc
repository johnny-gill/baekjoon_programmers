#include <cstdio>
#include <queue>
using namespace std;
int m, n;
int map[1001][1001];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
struct Box {
	int x, y;
};
queue<Box> q;
void solve() {
	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
			if (map[nx][ny]) continue;
			q.push({ nx,ny });
			map[nx][ny] = map[x][y] + 1;
		}
	}
}

bool check(int &max) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!map[i][j]) return false;
			if (max < map[i][j])
				max = map[i][j];
		}
	}
	return true;
}

int main() {
	int ripen = 0;
	scanf("%d %d", &m, &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &map[i][j]);
			if (map[i][j] == 1) {
				ripen++;
				q.push({ i,j });
			}
		}
	}
	if (ripen == n * m) puts("0");
	else {
		solve();
		int max = 0;
		if (!check(max)) puts("-1");
		else printf("%d\n", max - 1);
	}
	return 0;
}