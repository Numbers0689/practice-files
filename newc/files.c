#include <stdio.h>

int main () {
    FILE *myFile;
    myFile = fopen("file.txt", "w");
    fprintf(myFile, "NA NA NA NA \n");
    fclose(myFile);
    return 0;
}