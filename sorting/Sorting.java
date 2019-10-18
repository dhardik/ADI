import java.util.Scanner;
public class Sorting {

    private int arr[];
    private int size = 0;

    public Sorting(int size) {
        this.arr = new int[size];
        this.size = size;
    }

    public void insertAt(int elem,int index) {
        this.arr[index] = elem;
    }

    public void printArray() {
        for(int i=0;i<this.size;i++) {
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }

    public int elementAt(int index) {
        return this.arr[index];
    }

    public void merge(int left,int mid,int right) {
        int size1 = mid-left+1;
        int size2 = right-mid;
        int arr1[] = new int[size1];
        int arr2[] = new int[size2];
        for(int i=0;i<size1;i++) {
            arr1[i] = this.arr[left+i];
        }
        for(int i=0;i<size2;i++) {
            arr2[i] = this.arr[mid+1+i];
        }
        int i=0,j=0,k=left;
        while(i<size1 && j<size2) {
            if(arr1[i] <= arr2[j]) {
                this.arr[k++] = arr1[i++];
            }
            else {
                this.arr[k++] = arr2[j++];
            }
        }
        while(i < size1) {
            this.arr[k++] = arr1[i++];
        }
        while(j < size2) {
            this.arr[k++] = arr2[j++];
        }
    }

    public void mergeSortRecursive(int left,int right) {
        if(left < right) {
            int mid = (left+right)/2;
            this.mergeSortRecursive(left,mid);
            this.mergeSortRecursive(mid+1,right);
            this.merge(left,mid,right);
        }
    }

    // public void mergeSortIterative() {

    // }

    private static int partition(int arr[],int l,int r)
	{
		int pivot=arr[r],i=l,j=l;
		while(i<=r)
		{
			if(arr[i]<pivot)
			{
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				++i;
				++j;
			}
			else
				++i;
		}
		int temp=arr[j];
		arr[j]=arr[r];
		arr[r]=temp;
		return j;
	}

    private static void setPivot(int arr[],int l,int r)
	{
		int mid=(l+r)/2;
		int x=arr[l],y=arr[mid],z=arr[r],c=0,flag=0;
		if((x<y&&x<z)||(z<y&&y<x))
		{
			arr[mid]=z;
			arr[r]=y;
		}  
   		else if((y<x&&x<z)||(z<x&&x<y)) 
       	{
       		arr[l]=z;
			arr[r]=x;
       	}
	}

    private static void qsort(int arr[],int l,int r)
	{
		if(l<r)
		{
			setPivot(arr,l,r);
			int p=partition(arr,l,r);
			qsort(arr,l,p-1);
			qsort(arr,p+1,r);
		}
	}

    public static void QuickSort(int arr[])
	{
		qsort(arr,0,arr.length-1);
	}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorting s = new Sorting(sc.nextInt());
        for(int i=0;i<s.size;i++) {
            int elem = sc.nextInt();
            s.insertAt(elem,i);
        }
        // s.mergeSortRecursive(0,(arr.size-1));
        // s.mergeSortIterative();
        QuickSort(s.arr);
        s.printArray();
    }
}