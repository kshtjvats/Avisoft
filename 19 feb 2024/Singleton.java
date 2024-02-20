class Singleton {
    // a static private variable to refer to object of this class
    static private Singleton  singletonInstance = null;

    //private constructor so this class cant be instantiated from outside 
    private Singleton() {
        // constructor code
    }

    //private static method to get instance of this class
    public static synchronized Singleton getInstance() {
        if(singletonInstance == null)
            return singletonInstance = new Singleton();
        else 
            return singletonInstance;
    }
}

class Main{
    public static void main(String[] args){
        // create an object of singleton class
        Singleton instance1 = Singleton.getInstance();

        // create another object of singleton class
        Singleton instance2 = Singleton.getInstance();

        //create another object of singleton class
        Singleton instance3 = Singleton.getInstance();
        
        // printin hashcode of each instance
        System.out.println("hashcode of instance1: " + instance1.hashCode());
        System.out.println("hashcode of instance2: " + instance2.hashCode());
        System.out.println("hashcode of instance3: " + instance3.hashCode());

        //conditionally checking if all instances are identical
        if(instance1 == instance2 && instance2 == instance3)
            System.out.println("Singleton instance created successfully");
        else
            System.out.println("Error in instance creation");
    }
}