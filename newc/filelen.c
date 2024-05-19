#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

int main() {
    char c;
    printf("eneter char: ");
    scanf("%c", &c);
    if (isalpha(c)) {
        printf("true\n");
    }
    return 0;
}