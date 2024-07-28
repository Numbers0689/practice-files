typedef struct node *position;
typedef position Stack;

void createStack(Stack *S);
position createNode(int val);
int readVal();
int isEmpty(Stack S);
void push(Stack *S);
void pop(Stack *S);
int topElement(Stack S);
void display(Stack S);