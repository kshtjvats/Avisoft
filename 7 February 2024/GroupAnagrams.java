import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class GroupAnagrams{
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    List<List<String>>ls=new ArrayList<>();//defining a 2d array list to store list of anangrams 
    Map<String,List<String>> hp=new HashMap<>(); //defining hashmap
    System.out.println("Enter array size");
    int n=sc.nextInt();
    String [] array=new String[n];
    System.out.println("Enter your strings");
    for(int i=0;i<n;i++)
    {
        array[i]=sc.next();//accepting strings
    }
    for(int i=0;i<n;i++)
    {
        char[] x=(array[i].toCharArray());//converting a particular string to character array to sort it
        Arrays.sort(x);
        String sorted= String.valueOf(x); //example eat ,ate and tea will get sorted to aet and we will check for if this key is present 
        if(!hp.containsKey(sorted))  //check if that key is present
            hp.put(sorted,new ArrayList()); //if not present create an array list corresponding to that key
        hp.get(sorted).add(array[i]); //add strings to corresponding key array list
    }
    hp.forEach((k,v)->{
        ls.add(v); //add list of each key to a seperate 2d array list
    });
    System.out.println("Group Anagrams are :");
    System.out.println(ls);

}
}