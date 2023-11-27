#include<stdio.h>

void skip(char *);

int main()
{
    char *msgHere = "don't call me";
    puts(msgHere);
    skip(msgHere);
    return 0;
}

void skip(char *msg)
{
    puts(msg + 6);
}