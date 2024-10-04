#include<stdio.h>

int main() {
    int n, h, o = 0;
    scanf("%d %d", &n, &h);
    int a[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
        if (a[i] > h) o += 2;
        else o++;
    }
    printf("%d", o);
}