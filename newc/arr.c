#include<stdio.h>

int main()
{
    int arr[100];
    int n, sum = 0;
    printf("Enter size of array: ");
    scanf("%d",&n);
    printf("Enter elements of array: ");
    
    for (int i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }
    
    for (int i = 0; i < n; i++)
    {
        sum += arr[i];
    }

    printf("sum of array is %d\n", sum);
    return 0;    
}