import java.util.ArrayList;
import java.util.Scanner;

public class calc_mov_avg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the number: ");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter digit "+(i+1)+": ");
            int digit = sc.nextInt();
            list.add(digit);
        }

        int window_size;
        do {
            System.out.print("Enter the window size: ");
            window_size = sc.nextInt();
        }
        while (window_size<1 || window_size>n);

        int start = 0;
        int end = window_size-1;
        ArrayList<Integer> result = new ArrayList<>();

        while(end<n){
            double sum = 0;
            for(int i=start; i<=end; i++){
                sum+= list.get(i);
            }
            int ans = (int)Math.ceil(sum/window_size);
            result.add(ans);
            start++;
            end++;
        }

        System.out.println(result);
        sc.close();
    }
}