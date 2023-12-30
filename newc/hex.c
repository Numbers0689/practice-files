#include<stdio.h>

int main() {
    int a = 423,binary_num = 324;
    printf("dec: %d\n", a);
    printf("hex: %o\n", a);
    int i, bin[32];
    i = 0;
    while (a != 0)
    {
        bin[i] = a %2;
        a /= 2;
        i++;
    }

    for(int j = i; j >=0; j--) {
        printf("%d", bin[j]);
    }
    printf("\n");
    
    return 0;
}