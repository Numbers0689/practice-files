#include <stdio.h>

#define MAX 300000

int db[MAX + 1], next[MAX + 2];

int getNext(int v) {
    if(next[v] == v)
        return v;
    return next[v] = getNext(next[v]);
}

int main() {
    int n, m, l, r, x;
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= n; i++) {
        next[i] = i;
        db[i] = 0;
    }
    next[n + 1] = n + 1;

    for (int i = 0; i < m; i++) {
        scanf("%d %d %d", &l, &r, &x);
        int cur = getNext(l);
        while (cur <= r) {
            if (cur == x) cur = getNext(cur + 1);
            else {
                db[cur] = x;
                next[cur] = cur + 1;
                cur = getNext(cur);
            }
        }
    }
    for (int i = 1; i <= n; i++) printf("%d ", db[i]);
    return 0;
}
