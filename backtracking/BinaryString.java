import java.util.Scanner;

public class BinaryString {
    public static void printBinaryString(int arr[],int n,int index) {
        if(index == (n)) {
            for(int i=0;i<n;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        else {
            arr[index] = 0;
            printBinaryString(arr,n,index+1);
            arr[index] = 1;
            printBinaryString(arr,n,index+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        printBinaryString(arr,n,0);
    }
}