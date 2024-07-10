#include <stdio.h>
#include <stdlib.h>

void two(int *arr, int n);

int main() {
	int t, n, *arr;
	scanf("%d", &t);
	for (int j=0; j<t; j++) {
        scanf("%d", &n);
        arr = (int *)malloc(n*sizeof(int));
        for (int i = 0; i < n; i++) {
            scanf("%d", &arr[i]);
        }
        two(arr, n);
        for (int i = 0; i < n; i++) {
            printf("%d ", arr[i]);
        }
        free(arr);
    }
	return 0;
}

void two(int *arr, int n) {
    int next=1, curr=0,tn;
    while(next<n) {
		tn = arr[next];
		arr[next] = (arr[curr] > arr[next]) ? arr[curr] : arr[next];
		arr[next] = (arr[next]%tn == 0) ? arr[next] : arr[next] + (tn - (arr[next]%tn));
		curr++;
		next++;
	}
}