#include<stdlib.h>
#include<stdio.h>
#include"dll.h"

int main() {
    int f=1;
    char c;
    List L = NULL;

    while (f) {
        printf("choice? \n1 create\n2 insert\n3 delete\n4 display\n5 search\n6 exit\n");
        scanf(" %c", &c);

        switch (c) {
            case '1':
                createList(&L);
                break;
            
            case '2':
                insert(&L);
                break;

            case '3':
                del(&L);
                break;

            case '4':
                display(L);
                break;
            
            case '5':
                search(L);
                break;

            case '6':
                f = 0;
                printf("exiting...\n");
                break;

            default:
                printf("invalid operation\n");
                break;
        }
    }
    
    return 0;
}