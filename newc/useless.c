#include<stdio.h>
#include<stdlib.h>

unsigned long long multiplyNumbers(int n) {
    if (n>=1)
        return n*multiplyNumbers(n-1);
    else
        return 1;
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("usage: \n");
        return 0;
    }
    int num = atoi(argv[1]);
    printf("%d \n", num);
    unsigned long long fact = multiplyNumbers(num);
    printf("fact: %lld\n", fact);
    return 0;
}