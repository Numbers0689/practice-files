#include<stdio.h>
#include"encrypt.h"

int main() {
    char msg[90];
    while (fgets(msg, 90, stdin))
    {
        encrypt(msg);
        printf("%s", msg);
    }
    printf("\n");
    return 0;
}