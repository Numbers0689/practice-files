#include<stdio.h>
#include<ctype.h>

void copyt(char *source, char *add) {
    while (*source!='\0') {
        source++;
    }
    while (*add)
    {
        if (isalpha(*add) || *add == ' ')
        {
            *source = *add;
            source++;
        }
        add++;        
    }
    *source = '\0';
}

int main() {
    char str[]="wrwerrwr";
    char str1[]="424 ffgregreg 24 $$ ere";
    copyt(str, str1);
    printf("%s\n", str);
    return 0;
}