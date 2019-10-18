import java.util.Scanner;
import java.util.Arrays; 

public class Platform {
    public static int minPlatform(int arr[],int drr[],int n) {
        Arrays.sort(arr);
        Arrays.sort(drr);
        int count=1,res=1,i=1,j=0;
        while(i<n && j<n) {
            if(arr[i] <= drr[j]) {
                count++;
                i++;
                if(count>res) {
                    res = count;
                }
            }
            else {
                count--;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ari[] = new int[n];
        int dep[] = new int[n];
        for(int i=0;i<n;i++) {
            ari[i] = sc.nextInt();
            dep[i] = sc.nextInt();
        }
        System.out.println(minPlatform(ari,dep,n));
    }
}