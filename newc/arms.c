#include<stdio.h>

int main()
{
    int n, temp, dig, arm = 0;
    printf("Enter armstrong number: ");
    scanf("%d",&n);
    temp = n;
    while (temp != 0)
    {
        dig = temp % 10;
        arm += dig*dig*dig;
        temp /= 10;
    }
    
    if (arm == n)
    {
        printf("its an arms no.\n");
    }
    else
    {
        printf("its not arms\n");
    }
    
    return 0;
}