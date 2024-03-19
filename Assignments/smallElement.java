import java.util.*;

class smallElement
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int a[],i,j,n=8,k=3,temp;

        a = new int[10];

        System.out.println("\n Enter The elements");
        for(i=0;i<n;i++)
             a[i]=sc.nextInt();
       
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i]<a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }

        System.out.println("\n smallest element="+a[k-1]);
    }
}