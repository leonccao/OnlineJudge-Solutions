#include <iostream>
#include <cstdio>

const int maxn=1e5+5;
int pos[maxn];

int main() {
    int n, q; scanf("%d%d", &n, &q);
    for (int i=1; i<=n; i++) scanf("%d", pos+i);
    int op, a, b;
    while (q--) {
        scanf("%d%d%d", &op, &a, &b);
        if (op==1) pos[a]=b;
        else {
            int d=pos[b]-pos[a];
            if (d<0) d=-d;
            printf("%d\n", d);
        }
    }
}
