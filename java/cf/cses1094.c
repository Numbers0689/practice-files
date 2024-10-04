#include<stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    unsigned long long a[n];
    unsigned long long c = 0;
    for (int i = 0; i < n; i++) {
        scanf("%llu", &a[i]);
    }
    for (int i = 0; i < n-1; i++) {
        if (a[i] > a[i+1]) {
            c += a[i] - a[i+1];
            a[i+1] = a[i];
        }
    }
    printf("%llu", c);
}