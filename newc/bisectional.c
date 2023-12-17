#include<stdio.h>

int main() 
{
    int n, array[120], size;
    printf("enter size of array (<20): ");
    scanf("%d", &size);

    printf("enter elements: \n");
    for (int i = 0; i < size; i++)
    {
        scanf("%d", (array[0]+i));
    }
    
    printf("enter a num to search: ");
    scanf("%d", &n);

    return 0;
}

int bisectionalSearch(int array[], int n)
{
     
}