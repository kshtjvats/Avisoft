import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 abstract class item{
    private int bid;
    private String title,author;
    item(int bid,String title,String author)
    {
        this.bid=bid;
        this.title=title;
        this.author=author;
    }
    public int getBid()
    {
    return bid;
    }
    public String getTitle()
    {
    return title;
    }
    public String getAuthor()
    {
    return author;
    }
    public abstract void displayitem();
}
class Books extends item{
    long isbn;
    Books(int bid,String title,String author,long isbn)
    {
        super(bid,title,author);
        this.isbn=isbn;
    }
        @Override
        public void displayitem()
        {
         System.out.println("Details are -");
         System.out.println("Book ID - "+getBid());
         System.out.println("Author - "+getAuthor());
         System.out.println("Book Title - "+getTitle());
        }
     
    }
    class Magazine extends item{
        int issuen;
        Magazine(int bid,String title,String author,int issuen)
        {
            super(bid,title,author);
            this.issuen=issuen;
        }
            @Override
            public void displayitem()
            {
             System.out.println("Details are -");
             System.out.println("Book ID - "+getBid());
             System.out.println("Author - "+getAuthor());
             System.out.println("Book Title - "+getTitle());
             System.out.println("Issue number- "+issuen);
            }
         
        }
        class LibraryMember {
            static Scanner sc=new Scanner(System.in);
            private String mname;
            private int mid;
            List<Books>b_issued;
            List<Magazine>m_issued;
            LibraryMember(String mname,int mid)
            {
                this.mname=mname;
                this.mid=mid;
                this.b_issued=new ArrayList<Books>();
                this.m_issued=new ArrayList<Magazine>();
            }
            public String getMemberName()
            {
                return mname;
            }
            public int getMemberID()
            {
                return mid;
            }
        }
        class ReturnBook extends Books implements operations{
            int mid;
            List<Books>book=new ArrayList<Books>();
            List<LibraryMember>libm=new ArrayList<LibraryMember>();
            ReturnBook(int bid,String title,String author,long isbn,int mid)
            {
            super(bid,title,author,isbn);
            this.mid=mid;
            }
            void checkout(List<Books>book,List<LibraryMember>libm,int bid,int mid)
            {
                int j=0;
                for(j=0;j<libm.size();j++)
                {
                    if(libm.get(j).getMemberID()==mid)
                    break;
                }
                for(int i=0;i<book.size();i++)
                {
                    if(book.get(i).getBid()==bid)
                    {
                    libm.get(j).b_issued.add(book.get(i));
                    book.remove(i);
                }
            }
        }
        void returnItem(List<Books>book,List<LibraryMember>libm,int bid,int mid)
        {
           System.out.println("hi");
        }
    }
        interface operations {
        abstract void checkout();
        abstract void returnItem();
        }
        class Main{
            static Scanner sc=new Scanner(System.in);
            public static void main(String[] args) {
                List<Books>book=new ArrayList<Books>();
                List<Magazine>mag=new ArrayList<Magazine>();
                List<LibraryMember>libm=new ArrayList<LibraryMember>();
                int c=0;
                while(true)
                {
                System.out.println("Enter a command");
                System.out.println("1 : add Book/magazine");
                System.out.println("2 : Display book/magazine info");
                System.out.println("3 : Add Library Member");
                System.out.println("4 : Display Member info");
                System.out.println("-1 : To terminate");
                c=sc.nextInt();
                if(c==-1)
                break;
                switch (c) {
                    case 1:
                        addInventory(book,mag);
                        break;
                    case 2:
                        System.out.println("Enter 1 for book ,2 for magazine");
                        int d=sc.nextInt();
                        if(d==1)
                        {
                            System.out.println("Enter Book ID");
                            int x=sc.nextInt();
                            for(int i=0;i<book.size();i++)
                            {
                                if(book.get(i).getBid()==x)
                                book.get(i).displayitem();
                            }
                        }
                        else if(d==2)
                        {
                            System.out.println("Enter Magazine ID");
                            int x=sc.nextInt();
                            for(int i=0;i<mag.size();i++)
                            {
                                if(mag.get(i).getBid()==x)
                                mag.get(i).displayitem();
                            }
                        }
                        break;
                    case 3:
                        addMember(libm);
                        break;
                    case 4:
                        showMember(libm);
                        break;
                    case 5:
                        ReturnBook r=new ReturnBook(d, null, null, c, d)
                    default:
                        break;
                }
                }
                
            }
            static void addInventory(List<Books>book,List<Magazine>mag)
            {
                System.out.println("Enter 1 for book ,2 for Magazine");
                int c=sc.nextInt();
                if(c==1)
                {
                    System.out.println("Enter title of book");
                    String s=sc.next();
                    System.out.println("Enter Book ID of book");
                    int bid=sc.nextInt();
                    System.out.println("Enter Author of book");
                    String auth=sc.next();
                    System.out.println("Enter ISBN of book");
                    long isbn=sc.nextLong();
                    book.add(new Books(bid,s,auth,isbn));
                }
                 else if(c==2)
                {
                    System.out.println("Enter title of Magazine");
                    String s=sc.next();
                    System.out.println("Enter Magazine ID");
                    int bid=sc.nextInt();
                    System.out.println("Enter Author of Magazine");
                    String auth=sc.next();
                    System.out.println("Enter issue number of Magazine");
                    int issuen=sc.nextInt();
                    mag.add(new Magazine(bid,s,auth,issuen)); 
                }
            }
            static void addMember(List<LibraryMember>libm)
            {
            System.out.println("Enter Member name");
            String mname=sc.next();
            System.out.println("Enter Member ID");
            int mid=sc.nextInt();
            libm.add(new LibraryMember(mname,mid));
            }
            static void showMember(List<LibraryMember>libm)
            {
                System.out.println("Enter Member ID");
                int mid=sc.nextInt();
                for(int i=0;i<libm.size();i++)
                {
                    if(libm.get(i).getMemberID()==mid)
                    {
                    System.out.println("Details are -");
                    System.out.println("Name : "+libm.get(i).getMemberName());
                    System.out.println("Member ID : "+libm.get(i).getMemberID());
                    break;
                    }
            }
        }
    }