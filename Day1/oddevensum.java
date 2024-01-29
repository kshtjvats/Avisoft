import java.util.Scanner;

public class oddevensum {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int s;
s=sc.nextInt();
int e=0,o=0;
while(s!=0)
{
int x=s%10;
if(x%2==0)
e=e+x;
else
o=o+x;
s=s/10;
}
System.out.print("Even Sum= "+e+" and odd sum= "+o);
}
}
    