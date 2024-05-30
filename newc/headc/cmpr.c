#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct 
{
    int width;
    int height;
} rect;

int compareRect(const void* a, const void* b) {
    rect* ra = (rect*)a;
    rect* rb = (rect*)b;
    int area1 = (ra->width * ra->height);
    int area2 = (rb->width * rb->height);
    return area1-area2; //desc: area2-area1
}

int compareStr(const void* a, const void* b) {
    char ** sa = (char**)a;
    char ** sb = (char**)b;
    return strcmp(*sa, *sb);
}

int compareScore(const void* scordA, const void* scordB) {
    int a = *(int *)scordA;
    int b = *(int *)scordB;
    return a-b;
}

int compareScoreDesc(const void* scordA, const void* scordB) {
    int a = *(int *)scordA;
    int b = *(int *)scordB;
    return b-a;
}

int main() {
    int scores[] = {1, 3, 234, 12, 4, 76, 23, 89, 99};
    char *names[] = {"names", "amy", "zendaya", "zuha", "katie"};
    qsort(names, 5, sizeof(char*), compareStr);

    for (int i = 0; i < 5; i++) {
        printf("%s ", names[i]);
    }
    printf("\n");
    return 0;
}