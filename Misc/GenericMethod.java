package com.company.Misc;

public class GenericMethod {
    // Have one Method that can handle diffrent data types

    public static void main(String[] args) {


        // Arrays are smilair but could not be passed into the same method as they
        // are diffrent data types

        // Generics provide a generic form of the array to be manipulated by a single method
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3};
        Character[] charArray = {'a','b','c','d'};
        String[] strArray = {"SEE","I","TOLD","YOU"};

        // Using Generic Display array can work for EACH array
//        displayArray(intArray);
//        displayArray(charArray);
//        displayArray(doubleArray);
//        displayArray(strArray);

        System.out.println(getFirstElement(intArray));
        System.out.println(getFirstElement(strArray));
        System.out.println(getFirstElement(doubleArray));


    }




    public static <Thing> void displayArray(Thing[] array){
        for (Thing element : array){
            System.out.print(element + " ");
        }
        System.out.println();
    }


    public static <T> T getFirstElement(T[] array){
        return array[0];
    }
}
