import java.util.*;

class paranthesisCnt
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int i,lft=0,rgt=0;
		String str;

        System.out.print("\n Enter String:");
		str = sc.next();
		
        for(i=0;i<str.length();i++)
			if(str.charAt(i)=='(')
				lft++;
			else if(str.charAt(i)==')')
				rgt++;
        
		if(lft == rgt)
			System.out.println("\n True");
		else
			System.out.println("\n False");
    }
}