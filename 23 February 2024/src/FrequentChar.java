import java.util.Scanner;
public class FrequentChar {

        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your string");
        String s=sc.nextLine();
        int []arr=new int['z'];
        s=s.toUpperCase();
        sc.close();
        int max=0,ind=0;
        for(int i=0;i<s.length();i++)
        {
        arr[s.charAt(i)]+=1;
        if(arr[s.charAt(i)]>max)
        {
        max=arr[s.charAt(i)];
        ind=i;
        }
        }
        System.out.println(s.charAt(ind));
        }
    }

