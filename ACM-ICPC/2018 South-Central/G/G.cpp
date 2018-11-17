#include <iostream>
#include <cstdio>

int main() {
    int t; scanf("%d", &t);
    int tb[15];
    tb[1]=1;
    for (int i=2; i<=10; i++) tb[i]=(tb[i-1]*i)%10;
    while (t--) {
        int n; scanf("%d", &n);
        printf("%d\n", tb[n]);
    }
}
