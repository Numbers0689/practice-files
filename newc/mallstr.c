#include<stdio.h>
#include<stdlib.h>

struct emp
{
    int no, hr;    
};


int main() {

    struct emp* ptr;
    int n;
    printf("enter n: ");
    scanf("%d", &n);

    ptr = (struct emp*)malloc(n * sizeof(struct emp));

    for (int i = 0; i < n; i++)
    {
        printf("enter no, hr: \n");
        scanf("%d %d", &(ptr + i)->no, &(ptr + i)->hr);
    }

    for (int i = 0; i < n; i++)
    {
        printf("values are %d %d. \n", (ptr+i)->no, (ptr+i)->hr);
    }

    return 0;
    
    

}