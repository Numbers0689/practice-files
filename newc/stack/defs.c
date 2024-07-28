#include<stdlib.h>
#include<stdio.h>
#include"defs.h"

struct node
{
    int val;
    position next;
};

int readVal() {
    int n;
    printf("enter data: ");
    scanf("%d", &n);
    return n;
}

int isEmpty(Stack S) {
    if (S == NULL) {
        return 1;
    } else {
        return 0;
    }
}

position createNode(int val) {
    position newn = (position)malloc(sizeof(struct node));
    newn->val = val;
    newn->next = NULL;
    return newn;
}

void createStack(Stack *S) {
    int n;
    printf("enter no. of nodes: ");
    scanf("%d", &n);

    if (n <= 0) {
        *S = NULL;
        return;
    }

    *S = createNode(readVal());
    position p = *S;

    for (int i = 1; i < n; i++) {
        position newn = createNode(readVal());
        newn->next = p;
        p = newn;
    }

    *S = p;
    display(*S);
}

void pop(Stack *S) {
    position temp = *S;
    if (isEmpty(*S)) {
        printf("cant pop on an empty stack\n");
    } else {
        *S = temp->next;
        free(temp);
    }

    display(*S);
}

void push(Stack *S) {
    position newn = createNode(readVal());
    newn->next = *S;
    *S = newn;
    display(*S);
}

int topElement(Stack S) {
    if (isEmpty(S)) {
        printf("empty Stack\n");
        return -1;
    } else {
        return S->val;
    }
}

void display(Stack S) {
    position p = S;
    printf("Stack: ");

    while (p != NULL) {
        printf("%d ", p->val);
        p = p->next;
    }

    printf("\n");
}