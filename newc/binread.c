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
    fptr = fopen("employee.bin", "rb");

    if (fptr == NULL)
    {
        printf("couldnt open file\n");
    }
    else
    {
        fread(&epm, sizeof(epm), 1, fptr);
        printf("employee id: %.lf\n", epm.id);
        printf("employee daily salary: %.lf\n", epm.salary);
        fclose(fptr);
    }

    return 0;
    
}