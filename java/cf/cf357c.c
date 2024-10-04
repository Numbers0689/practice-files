#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main() {
    int n, m;
    int f[3];
    scanf("%d %d", &n, &m);
    int *s = malloc((n+1)*sizeof(int));
    memset(s, 0, (n+1)*sizeof(int));
    for (int i = 0; i < m; i++) {
        scanf("%d %d %d", &f[0], &f[1], &f[2]);
        for (int j = f[0]; j <= f[1]; j++) {
            if (j == f[2]) continue;
            if (s[j] == 0) s[j] = f[2];
        }
    }
    for (int i = 1; i <= n; i++) {
        if (s[i] != 0) printf("%d ", s[i]);
        else printf("0 ");
    }
    free(s);
    return 0;
}