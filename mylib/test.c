// gonna be adding everthing to make my library here in the folder, this ll be the where im gon test them out

 #include <stdio.h>

 int main(int argc, char* argv[]) 
 {
    char string[20] = "lol really?";
    int count = 0;
    for (int i = 0; string[i] != '\0'; i++)
    {
        count++;   
    }

    printf("length: %d", count);
    return 0;
 }