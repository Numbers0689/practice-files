#include<stdio.h>

int main(void)
{
    char name[10];
    printf("Enter a string to print: ");
    scanf("%[^\n]s",name);
    printf("your string is %s\n", name);
}