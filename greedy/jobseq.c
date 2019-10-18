#include <stdio.h>

struct Job {
    int name;
    int deadline;
    int value;
};

int min(int a,int b) {
    if(a<b) {
        return a;
    }
    return b;
}

void printJobSeq(struct Job* arr,int size) {
    int result[size];
    int slot[size];
    for(int i=0;i<size;i++) {
        slot[i] = 0;
    }
    for(int i=0;i<size;i++) {
        for(int j=min(size,arr[i].deadline);j>=0;j--) {
            if(slot[j] == 0) {
                result[j] = i;
                slot[j] = 1;
                break;
            }
        }
    }
    for(int i=0;i<size;i++) {
        if(slot[i] == 1) {
            printf("%d ",arr[result[i]].name);
        }
    }
}

int main() {
    int size;
    scanf("%d",&size);
    struct Job arr[size];
    for(int i=0;i<size;i++) {
        scanf("%d%d%d",&arr[i].name,&arr[i].deadline,&arr[i].value);
    }
    for(int i=0;i<size-1;i++) {
        for(int j=0;j<size-i-1;j++) {
            if(arr[i].value > arr[j].value) {
                struct Job temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    printJobSeq(arr,size);
    return 0;
}