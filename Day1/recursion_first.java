public class recursion_first{
    public static void main(String[] args) {
    int n=-5;
    System.out.println(sum(n));
    }
    public static int sum(int k)
    {
     if(k<0)
     return k+sum(k+1);
     else if(k>0)
     return k+sum(k-1);
     
     return 0;   
    }
}