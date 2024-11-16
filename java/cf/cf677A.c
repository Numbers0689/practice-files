#include<stdio.h>

long main() {
    long n, h, o = 0;
    scanf("%d %d", &n, &h);
    long a[n];
    for (long i = 0; i < n; i++) {
        scanf("%d", &a[i]);
        if (a[i] > h) o += 2;
        else o++;
    }
    prlongf("%d", o);
}