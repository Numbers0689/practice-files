#include<stdio.h>

int main() {
    int n;
    printf("enter n: ");
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
    {
        if (i!=n)
        {
            for (int j = 1; j<=i; j++)
            {
                if (j>1 && j<i)
                {
                    printf("0 ");
                }
                else
                {
                    printf("1 ");
                }
            }
        }
        else {
            for (int j = 1; j<=i; j++)
            {
                printf("1 ");
            }
        }
        printf("\n");
    }
    return 0;
}