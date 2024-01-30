import java.util.Scanner;

public class FirstNlast {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int [] arr=new int[n];
        int target;
        System.out.println("Enter target elm");
        target=sc.nextInt();
        System.out.println("Enter elements of array");
        int p=0;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]==target&&flag==false)
            {
            flag=true;
            System.out.println("First occurence= "+i);
            }
            if(flag==true &&arr[i]==target&&arr[i]!=arr[i+1])
            {
                System.out.println("Last occurence= "+i);
            }
        }
}
}