#include<stdio.h>
int max(int arr[100], int n);
int min(int arr[100], int n);

int main()
{
    int n, arr[100];
    printf("Enter size of array: ");
    scanf("%d",&n);
    printf("Enter elements of array: ");
    for (int i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }

    printf("max is %d and min is %d\n", max(arr, n), min(arr, n));    
    return 0;
}

int max(int arr[100], int n)
{
    int big = arr[0];
    for (int i = 0; i < n; i++)
    {
        if (big < arr[i])
        {
            big = arr[i];
        }
    }
    return big; 
}


int min(int arr[100], int n)
{
    int small = arr[0];
    for (int i = 0; i < n; i++)
    {
        if (small > arr[i])
        {
            small = arr[i];
        }
    }
    return small;
}