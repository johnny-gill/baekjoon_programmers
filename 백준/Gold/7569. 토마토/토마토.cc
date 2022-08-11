#include <cstdio>
#include <queue>
using namespace std;
int m, n, h;
int map[101][101][101];
int dx[] = { 1,-1,0,0,0,0 };
int dy[] = { 0,0,1,-1,0,0 };
int dz[] = { 0,0,0,0,1,-1 };
struct Box {
	int z, x, y;
};
queue<Box> q;
void solve() {
	while (!q.empty()) {
		int z = q.front().z;
		int x = q.front().x;
		int y = q.front().y;
		q.pop();
		for (int i = 0; i < 6; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int nz = z + dz[i];
			if (0 > nx || nx >= n || 0 > ny || ny >= m || 0>nz||nz>=h) continue;
			if (map[nz][nx][ny]) continue;
			q.push({ nz,nx,ny });
			map[nz][nx][ny] = map[z][x][y] + 1;
		}
	}
}

bool check(int &max) {
	for (int k = 0; k < h; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!map[k][i][j]) return false;
				if (max < map[k][i][j])
					max = map[k][i][j];
			}
		}
	}
	return true;
}

int main() {
	int ripen = 0;
	scanf("%d %d %d", &m, &n, &h);
	for (int k = 0; k < h; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				scanf("%d", &map[k][i][j]);
				if (map[k][i][j] == 1) {
					ripen++;
					q.push({ k,i,j });
				}
			}
		}
	}
	if (ripen == h * n * m) puts("0");
	else {
		solve();
		int max = 0;
		if (!check(max)) puts("-1");
		else printf("%d\n", max - 1);
	}
	return 0;
}