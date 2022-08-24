#include <cstdio>
#include <cstring>
#include <vector>
using namespace std;
int map[8][8];
bool check[8][8];
int n, m, ans, unsafe_zone;
vector<pair<int, int>> virus;
int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };

int dfs(int x, int y) {
	int res = 1;
	check[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
		if (check[nx][ny] || map[nx][ny]) continue;
		res += dfs(nx, ny);
	}
	return res;
}

void solve(int cnt, int x, int y) {
	if (cnt == 3) {
		int virus_cnt = 0;
		for (auto&p : virus)	virus_cnt += dfs(p.first, p.second);
		int safe_zone = (n*m) - virus_cnt - unsafe_zone - 3;
		if (ans < safe_zone)	ans = safe_zone;
		memset(check, false, sizeof(check));
		return;
	}

	for (int i = x; i < n; i++) {
		int k = i == x ? y : 0;
		for (int j = k; j < m; j++) {
			if (map[i][j] == 0) {
				map[i][j] = 1;
				solve(cnt + 1, i, j + 1);
				map[i][j] = 0;
			}
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &map[i][j]);
			if (map[i][j] == 2) virus.push_back({ i,j });
			else if (map[i][j] == 1) unsafe_zone++;
		}
	}
	solve(0, 0, 0);
	printf("%d\n", ans);
}