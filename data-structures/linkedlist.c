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

Node *insert(Node *ll, int val) {
    Node *n;
    n = (Node *)malloc(sizeof(Node));
    n->data = val;
    n->next = ll;
    ll = n;
    return ll;
}

int main() {
    Node *ll;
    ll = (Node *)malloc(sizeof(Node));
    ll->data = 1;
    ll->next = NULL;
    print(ll);
    ll = insert(ll, 3);
    print(ll);

    Node *n = ll;
    while (n != 0) {
        Node *tmp = n;
        n = n->next;
        free(tmp);
    }
    return 0;
}
