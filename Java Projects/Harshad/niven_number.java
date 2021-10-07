
import java.io.*;
import java.util.*;
class Magic_Composite
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Enter Number");
        n= in.nextInt();
        if(isComposite(n)==true && isMagic(n)==true)
        {
            System.out.println("It is a Magic Composite Number : "+n);
        }
        else
        {
            System.out.println("It is not a Magic Composite Number : "+n);
        }
    }// end of main method
    public static boolean isComposite(int x)
    {
        int i,c=0;
        for(i=1;i<=x;i++)
        {
            if(x%i==0)
            {
                c++;
            }
        }
        if(c>2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// end of isComposite()
    public static boolean isMagic(int y)
    {
        int a=0,s=0;
        while(y>9)
        {
            s=0;
            a=y;
            while(a!=0)
            {
                s=s+(a%10);
                a=a/10;
            }
            y=s;
        }
        if(y==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// end of isMagic()
}//end of class
