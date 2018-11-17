#include <iostream>
#include <cstring>
#include <cstdio>
using namespace std;

int coord[66][2];
int sum_x[8], sum_y[8];
int board[8][8];
int _next[65];
int P, K, cnt;
bool finished = false;
int ans[20][8][8];

int step1[8][2] = {{-1, -2},
				   {-2, -1},
				   {-2, 1},
				   {-1, 2},
				   {1, 2},
				   {2, 1},
				   {2, -1},
				   {1, -2}};


inline bool exist(int p) {
	return (coord[p][0] != -1) && (coord[p][1] != -1);
}

inline bool valid(int p, int x, int y) {
	if (x < 0 || x > 7 || y < 0 || y > 7)
		return false;
	if (board[x][y] != -1)
		return false;
	if ((sum_x[x] + p > 260) || (sum_y[y] + p > 260))
		return false;
	return true;
}

inline void finish() {
	// finished = true;
	for (int i = 0; i < 8; i++)
		for (int j = 0; j < 8; j++)
			ans[cnt][i][j] = board[i][j];
	for (int i = 0; i < 8; i++)
		for (int j = 0; j < 8; j++) printf("%d%c", board[i][j], j==7?'\n':' ');
	cnt++;
}

inline void reg(int p, int x, int y) {
	board[x][y] = p;
	sum_x[x] += p;
	sum_y[y] += p;
	coord[p][0] = x;
	coord[p][1] = y;
	//cout << p << ' ' << x << ' ' << y << endl;
}

inline void unreg(int p, int x, int y) {
	board[x][y] = -1;
	sum_x[x] -= p;
	sum_y[y] -= p;
	coord[p][0] = -1;
	coord[p][1] = -1;
}

void dfs(int p) {
	cout << p << endl;
	if (p > 64) {
		finish();
		return;				
	}
	if (exist(p)) {
		dfs(_next[p]);
		return;
	}
			//if (p == 64)
				//cout << "here" << endl;
	
	if (exist(p-1)) {
		for (int i = 0; i < 8; i++) {
			int x = coord[p-1][0] + step1[i][0];
			int y = coord[p-1][1] + step1[i][1];
			if (!valid(p, x, y))
				continue;
			if (exist(p+1)) {
				int flag = false;
				for (int j = 0; j < 8; j++) {
					int px = coord[p+1][0] + step1[j][0];
					int py = coord[p+1][1] + step1[j][1];
					if (px == x && py == y) {
						flag = true;
						break;
					}
				}			
				if (!flag)
					continue;
			}
			reg(p, x, y);
			dfs(_next[p]);
			unreg(p, x, y);
			if (finished)
				return;
		}
	} else {
		if (exist(p+1)) {
			for (int j = 0; j < 8; j++) {
				int px = coord[p+1][0] + step1[j][0];
				int py = coord[p+1][1] + step1[j][1];
				if (valid(p, px, py)) {
					reg(p, px, py);
					dfs(_next[p]);
					unreg(p, px, py);
					if (finished)
						return;
				}
			}
		} else {
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
					if (valid(p, i, j)) {
						reg(p, i, j);
						dfs(_next[p]);
						unreg(p, i, j);
						if (finished)
							return;
					}
		}
	}				
}

void init() {
	finished = false;
	for (int i = 0; i <= 65; i++) {
		coord[i][0] = -1;
		coord[i][1] = -1;
	}
	memset(sum_x, 0, sizeof(sum_x));
	memset(sum_y, 0, sizeof(sum_y));
	memset(_next, 0, sizeof(_next));
	memset(ans, 0, sizeof(ans));
	memset(board, -1, sizeof(board));
	memset(coord, -1, sizeof(coord));
	/*for (int i = 0; i < 8; i++)
		for (int j = 0; j < 8; j++) {
			cin >> board[i][j];
			if (board[i][j] != -1) {
				coord[board[i][j]][0] = i;
				coord[board[i][j]][1] = j;
				sum_x[i] += board[i][j];
				sum_y[j] += board[i][j];
			};
		}*/
	int p = 65;
	for (int i = 64; i >= 1; i--) {
		if (exist(i)) {
			_next[i] = p;
		} else {
			_next[i] = p;
			p = i;
		}
	}
	//for (int i = 0; i <= 64; i++)
		//cout << _next[i] << ' ';
//	cout << endl;
}


int main() {
	P = 1;
	while (P--) {
		init();
		dfs(1);
	}
	/*if (finished) {
		for (int i = 0; i < 8; i++) {
			cout << ans[i][0];
			for (int j = 1; j < 8; j++)
				cout << ' ' << ans[i][j];
			cout << endl;
		}
	} else
		cout << -1 << endl;
	for (int k=0; k<cnt; k++) {
		cout << endl;
		for (int i = 0; i < 8; i++) {
			cout << ans[k][i][0];
			for (int j = 1; j < 8; j++)
				cout << ' ' << ans[k][i][j];
			cout << endl;
		}
	}*/
	return 0;
}
