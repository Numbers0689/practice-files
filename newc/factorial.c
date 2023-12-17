#include<stdio.h>

int factorial(int n);

int main()
{
    int num;
    printf("Enter a num to find factorial: ");
    scanf("%d", &num);
    printf("factorial of %d: %d\n", num, factorial(num));
    return 0;
}

int factorial(int n) {
    if (n <= 1) return n;
    else return n * factorial(n - 1);
}