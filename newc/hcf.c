#include<stdio.h>

int main() 
{
    int a,b,min,hcf=1;
    printf("enter a, b: \n");
    scanf("%d %d", &a, &b);
    min = (a < b) ? a : b;
    for (int i = 1; i < min; i++)
    {
        if (a%i == 0 && b%i == 0)
        {
            hcf=i;
        }        
    }
    printf("%d\n", hcf);
    return 0;
}