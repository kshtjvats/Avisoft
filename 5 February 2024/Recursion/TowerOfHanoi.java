import java.util.Scanner; 

public class TowerOfHanoi{

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of disks: ");
    int n = input.nextInt();

    // Find the solution recursively
    System.out.println("The moves are:");
    moveDisks(n, 'A', 'B', 'C');
  }

  public static void moveDisks(int n, char fromTower,
      char toTower, char auxTower) {
    if (n == 1) // Stopping condition
      System.out.println(fromTower+" "+toTower);
    else {
      moveDisks(n - 1, fromTower, auxTower, toTower);
      System.out.println(fromTower + " " + toTower);
      moveDisks(n - 1, auxTower, toTower, fromTower);
    }
  }
}