public class Sort012 {
    void swap(int arr[],int a,int b)
    {
    int temp=arr[a];
    arr[a]=arr[b];
    arr[b]=temp;
    }
    void st(int arr[],int n)
    {
        int i= 0, j = 0, k= n-1;
      while (j <= k) {
          if (arr[j] == 0) {
              swap(arr,j,i);
              j++;
              i++;
          }
          else if (arr[j] == 1) {
              j++;
          }
          else if (arr[j] == 2) {
              swap(arr,j,k);
              k--;
          }
      }
    }
    public static void main(String[] args) {
        int arr[]={0,1,2,2,2,1,0};
        Sort012 ob=new Sort012();
        ob.st(arr,7);
        for(int i=0;i<7;i++)
        System.out.print(arr[i]+",");
    }
}
