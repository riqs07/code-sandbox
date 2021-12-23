package com.company.DesignPatterns;

public class Singleton {

    // The whole idea is to create an object that is the ONLY of its kind.
    // This allows global access for the rest of our object, but they are all sharing the same Object.

    // Note there is no public constructor.
    // Only way to access is through the get instance method.

    // Creating an empty variable that just tracks if instance is made
    private static Singleton instance = null;

    // Examples of Data & Methods Singleton can have
    private static int clientCount = 0;


    // Note this method is not static
    private void getData(){
        System.out.println("I AM THE SINGLETON. I AM ONE OF A KIND. 1 OF 1. A RARE BREED. CURRENTLY I HAVE " + clientCount + " CLIENT(S).");

        if (clientCount > 1){
            System.out.println("YOU THOUGHT YOU COULD EVADE ME. FOOLISH MORTAL! I AM THE SINGLETON!");
        }

    }


    // Public Access for our singleton object
    // Creates object if 1st time called
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        clientCount++;
        return instance;
    }

    public static void main(String[] args) {

        // These all return the same SINGLE object. Not multiple of the same object
        Singleton Mac = Singleton.getInstance();

        Singleton Miller = Singleton.getInstance();
        Singleton Scott = Singleton.getInstance();

        Miller.getData();


        // Can call chain methods onto the static getInstance
        // Just like above this adds another client to the Singleton
        Singleton.getInstance().getData();
    }
}
