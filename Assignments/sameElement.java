import java.util.*;

class sameElement
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int a[],i,j,n=6,k=3,sum=0,max=0;

        a = new int[10];

        System.out.println("\n Enter The elements");
        for(i=0;i<n;i++)
             a[i]=sc.nextInt();
       
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i]==a[j])
                {
                    sum=sum+a[i];
                }
            }
            
            if(max<sum)
            max=sum;

            sum=0;
        }

        System.out.println("\n MAx element="+max);
    }
}