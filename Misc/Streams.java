package com.company.Misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    static class Person {
        String name;
        int age;
        int wage;

        public Person(String n, int age, int wage) {
            this.name = n;
            this.age = age;
            this.wage = wage;
        }
    }

    public static void main(String[] args) {


        // Init List
        List<Person> people = new ArrayList<>();

        people.add(new Person("Jim",21,39000));
        people.add(new Person("Dwight",36,41000));
        people.add(new Person("James",36,10000));
        people.add(new Person("Nara",17,13000));
        people.add(new Person("Tom",44,45000));
        people.add(new Person("Sally",33,80000));
        people.add(new Person("Ramon",50,190000));


        List<Person> highIncome = new ArrayList<>();

        /// Traditional way to apply logic in a loop

        for (Person p:people){
            if (p.wage > 60000){
                highIncome.add(p);
            }
        }
        System.out.println("Traditional\n" );

        //highIncome.forEach(person -> System.out.println(person.name));


        // Java Streams //

        // Filter applies function to every item in list
        // collect returns items that pass condition
        List<Person> highIncome2 = people.stream().filter(person -> person.wage >= 60000)
                .collect(Collectors.toList());

//        highIncome2.forEach(person -> System.out.println(person.name));



        // Sorted List
        List<Person> sortedList = people.stream()
                .sorted(Comparator.comparing(person -> person.name))
                .collect(Collectors.toList());

//        sortedList.forEach(person -> System.out.println(person.name));



        // Can Chain streams, Filter -> sort
        List<Person> lowIncome = people.stream()
                .filter(person -> person.wage <= 60000)
                .sorted(Comparator.comparing((person -> person.name)))
                .collect(Collectors.toList());

        lowIncome.forEach(person -> System.out.println(person.name));

    }



}


