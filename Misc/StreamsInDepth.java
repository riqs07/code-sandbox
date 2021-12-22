package com.company.Misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsInDepth {
    //init dataset

    static class Car{

        String make;
        String model;
        int miles;
        int cost;
        int year;
        boolean isRegistered;


        public Car(String make,String model, int miles, int cost, int year){
            this.make = make;
            this.model = model;
            this.miles = miles;
            this.year = year;
            this.cost = cost;
            this.isRegistered = false;
        }

        public void getInfo(){
            System.out.println(this.year + " "+ this.make + " " + this.model + " Cost:$" + this.cost + " Miles: " + this.miles);
        }

        public void setRegistered(){
            this.isRegistered = true;
        }
    }

    public static void main(String[] args) {

        List<Car> parkingLot = new ArrayList<>();

        parkingLot.add(new Car("Honda", "Accord", 10, 20000, 2020));
        parkingLot.add(new Car("Honda", "Accord", 30_000, 15000, 2018));
        parkingLot.add(new Car("Honda", "Accord", 300_000, 9000, 2007));
        parkingLot.add(new Car("Honda", "Accord", 100_000, 4000, 2003));
        parkingLot.add(new Car("Honda", "Civic", 120_000, 4000, 2009));
        parkingLot.add(new Car("Honda", "Civic", 125_000, 4000, 2009));
        parkingLot.add(new Car("Honda", "Civic", 55, 24000, 2020));


        parkingLot.add(new Car("Toyota", "Camry", 40, 23000, 2021));
        parkingLot.add(new Car("Toyota", "Camry", 140_000, 6000, 2006));
        parkingLot.add(new Car("Toyota", "Prius", 90_000, 12000, 2014));
        parkingLot.add(new Car("Toyota", "Prius", 250, 26000, 2020));


        /// Fun with Streams ///

        // For Each - Iterate over every item //
        // Increment Counter

        AtomicInteger lotCount = new AtomicInteger();

        parkingLot.stream()
                .forEach(car -> lotCount.getAndIncrement());

//        System.out.println(lotCount);


        // Filter - Run a test on each element
        // Get a list of just Hondas in our Lot

        // this returns a list i can work with later
        // technically i could not collect & just do a for each
        List<Car> onlyHonda = parkingLot.stream()
                .filter(car -> car.make == "Honda")
                .collect(Collectors.toList());

//        onlyHonda.stream().forEach(car -> car.getInfo());

//       If I dont need a object returned
//        parkingLot.stream()
//                    .filter(car -> car.make == "Honda")
//                    .forEach(car -> car.getInfo());


        // Filter Older cars
//        parkingLot.stream()
//                .filter(car -> car.year > 2015)
//                .forEach(car -> car.getInfo());


        // Map
        // Inflation price hike
        // Raise prices -- Modifies list
        // if i want a new list I need to use getters to get values from each car object

        parkingLot.stream()
                .forEach(car -> car.cost = (int) (car.cost * 1.2));

//        parkingLot.forEach(car -> car.getInfo());


        // Power comes in chaining
        // Super saver
        // Find all cars under 1000,000 & older than 2015
        // sort
        // return in a new list


       List<Car> carsForSuperSale = parkingLot.stream()
                .filter(car -> car.miles > 100_000 && car.year < 2015)
               .sorted(Comparator.comparing((car -> car.cost)))
               .sorted(Comparator.comparing((car -> car.miles)))
               .collect(Collectors.toList());

       carsForSuperSale.stream().forEach(car -> car.getInfo());






    }
}
