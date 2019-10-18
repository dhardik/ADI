import java.util.Scanner;
public class JobSequence {
    private class Job {
        int name ;
        int deadline;
        int value;
    }

    public static void printSeq(Job arr[],int size) {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size-i-1;j++) {
                if(arr[j].value < arr[i].value) {
                    Job temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static void printJobs(Job arr[],int n) {
        for(int i=0;i<n;i++) {
            System.out.println(arr[i].name+" "+arr[i].value+" "+arr[i].deadline);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size ;
        size = sc.nextInt();
        Job arr[] = new Job[size];
        for(int i=0;i<size;i++) {
            arr[i].name = sc.nextInt();
            arr[i].deadline = sc.nextInt();
            arr[i].value = sc.nextInt();
        }
        printJobs(arr,size);
        printSeq(arr,size);
        printJobs(arr,size);
    }
}