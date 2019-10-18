import java.util.Scanner;
public class Knapsack {

    public static int max(int a,int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    public static int knapSack(int capacity,int n,int weigth[],int value[]) {
        if(capacity == 0 || n == 0) {
            return 0;
        }
        else {
            return max(
                knapSack((capacity-weigth[n-1]),n-1,weigth,value)+value[n-1] ,
                knapSack(capacity,n-1,weigth,value)
            );
        }
    }

    public static int getMaxIndex(int n,int arr[]) {
        int max = arr[0];
        int index = 0;
        for(int i=1;i<n;i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        arr[index] = -1;
        return index;
    }

    public static int fractionalKnapSack(int capacity,int n,int weigth[],int value[]) {
        int ratio[] = new int[n];
        for(int i=0;i<n;i++) {
            ratio[i] = (int)(value[i]/weigth[i]);
        }
        int res = 0;
        while(capacity > 0) {
            int index = getMaxIndex(n,ratio);
            if(capacity > weigth[index]) {
                res+=value[index];
                capacity-=weigth[index];
            }
            else {
                res+=(capacity*((int)(value[index]/weigth[index])));
                capacity = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value[] = new int[n];
        int weigth[] = new int[n];
        for(int i=0;i<n;i++) {
            value[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++) {
            weigth[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        System.out.println(KnapSack(capacity,n,weigth,value));
        System.out.println(fractionalKnapSack(capacity,n,weigth,value));
    }
}