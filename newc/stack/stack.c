#include<stdio.h>
#include<stdlib.h>
#include"defs.h"

int main() {
    int f = 1;
    char c;
    Stack S;

    while (f) {
        printf("enter choice:\n1 create\n2 push\n3 pop\n4 top\n5 display\n6 exit\n");
        scanf(" %c", &c);

        switch (c) {
            case '1':
                createStack(&S);
                break;
            
            case '2':
                push(&S);
                break;

            case '3':
                pop(&S);
                break;
            
            case '4':
                printf("Top: %d \n", topElement(S));
                break;

            case '5':
                display(S);
                break;

            case '6':
                printf("exiting...");
                f = 0;
                break;

            default:
                printf("invalid operation");
                break;
        }
    }
    
    return 0;
}