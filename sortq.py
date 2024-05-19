#include<stdio.h>

void swap(int *p, int *s) {
    int temp = *p;
    *p = *s;
    *s = temp;
}

int part(int *arr, int low, int high) {
    int p = arr[high];
    int i = low-1;
    
    for (int j = low; j <= high; j++) {
        if (arr[j] < p) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i+1], arr[high]);
    return i+1;
}

void quick(int *arr, int low, int high) {
    if (arr[low] < arr[high]) {
        int p = part(arr, low, high);
        quick(arr, low, p-1);
        quick(arr, p+1, high);
    }
}
int arrayPairSum(int* nums, int n) {
    quick(nums, 0, n);
    return nums;
}

int main() {
    int nums[] = [1, 4, 5, 2, 7, 3, 1];
    quick(&nums, 0, 6);
    printf("%d\n", nums);
    return 0;
}
