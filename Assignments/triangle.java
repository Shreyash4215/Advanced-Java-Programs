import java.util.*;

class triangle{
    public static void main(String args[])
    {
        int i,j,k,n,s;

        Scanner sc = new Scanner(System.in);

        System.out.println("\n Enter the of N");
        n = sc.nextInt();

        for(i=0;i<n;i++)
        {
            System.out.println("");
            
            for(j=0;j<n-i;j++)
            {
                System.out.print("*");
            }

            for(s=0;s<i*2;s++)
            {
                System.out.print(" "); 
            }

            for(k=0;k<n-i;k++)
            {
               
                System.out.print("*");
            }
            
        }
    }
}