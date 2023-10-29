#include<stdio.h>

int main()
{
    int n;
    printf("Enter a num to get mult table of first 10 int: ");
    scanf("%d",&n);

    for (int i = 1; i < 11; i++)
    {
        printf("%d * %d = %d\n", i, n, i*n);
    }

    return 0;    
}