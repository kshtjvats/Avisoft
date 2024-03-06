package Rs;

import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
    ReservationSystem r=new ReservationSystem();
    int c=0;
    while(c!=-1)
    {
        System.out.println("Enter a choice");
        System.out.println("1 : ADD A FLIGHT TO DATABASE");
        System.out.println("2 : DISPLAY A FLIGHT INFO");
        if(c==-1)
        break;
        c=sc.nextInt();
        switch (c) { 
            case 1:
                try{
                   r.addFlight();
                }
                catch(ReservationException e)
                {
                System.err.println(e.getMessage());
                }
                break;
            case 2:
            try{
                r.searchFlight();
             }
             catch(ReservationException e)
             {
                System.err.println(e.getMessage());
             }
            break;
            default:
                break;
        }
    }
    }
}