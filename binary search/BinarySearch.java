import java.util.Scanner;
import java.util.Arrays;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        // Arrays.sort(arr);
        // printArray(arr,size);
        // System.out.println(binarySearchRecursive(arr,0,size-1,key));
        // System.out.println(binarySearchLoop(arr,0,size-1,key));
        // System.out.println(firstOccurance(arr,0,size-1,key));
        // System.out.println(findMissing(arr,size));
        System.out.print(rotationCount(arr,0,size-1,size));
    }

    public static void printArray(int arr[],int n) {
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int binarySearchRecursive(int arr[],int left,int right,int key) {
        if(left <= right) {
            int mid = left+(right-left)/2;
            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key) {
                return binarySearchRecursive(arr,left,mid-1,key);
            }
            else {
                return binarySearchRecursive(arr,mid+1,right,key);
            }
        }
        return -1;
    }

    public static int binarySearchLoop(int arr[],int left,int right,int key) {
        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void pairsWithKSum(int arr[],int size,int k) {
        int left = 0;
        int right = size-1;
        while(left < right) {
            int sum = arr[left]+arr[right];
            if(sum < k) {
                left++;
            }
            else if(sum > k) {
                right--;
            }
            else {
                System.out.println(arr[left]+" , "+arr[right]);
                left++;
            }
        }
    }

    public static int firstOccurance(int arr[],int left,int right,int key) {
        if(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] == key) {
                for(int i=mid;i>=0;i--) {
                    if(arr[i]!=key) {
                        return i+1;
                    }
                }
                return 0;
                // return mid;
            }
            else if(arr[mid] > key) {
                return firstOccurance(arr,left,mid-1,key);
            }
            else if(arr[mid] < key) {
                return firstOccurance(arr,mid+1,right,key);
            }
        }
        return -1;
    }

    public static int findMissing(int arr[],int n) {
        int left = 0;
        int right = n-1;
        int mid = 0;
        while((right-left)>1) {
            mid = (left+right)/2;
            if((arr[mid]-mid) == 1) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return (arr[mid]-1);
    }

    // public static int findRotated(int arr[],int n,int key) {
    //     int pivot = 0;
    //     for(int i=0;i<(n-1);i++) {
    //         if(arr[i]<arr[i+1]) {
    //             pivot = i;
    //             break;
    //         }
    //     }
    //     if(arr[pivot] == key) {
    //         return pivot;
    //     }
    //     else if(key >= arr[0]) {
    //         // search from 0 to pivot
    //         return binarySearchRecursive(arr,0,pivot-1,key);
    //     }
    //     else {
    //         // search from pivot+1 to n-1;
    //         return binarySearchRecursive(arr,pivot+1,n-1,key);
    //     }
    // }

    public static int rotationCount(int arr[],int left,int right,int n) {
        if((arr[left] <= arr[right]) && (left == 0 && right == (n-1))) {
            return 0;
        }
        if(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid]<= arr[mid+1] && arr[mid]<=arr[mid-1]) {
                return mid;
            }
            else if(arr[mid] <= arr[right]) {
                // search in left half
                return rotationCount(arr,left,mid-1,n);
            }
            else {
                // search in right half
                return rotationCount(arr,mid+1,right,n);
            }
        }
        return 0;
    }
}