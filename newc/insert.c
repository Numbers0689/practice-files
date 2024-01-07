#include<stdio.h>

int main() {
    int arr[] = {34, 5, 2, 46, 90};
    int n = sizeof(arr) / sizeof(arr[0]);
    int temp, j;

    for (int i = 0; i < n; i++)
    {
        j = i;

        while (j>0 && arr[j-1] > arr[j]) {
            temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j-1] = temp;
            j--;
        }
    }

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }

    printf("\n");
    return 0;
}