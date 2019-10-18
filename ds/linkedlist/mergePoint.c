#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    int isVisited;
    struct Node* next;
};

void print(struct Node* head) {
    if(head == NULL) {
        printf("\n");
        return;
    }
    else {
        printf("%d ",head->data);
        print(head->next);
    }
}

int main() {
    int count = 0;
    struct Node* head1 = (struct Node*)malloc(sizeof(struct Node));
    head1->data = 3;
    head1->next = NULL;
    struct Node* ptr = head1;
    ptr->next = (struct Node*)malloc(sizeof(struct Node));
    ptr = ptr->next;
    ptr->data = 6;
    ptr->next = (struct Node*)malloc(sizeof(struct Node));
    ptr = ptr->next;
    ptr->data = 9;
    ptr->next = (struct Node*)malloc(sizeof(struct Node));
    ptr = ptr->next;
    ptr->data = 15;
    ptr->next = (struct Node*)malloc(sizeof(struct Node));
    struct Node* mergePoint = ptr;
    ptr = ptr->next;
    ptr->data = 30;
    ptr->next = NULL;
    struct Node* head2 = (struct Node*)malloc(sizeof(struct Node));
    head2->data = 3;
    head2->next = NULL;
    ptr = head2;
    ptr->next = mergePoint;
    ptr = head1;
    while(ptr != NULL) {
        ptr->isVisited = 1;
        ptr = ptr->next;
    }
    ptr = head2;
    while(ptr != NULL) {
        if(ptr->isVisited == 1) {
            printf("-> %d\n",ptr->data);
            break;
        }
        ptr = ptr->next;
    }
}