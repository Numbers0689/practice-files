#include<stdio.h>
#include<string.h>

void myadd(void);

int main(void)
{
    myadd();
}

void myadd(void)
{
    int a = 5;
    int b = 8;
    printf("%d\n", (a+b));
}