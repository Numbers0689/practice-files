#include<stdio.h>

int main() {
    int arr[] = {43, 6, 5, 2, 86, 34, 12};
    int n = sizeof(arr)/sizeof(arr[0]);
    int temp;

    for (int i = 0; i < n; i++)
    {
        for (int j = i+1; j < n; j++)
        {
            if(arr[i] > arr[j]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    for (int i = 0; i < n; i++)
    {
        printf("%d, ", arr[i]);
    }
    printf("\n");
    return 0;
}