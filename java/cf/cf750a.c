#include<stdio.h>

int main() {
    int n, k, t, i;
    scanf("%d %d", &n, &k);
    t = 240 - k;
    for (i = 1; i <= n; i++) {
        t -= 5*i;
        if (t < 0) break;
    }
    printf("%d", i-1);
}