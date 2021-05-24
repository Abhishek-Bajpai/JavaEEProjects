class Singleton{

    private static Singleton instance=null;
    public String str = "I am a member of Singleton class";

    //private constructor for this class
    private Singleton(){
        str = "Member string modified by the private default constructor !!";
    }

    //static methoid to create/get singleton object
    public static Singleton getInstance(){
        if(instance==null)
            instance = new Singleton();

    return instance;
    }


}

class RunSingleton{
    public static void main(String[] args){
        // instantiating Singleton class with variable x 
        Singleton x = Singleton.getInstance(); 
  
        // instantiating Singleton class with variable y 
        Singleton y = Singleton.getInstance(); 
  
        // instantiating Singleton class with variable z 
        Singleton z = Singleton.getInstance();

        System.out.println("String from x is " + x.str); 
        System.out.println("String from y is " + y.str); 
        System.out.println("String from z is " + z.str); 
        System.out.println("\n"); 

    }
}
