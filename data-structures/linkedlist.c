#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node *next;
} Node;

void print(Node *ll) {
    for (Node *n = ll; n != 0; n=n->next)
        printf("%d->", n->data);
    printf("_\n");
}

void insert(Node **ll, int val) {
    Node *n;
    n = (Node *)malloc(sizeof(Node));
    n->data = val;
    n->next = *ll;
    *ll = n;
}

void free_list(Node *ll) {
    Node *n = ll;
    while (n != 0) {
        Node *tmp = n;
        n = n->next;
        free(tmp);
    }
}

int main() {
    Node *ll = NULL;
    insert(&ll, 1);
    print(ll);
    insert(&ll, 3);
    print(ll);

    free_list(ll);
    return 0;
}
