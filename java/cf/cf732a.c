#include<stdio.h>

int main() {
    int k, r;
    scanf("%d %d", &k, &r);
    int l = k%10;
    for (int i = 1; i < 10; i++) {
        if (((l*i)%10) == r) printf("%d", i);
    }

    return 0;
}