#include<stdio.h>
#include<string.h>

int main(void)
{
    char puts[100];
    char gets[100];
    char fits[100];
    printf("Enter a string: ");
    scanf("%[^\n]s", puts);

    printf("Enter string 2: ");
    scanf(" %[^\n]s", gets);

    printf("Enter string 3: ");
    scanf("  %[^\n]s", fits);
    strcat(puts, gets);
    printf("%s\n", puts);
    printf("%s\n", gets);
    printf("%s\n", fits);
}