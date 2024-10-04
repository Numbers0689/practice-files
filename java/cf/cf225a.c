#include<stdio.h>

int main() {
    int n, x, a, b, p = 1;
    scanf("%d %d", &n, &x);
    while (n--) {
        scanf("%d %d", &a, &b);
        if (a == x || b == x || x == 7 - a || x == 7 - b) {
            printf("NO");
            return 0;
        }
    }
    printf("YES");
    return 0;
}