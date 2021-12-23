package com.company.DesignPatterns;

public class Builder {


    // Car is not accessible until it is done building
    private Car builtCar;

    // sets car to a new car object using internal reset
    public Builder(){
     this.reset();
    }

    // ability to start over with blank
    public void reset(){
        this.builtCar = new Car();
    }

    // Use setters to build object step by step
    // or only set values while leaving optionals blank

    public void setYear(int year) {
        builtCar.year = year;
    }

    public void setSeats(int seats) {
        builtCar.seats = seats;
    }

    public void setMPG(int MPG) {
        builtCar.MPG = MPG;
    }

    public void setWheels(int wheels) {
        builtCar.wheels = wheels;
    }

    public void setAutomatic(boolean automatic) {
        builtCar.isAutomatic = automatic;
    }

    public void setElectric(boolean electric) {
        builtCar.isElectric = electric;
    }

    public void setSteerSide(String steerSide) {
        builtCar.steerSide = steerSide;
    }

    public void setEngine(String engine) {
        builtCar.engine = engine;
    }

    public Car getResult(){
        return builtCar;
    }

    static class Car {

        int year;
        int seats;
        int MPG;
        int wheels;

        boolean isAutomatic;
        boolean isElectric;

        String steerSide;
        String engine;


        public void getInfo(){
            System.out.println("Seats: " + this.seats + " Wheels: " + this.wheels + " Engine: " + this.engine + "\n" +
                    " Steer Side: " + this.steerSide + " Automatic: " + this.isAutomatic + " Electric: " + isElectric);
        }

    }

    // Director Class knows the most common configurartoin
    // This further abstracts the internal builder methods from client
    //
    static class Director {

        public void constructSportsCar(Builder builder) {
            builder.setSeats(2);
            builder.setEngine("v8");
            builder.setAutomatic(true);
            builder.setSteerSide("left");
            builder.setWheels(4);
            builder.setMPG(22);
        }

        public void constructTruck(Builder builder) {
            builder.setSeats(2);
            builder.setEngine("v10");
            builder.setAutomatic(true);
            builder.setSteerSide("left");
            builder.setWheels(18);
            builder.setMPG(14);
        }

        public void constructCityCar(Builder builder) {
            builder.setSeats(2);
            builder.setEngine("v4");
            builder.setAutomatic(true);
            builder.setSteerSide("left");
            builder.setWheels(4);
            builder.setMPG(28);
        }


    }




    public static void main(String[] args) {

        // Builder Step-by-Step
        Builder b = new Builder();

        b.setYear(2015);
        b.setAutomatic(true);
        b.setSteerSide("left");
        b.setElectric(true);
        b.setSeats(4);


       Car newCar = b.getResult();
       newCar.getInfo();




        // Using the Director Class
        // Init Director & Builder
        // Remember builder inits as a blank.
        Director d = new Director();
        Builder car = new Builder();

        // This is a common Config for Car
        d.constructCityCar(car);


        // or directly call the getInfo method
        car.getResult().getInfo();

    }
}
