import java.util.Scanner;
import java.lang.Math;
public class pattern8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int o=n;
        int c=0;
        int i=0;
        int ne=0;
        while(n!=0)
        {
            n=n/10;
            c++;
        }
        c--;
        int d=1;
        for(int j=1;j<=c;j++)
        d=d*10;
       while(i<c+1)
        {
        ne=(o%d)*10+(o/d);
        System.out.println(ne);
        o=ne;
        i++;
        }
    }
}
