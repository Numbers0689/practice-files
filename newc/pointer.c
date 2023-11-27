#include<stdio.h>

int main()
{
    int *add, s;
    s = 123;
    add = &s;

    printf("\n%d\n", s);
    printf("%i\n", *add);
    printf("%p",&s);

    return 0;
}