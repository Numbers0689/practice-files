all: stack

stack: stack.o defs.o
	gcc stack.o defs.o -o stack

stack.o: stack.c
	gcc -c stack.c -o stack.o

defs.o: defs.c
	gcc -c defs.c -o defs.o