#include <stdio.h>

int main()
{
    int arr[] = {1,2,3,4,5};
    int *p;
    p = &arr[0];
    printf("contents of arr: \n");
    for(int i = 0; i < 5; i++){
        printf("%d\n", *(p+i));
    }

    return 0;
}