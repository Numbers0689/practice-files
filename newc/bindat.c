#include<stdio.h>

struct employee
{
    double id;
    double salary;
};


int main()
{
    FILE *fptr;
    struct employee epm;
    epm.id = 560;
    epm.salary = 600;
    fptr = fopen("employee.dat", "wb");

    if (fptr == NULL)
    {
        printf("couldnt open file\n");
    }
    else
    {
        fwrite(&epm, sizeof(epm), 1, fptr);
        fclose(fptr);
    }

    return 0;
    
}