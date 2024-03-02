import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree {
    int data;
    Tree left;
    Tree right;
    Tree(int data)
    {
        this.data=data;
    }
}
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class Main{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) 
    {
        Tree root=new Tree(1);
        Node head=new Node(root.data);//first 
        Main m=new Main();
        m.addNode(root);//make tree
        m.PrintTree(root);//print tree
       // m.AddToLinkedList(root, head);//vreate ll
        while(head!=null)
        {
            System.out.print(head.data+"->");
            head=head.next;
        }
    }
    void addNode(Tree root)
    {
        System.out.println("Enter the left child of "+root.data);
        int left=sc.nextInt();
        System.out.println("Enter the right child of "+root.data);
        int right=sc.nextInt();
        if(left!=-1)
        {
        root.left.data=left;
        addNode(root.left);
        }
        if(right!=-1)
        {
        root.right.data=right;
        addNode(root.right);
        }
    }
    void PrintTree(Tree root)
    {
        if(root==null)
        return;
       System.out.print(root.data+":");
       PrintTree(root.left);
       PrintTree(root.right);

    }
    /*void AddToLinkedList(Tree root,Node head)
    {
        if(root==null)
        return;
        for(int i=0;i<root.children.size();i++)
        {
        Node nextData=new Node(root.children.get(i).data);
        head.next=nextData;
        head=head.next;
        AddToLinkedList(root.children.get(i),head);
        }
    }*/
        }
    


