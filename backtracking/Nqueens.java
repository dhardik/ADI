import java.util.Scanner;
public class Nqueens
{
	static void generate(int arr[],int index,int n)
	{
		if(index==n)
		{
			int i;
			System.out.print("[");
			for(i=0;i<n;++i)
				System.out.print((arr[i]+1)+" ");
			System.out.print("] ");
		}
		else
		{
			int i,j,flag;
			for(i=0;i<n;++i)
			{
				flag=0;
				for(j=0;j<index;++j)
				{
					if(arr[j]==i||index-j==arr[j]-i||index-j==i-arr[j])
					{
						flag=1;
						break;
					}
				}
				if(flag==0)
				{
					arr[index]=i;
					generate(arr,index+1,n);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0)
		{
			int i,n;
			n=sc.nextInt();
			int arr[]=new int[n];
			for(i=0;i<n;++i)
				arr[i]=-1;
			generate(arr,0,n);
			for(i=n-1;i>=0;--i)
			{
				if(arr[i]==-1)
				{
					System.out.print("-1");
					break;
				}
			}
			System.out.println();
		}
	}
}