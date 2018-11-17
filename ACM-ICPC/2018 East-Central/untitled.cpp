#include <bits/stdc++.h>

using namespace std;

const int maxn=250+5;
int g[maxn][maxn];
bool vis[maxn][maxn][4];
int mv[4]={0,0,-2,2};
int mvxx[4][2]={{0,0},{0,0}, {-1, -2},{1,2}};
pair<int,int> nxt[maxn][maxn];
int tx, ty;
int m, n;
bool ok=false;

inline bool in(int x, int y) {return x>=0&&x<m&&y>=0&&y<n;}
void dfs(int x, int y) {
	// printf("%d %d\n", x, y);
	if (x==tx&&y==ty) ok=true;
	if (ok) return;
	for (int i=0; i<4; i++) if (!vis[x][y][i]) {
		int xx=x+mv[i], yy=y+mv[3-i];
		if (!in(xx, yy)) {
			vis[x][y][i]=true; continue;
		}
		bool check=false;
		vector<int> v;
		for (int j=0; j<2; j++) v.push_back(g[x+mvxx[i][j]][y+mvxx[3-i][j]]);
		if (v[0]==v[1]&&v[0]!=-2) {
			vis[x][y][i]=true;
			swap(g[xx][yy], g[x][y]);
			// printf("%d %d %d %d\n", x, y, xx, yy);
			dfs(xx, yy);
			if (ok) nxt[x][y]={xx, yy};
			if (ok) return;
			swap(g[xx][yy], g[x][y]);
		}
	}
}

int main() {
 	// freopen("untitled.in", "r", stdin);
 	freopen("untitled.out", "w", stdout);
	scanf("%d%d", &m, &n);
	int sx, sy;
	for (int i=0; i<m; i++) for (int j=0; j<n; j++) {
		scanf("%d", g[i]+j);
		if (g[i][j]==-1) sx=i, sy=j;
	}
	scanf("%d%d", &tx, &ty); tx--; ty--;
	// fa[sx][sy]={-1,-1};
	dfs(sx, sy);
	vector<int> ans;
	if (ok) {
		while (1) {
			if (g[sx][sy]!=-1) ans.push_back(g[sx][sy]);
			if (sx==tx&&sy==ty) break;
			int aa=sx, bb=sy;
			sx=nxt[aa][bb].first, sy=nxt[aa][bb].second;
		}
		for (int i=0; i<ans.size(); i++) printf("%d%c", ans[i], i==ans.size()-1?'\n':' ');
	}
	else puts("impossible");
	
}
