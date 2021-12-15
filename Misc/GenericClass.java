package com.company.Misc;

public class GenericClass<Thing> {

    Thing x;

    GenericClass(Thing x){
        this.x = x;
    }

    public Thing getValue(){
        return x;
    }

    public void displayValue(){
        System.out.println(x);
    }

    public static void main(String[] args) {
        GenericClass<Integer> myInt = new GenericClass<>(1);
        GenericClass<Character> myChar = new GenericClass("d");
        GenericClass<String> myString = new GenericClass<>("Hello");

        myChar.displayValue();
        myInt.displayValue();
        myString.displayValue();
    }
}
