import java.util.Scanner;
class LL {
    private Node head;
    private class Node{
    char data;
    Node next;
    Node(char data)
    {
        this.data=data;
        next=null;
    }
    }
    public Node add(char data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
        }
        else
        {
            Node current=head;
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=newNode;
        }
        return head;
    }
    class indexException extends Exception{
        indexException(String message)
        {
        super(message);
    }
}
    void Slc() throws indexException { //function to accept and slice
    System.out.println("Enter a sentence");
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    LL list = new LL();
    Node head=null;
    for (int i = 0; i < s.length(); i++) {
        head=list.add(s.charAt(i));
    }
    System.out.println("Enter the index to slice between");
    int si = sc.nextInt();
    int li = sc.nextInt();
    if(li>s.length())
    li=s.length()-1;
    sc.close();
    if (si > li || si < 0) {
        throw new indexException("Invalid choice of indexes");
    }
    else {
        int i = 0;
        Node curr = head;
        while (curr != null && i < si) {
            curr = curr.next;
            i++;
        }
        System.out.println("Sliced string is : ");
        while (curr != null && i <= li) {
            System.out.print(curr.data);
            curr = curr.next;
            i++;
        }
    }
}
}
class Main
{
    public static void main(String[] args) {
        LL l=new LL();
        try{
        l.Slc();
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
