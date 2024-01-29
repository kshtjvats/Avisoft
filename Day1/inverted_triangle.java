public class inverted_triangle {
    public static void main(String[] args) {
    int n=5,x=2;
        for(int i=1;i<=n;i++)
        {
        if(i==1)
        {
        for(int j=1;j<=n;j++)
        System.out.print("* ");
        }
        else
        {
        int l=2*n;
        for(int j=1;j<=l;j++)
        {
            if(j==x||j==l-x)
            System.out.print("*");
            else
            System.out.print(" ");
        }
        x=x+1;
        }
        System.out.println();
        }
}
}