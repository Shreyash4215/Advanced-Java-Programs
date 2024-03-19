import java.util.*;

class diagonal
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int a[][],i,j,n=3,sum=0,k;

        a = new int[10][10];

        System.out.println("\n Enter The MAtrix");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }

        for(i=0;i<n;i++)
        {
            for(j=n-i-1;j>=0;j--)
            {
                sum=sum+a[i][j];
                break;
            }
            for(k=i;k<n;k++)
            {
                if(j==k)
                {
                    break;
                }
                else
                {
                    sum=sum+a[i][j];
                    break;
                }
            }
        }

        System.out.println("\n Sum="+sum);
    }
}