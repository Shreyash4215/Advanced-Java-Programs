import java.util.*;

class daigonalZero
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int a[][],i,j,n=3,m=0,l=0;

        a = new int[10][10];

        System.out.println("\n Enter The Matrix");
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                 a[i][j]=sc.nextInt();
       
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i][j]==0)
                {
                    m=i;
                    l=j;
                }
            }
        }

        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
            {
                if(i==m)
                {
                    a[i][j]=0;
                }
                if(j==l)
                {
                    a[i][j]=0;
                }
            }
        
        for(i=0;i<n;i++)
        {
            System.out.print("\n");
            for(j=0;j<n;j++)
                System.out.print(" "+a[i][j]);
        }
    }
}