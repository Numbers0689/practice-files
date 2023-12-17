#include <stdio.h>

int fibonacci(int n) {
    if (n <= 1) return n;
    else return fibonacci(n - 1) + fibonacci(n - 2);
}

int main()
{
    int n;
    printf("Enter a num to find fibonacci: ");
    scanf("%d", &n);

    printf("fibonacci of %d: %d\n", n, fibonacci(n));
    return 0;
}