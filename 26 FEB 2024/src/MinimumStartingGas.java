import java.util.InputMismatchException;
import java.util.Scanner;

public class MinimumStartingGas {

    public int canCompleteCircuit(final int[] A, final int[] B) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingStation = 0;

        // Calculate the total gas and total cost of the circuit
        for (int i = 0; i < A.length; i++) {
            totalGas += A[i];
            totalCost += B[i];
            // If at any station the gas available is less than the cost to reach the next station,
            // update the starting station to the next station and reset the current gas to 0
            if (currentGas + A[i] < B[i]) {
                startingStation = i + 1;
                currentGas = 0;
            } else {
                // Otherwise, continue to the next station with updated current gas
                currentGas += A[i] - B[i];
            }
        }

        // If the total gas available is less than the total cost, it's impossible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }

        // If the total gas available is greater than or equal to the total cost, return the starting station
        return startingStation % A.length;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
        System.out.println("Enter size of first array");
        int n=sc.nextInt();
        System.out.println("Enter Size of Second array");
        int n1=sc.nextInt();
        int[]A=new int[n];
        int[]B=new int[n1];
        System.out.println("Enter elements of first array");
            for(int i=0;i<n;i++)
            A[i]=sc.nextInt();
        System.out.println("Enter elements of second array");
        for(int i=0;i<n1;i++)
            B[i]=sc.nextInt();
        MinimumStartingGas m=new MinimumStartingGas();
        System.out.println(m.canCompleteCircuit(A,B));
        }
        catch(InputMismatchException e)
        {
            System.err.println("Invalid input type");
        }
        finally{
        sc.close();
        }
    }
}
