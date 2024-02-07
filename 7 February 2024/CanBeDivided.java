import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class CanBeDivided{
static boolean flag=true;
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    HashSet<String>dict=new HashSet<>();
    System.out.println("Enter your String");
    String s=sc.next();
    System.out.println("Enter number of words");
    int n=sc.nextInt();
    System.out.println("Enter your strings for word list");
    for(int i=0;i<n;i++)
    {
        dict.add(sc.next());
    }
    System.out.println(help(s,dict));

}
static boolean help(String s,HashSet<String>dict)
{
    if(s.length()==0)
    return true;
    for(int i=1;i<=s.length();i++)
    {
        String left=s.substring(0,i);
        if(dict.contains(left)&&help(s.substring(i),dict))
        return true;
    }
    return false;
}
}