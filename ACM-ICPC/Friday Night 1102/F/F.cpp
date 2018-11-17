#include<iostream>
#include<deque>
#include<cstring>

using namespace std;

const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, -1, 0, 1};

struct Block {
    int x, y, l, r;
    Block(int x, int y, int l, int r): 
        x(x), y(y), l(l), r(r) {}
};

int main() {
    int n, m, row, col, liml, limr;
    cin >> n >> m >> row >> col >> liml >> limr;
    char matrix[n][m];
    for (int i = 0; i < n; i ++)
        for (int j = 0; j < m; j ++)
            cin >> matrix[i][j];

    int dist[n][m][2];
    memset(dist, 0x3f, sizeof(dist));

    deque<Block> q;
    q.push_back(Block(-- row, -- col, 0, 0));
    dist[row][col][0] = 0;
    dist[row][col][1] = 0;

    while (!q.empty()) {
        Block cur = q.front();
        q.pop_front();
        for (int i = 0; i < 4; i ++) {
            int x = cur.x + dx[i];
            int y = cur.y + dy[i];
            if (x < 0 || x == n || y < 0 || y == m) continue;
            if (matrix[x][y] == '*') continue;

            int l = cur.l, r = cur.r;
            if (i == 1) l ++;
            if (i == 3) r ++;
            if (l > liml || r > limr) continue;

            if (l < dist[x][y][0]) {
                dist[x][y][0] = l;
                dist[x][y][1] = r;
                if (i % 2) q.push_back(Block(x, y, l, r));
                else q.push_front(Block(x, y, l, r));
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < n; i ++)
        for (int j = 0; j < m; j ++) {
            // cout << i << " " << j << " " << dist[i][j][0] << " " << dist[i][j][1] << endl;
            if (dist[i][j][0] <= liml && dist[i][j][1] <= limr)
                ans ++;
        }
    cout << ans << endl;

    return 0;
}
