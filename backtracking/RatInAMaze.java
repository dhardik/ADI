import java.util.*;
class Maze
{
    static void generate(ArrayList<String> a,int[][] arr,String s,int x,int y,int n)
    {
        if(x==n-1&&y==n-1)
        {
            a.add(s);
        }
        else
        {
            if(x+1<=n-1&&arr[x+1][y]==1)
            {
                s=s+"D";
                arr[x+1][y]=0;
                generate(a,arr,s,x+1,y,n);
                if(s.length()==1)
                    s="";
                else
                    s=s.substring(0,s.length()-1);
                arr[x+1][y]=1;
            }
            if(y-1>=0&&arr[x][y-1]==1)
            {
                s=s+"L";
                arr[x][y-1]=0;
                generate(a,arr,s,x,y-1,n);
                if(s.length()==1)
                    s="";
                else
                    s=s.substring(0,s.length()-1);
                arr[x][y-1]=1;
            }
            if(y+1<=n-1&&arr[x][y+1]==1)
            {
                s=s+"R";
                arr[x][y+1]=0;
                generate(a,arr,s,x,y+1,n);
                if(s.length()==1)
                    s="";
                else
                    s=s.substring(0,s.length()-1);
                arr[x][y+1]=1;
            }
            if(x-1>=0&&arr[x-1][y]==1)
            {
                s=s+"U";
                arr[x-1][y]=0;
                generate(a,arr,s,x-1,y,n);
                arr[x-1][y]=1;
            }
        }
    }
    public static ArrayList<String> printPath(int[][] m, int n)
    {
        ArrayList<String> a=new ArrayList<String>();
        String s="";
        m[0][0]=0;
        generate(a,m,s,0,0,n);
        return a;
    }
}
class RatInAMaze
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			Maze m=new Maze();
			ArrayList<String> res=m.printPath(a,n);
			for(int i=0;i<res.size();i++)
				System.out.print(res.get(i)+" ");
			System.out.println();
		}
	}
}