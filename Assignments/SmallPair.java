import java.util.*;

class SmallPair
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int i,j,k;
        String s1="HugsForBugs";

        char a[];

        a = new char[20];

        for(i=0;i<s1.length();i++)
            a[i]=s1.charAt(i);

        Arrays.sort(a,0,11);

        for(i=0;i<s1.length();i++)
            for(j=i+1;j<s1.length();j++)
                if(a[i]==a[j])
                {
                    for(k=j;k<s1.length();k++)
                        a[k]=a[k+1];
                    
                }

        for(i=0;i<s1.length();i++)
            System.out.print(""+a[i]);       
       
    }
}