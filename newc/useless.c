#include<stdio.h>

int len(char str[]) {
    int count=0;
    while (*str != '\0')
    {
        count++;
        str++;
    }

    return count;
}

int main() {
    int a = 3+6/2+6*2;
    char str[] = "123456789";
    int *arr[] = {&a};
    printf("%d\n", *arr[0]);

    int length = len(str);
    printf("len: %d\n", length);
    printf("%c\n", *str);

    return 0;
}