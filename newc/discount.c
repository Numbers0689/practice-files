#include<stdio.h>

int main()
{
    int price;
    printf("Enter the price: ");
    scanf("%d",&price);

    if (price > 1000)
    {
        price -= 200;
        printf("Discounted price is %d\n", price);
    }
    else
    {
        printf("your not eligible for discount.\n");
    }

    return 0;
}