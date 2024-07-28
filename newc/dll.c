#include<stdlib.h>
#include<stdio.h>
#include"dll.h"

struct node
{
    int val;
    position next;
    position prev;
};

void createList(List *L) {
    int n;
    *L = NULL;
    printf("enter no. of nodes: ");
    scanf("%d", &n);
    position newn = createNode(readVal());
    position p;
    *L = newn;
    p = *L;

    for (int i = 1; i < n; i++) {
        newn = createNode(readVal());
        newn->prev = p;
        p->next = newn;
        p = newn;
    }
    display(*L);
}

position createNode(int val) {
    position newnode = (position)malloc(sizeof(struct node));
    if (newnode == NULL) {
        printf("memory allocation failed\n");
        exit(1);
    }
    newnode->val = val;
    newnode->next = NULL;
    newnode->prev = NULL;
    return newnode;
}

void insert(List *L) {
    int pos;
    printf("enter pos: ");
    scanf("%d", &pos);
    position p, newn = createNode(readVal());
    p = *L;
    
    if (pos > 0) {
        for(int i = 1; i < pos && p->next != NULL; i++) {
            p = p->next;
        }
    }
    
    if (p->prev == NULL) {
        newn->next = p;
        p->prev = newn;
        *L = newn;   
        printf("dfs");
    } else if (isLast(p)) {
        p->next = newn;
        newn->prev = p;
    } else {
        newn->next = p->next;
        p->next = newn;
        newn->prev = p;
        newn->next->prev = newn;
    }

    printf("inserted successdully\n");
    display(*L);
    return;
}

int isLast(position p) {
    if (p->next == NULL) {
        return 1;
    } else {
        return 0;
    }
}

void del(List *L) {
    int val = readVal();
    position p = *L;

    while (p != NULL && p->val != val) {
        p = p->next;
    }

    if (p == NULL) {
        printf("data not found\n");
        return;
    }

    if (p->prev == NULL) {
        *L = p->next;
    } else if (p->next == NULL) {
        p->prev->next = NULL;
    } else {
        p->prev->next = p->next;
        p->next->prev = p->prev;
    }

    free(p);
    printf("data deleted\n");
    display(*L);
    return;
}

int readVal() {
    int n;
    printf("enter data: ");
    scanf("%d", &n);
    return n;
}

void search(List L) {
    int val = readVal();
    position p = L;

    while (p != NULL) {
        if (p->val == val) {
            printf("data found!\n");
            return;
        }
        p = p->next;
    }

    printf("data not found!\n");
    return;
}

void display(List L) {
    position p = L;
    printf("List: ");
    while(p != NULL) {
        printf("%d ", p->val);
        p = p->next;
    }
    printf("\n");
}