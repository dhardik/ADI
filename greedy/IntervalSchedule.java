import java.util.Scanner;
public class IntervalSchedule {
    public static void scheduleInterval(int start[],int end[],int n) {
        int i=0,j=1;
        System.out.print(i+" ");
        for(j=1;j<n;j++) {
            if(start[j] >= end[i]) {
                System.out.print(j+" ");
                i=j;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        for(int i=0;i<n;i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        scheduleInterval(start,end,n);
    }
}