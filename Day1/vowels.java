import java.util.Scanner;
public class vowels {
    public static void main(String[] args) {
        char []arr={'a','e','i','o','u','A','E','I','O','U'};
        String s;
        int v=0;int c=0;int e=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string to check");
        s=sc.nextLine();
        int l=s.length();
        for(int i=0;i<l;i++)
        {
            if(cont(arr,s.charAt(i))==true)
            v=v+1;
            else if(s.charAt(i)>=65&&s.charAt(i)<=122)
            c=c+1;
            else
            e=e+1;
        }
        System.out.println("vowels:"+v+" consonants:"+c+" extra:"+e);  
    }
    public static boolean cont(char[] arr ,char a)  //function to check if char is a vowel
    { 
        boolean flag=false;
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]==a)
            flag=true;
        }
        return flag;
    }
}