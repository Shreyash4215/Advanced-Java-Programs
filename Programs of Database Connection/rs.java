import java.util.*;

class rs
{
	public static void main(String args[])
	{
		int arr[],cnt;
		Random r = new Random();
		
		arr = new int[7];
		
		for(int i=0;i<7;i++)
		{
			cnt=0;
			int n = r.nextInt(8);
			for(int j=0;j<arr.length;j++)
			{
				if(arr[j]== n)
					cnt=1;
			}
			if(cnt==0)
				arr[i]=n;
			else
				i--;
		}
		for(int i=0;i<7;i++)
			System.out.println("\n "+arr[i]);
		
	}	
}