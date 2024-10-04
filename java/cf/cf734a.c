#include<stdio.h>

int main() {
    int n, a = 0, d = 0;
    scanf("%d", &n);
    char s[n+1];
    for (int i = 0; i <= n; i++) {
        scanf("%c", &s[i]);
        if (s[i] == 'A') a++;
        else if (s[i] == 'D') d++;
    }
    if (a > d) printf("Anton");
    else if (d > a) printf("Danik");
    else printf("Friendship");
    return 0;
}