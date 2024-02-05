import java.util.Scanner;

public class Newspaper{
 public static void main(String[] args) {
    int n;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter number of words in string");
    n=sc.nextInt();
    String [] arr=new String[n];
    String l="";
    for(int i=0;i<n;i++)
    {
    arr[i]=sc.next();
    for(int j=0;j<arr[i].length();j++)
    arr[i]=(arr[i].substring(0,1)).toUpperCase()+(arr[i].substring(1,arr[i].length())).toLowerCase();
    l=l+" "+arr[i];
    }
    l=l.trim();
    String ans="";
    for(int i=0;i<l.length();i++)
    {
        if((l.charAt(i)>='A'&&l.charAt(i)<='z')||l.charAt(i)==' '|| l.charAt(i)==':')
        ans=ans+l.charAt(i);
    }
    System.out.println(((ans.substring(0,1)).toUpperCase())+ans.substring(1,ans.length()));
}
}
