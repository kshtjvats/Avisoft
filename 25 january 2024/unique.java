import java.util.Scanner;
public class unique {
public static void main(String[] args) {
char[] arr=new char[500];
for(int i=0;i<200;i++)
arr[i]=0;
Scanner sc=new Scanner(System.in);
String s;
s=sc.next();
for(int i=0;i<s.length();i++)
{
    arr[s.charAt(i)]+=1;
}
for(int i=0;i<arr.length;i++)
{
    if(arr[i]==1)
    System.out.print((char)(i));
}
}
}