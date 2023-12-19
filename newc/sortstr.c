#include<stdio.h>
#include<stdlib.h>
#include<string.h>

static int compare(const void* a, const void* b) {
    return strcmp(*(const char**) a, *(const char**) b);
}

void sort(const char* arr[], int n) {
    qsort(arr, n, sizeof(const char*), compare);
}

int main() 
{
    const char* strings[] = {"reallythatsbad", "woahhh", "tantrum", "wonder", "ending"};
    int n = sizeof(strings) / sizeof(strings[0]);
    sort(strings, n);
    for (int i = 0; i < n; i++)
    {
        printf("%d: %s\n", i, (strings[i]));
    }
    return 0;
}