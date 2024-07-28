typedef struct node *position;
typedef position List;

int readVal();
position createNode(int val);
void createList(List* L);
void insert(List *L);
void del(List *L);
void search(List L);
void display(List L);
int isLast(position p);