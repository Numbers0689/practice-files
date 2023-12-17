#include<stdio.h>

int bisectionalSearch(int array[], int low, int high, int x);

int main() 
{
    int x, array[120], size, result;
    printf("enter size of array (<20): ");
    scanf("%d", &size);

    printf("enter elements: \n");
    for (int i = 0; i < size; i++)
    {
        scanf("%d", &array[i]);
    }
    
    printf("enter a num to search: ");
    scanf("%d", &x);

    result = bisectionalSearch(array, 0, size - 1, x);
    if (result == -1)
    {
        printf("Element not found.\n");
    }
    else
    {
        printf("element %d found at index %d\n", x, result);
    }
    
    return 0;
}

int bisectionalSearch(int array[], int low, int high, int x)
{
    if (low <= high)
    {
        int mid = (low + high) / 2;

        if (array[mid] > x)
        {
            return bisectionalSearch(array, low, mid - 1, x);
        }
        else if (array[mid] < x)
        {
            return bisectionalSearch(array, mid + 1, high, x);
        }
        else
        {
            return mid;
        }        
    }

    return -1;
}