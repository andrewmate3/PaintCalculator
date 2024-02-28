package org.example;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


abstract class Gui implements ActionListener {

   // Constructor
    Gui(){
    }

    public static double calculateWallArea(double length, double height, double windowArea, double numberOfCoats, double doorArea){
        return ((length * height) - (windowArea + doorArea)) * numberOfCoats;
    }

    public static double calculateDoorArea(double doorLength, double doorHeight){
        return doorLength * doorHeight;
    }
    public static double calculateWindowArea(double windowLength, double windowHeight){
        return windowHeight * windowLength;
    }

    public static double totalWindowArea(List<Double> windowLengths, List<Double> windowHeights, int numberOfWindows){
        double totalWindowArea = 0;
        for(int i = 0; i < numberOfWindows; i++){
            totalWindowArea += calculateWindowArea(windowLengths.get(i), windowHeights.get(i));
        }
        return totalWindowArea;
    }

    public static double totalDoorArea(List<Double> doorLengths, List<Double> doorHeights, int numberOfDoors){
        double totalDoorArea = 0;
        for(int i = 0; i < numberOfDoors; i++){
            totalDoorArea += calculateDoorArea(doorLengths.get(i), doorHeights.get(i));
        }
        return totalDoorArea;
    }

    public static double gallonsNeeded(double wallArea){
        double squareFootPerGallon = 400;
        return wallArea / squareFootPerGallon;
    }

    public static double totalWallArea(int numberOfWalls, List<Double> wallLengths, List<Double> wallHeights, double windowArea, double doorArea, double numberOfCoats){
        double totalWallArea = 0;
        for(int i = 0; i < numberOfWalls; i++) {
            totalWallArea += calculateWallArea(wallLengths.get(i), wallHeights.get(i), windowArea, numberOfCoats, doorArea);
        }
        return totalWallArea;
    }

    public static void displayGallonsNeeded(double gallonsNeeded){
        System.out.println("You need " + gallonsNeeded + " gallons of paint \n");
    }

    public static double computePrice(double gallonsNeeded, double pricePerGallon, double hoursNeeded, double costPerHour, int numberOfWorkers ){
        double totalPrice = 0;
        double materialPrice;
        double labourPrice;
        materialPrice = pricePerGallon * gallonsNeeded;
        System.out.printf("Price of materials is: $%f \n", materialPrice);
        totalPrice += materialPrice;
        labourPrice = (hoursNeeded * costPerHour) * numberOfWorkers;
        System.out.printf("Price of labor is: $%f \n", labourPrice);
        totalPrice += labourPrice;
        return totalPrice;
    }

    public static void displayPrice(double totalPrice){
        System.out.println("Total Price is $" + totalPrice + ".");
    }

    public static double hoursNeeded(double wallArea){
        return wallArea / 17500;
    }

    public static void displayHoursNeeded(double hoursNeeded){
        System.out.printf("Total hours needed are: %f", hoursNeeded);
    }
    public static void main(String[] args){

        List<Double> wallLengths = new ArrayList<>();
        List<Double> wallHeights = new ArrayList<>();
        List<Double> windowLengths = new ArrayList<>();
        List<Double> windowHeights = new ArrayList<>();
        List<Double> doorLengths = new ArrayList<>();
        List<Double> doorHeights = new ArrayList<>();
        double numberOfCoats;
        int numberOfDoors;
        int numberOfWindows;
        double pricePerGallon;
        int numberOfWalls;
        double costPerHour;
        int numberOfWorkers;
        double windowArea;
        double doorArea;

        Scanner keyboard = new Scanner(System.in);


            do {
                System.out.println("Enter the number of walls you wish to paint");
                while(!keyboard.hasNextInt()){
                    System.out.println("That is not a valid number");
                    keyboard.next();
                }
                numberOfWalls = keyboard.nextInt();
            } while (numberOfWalls < 0);

            System.out.println("Enter the lengths of the walls (m)");
            for (int i = 0; i < numberOfWalls; i++) {
                try {
                    double length = keyboard.nextDouble();
                    if (length < 0) {
                        throw new BadInputException("Length must be an integer");
                    }
                    wallLengths.add(length);
                } catch (BadInputException e) {
                    System.out.println(e);
                }
            }

            System.out.println("Enter the heights of the walls (m)");
            for (int i = 0; i < numberOfWalls; i++) {
                try {
                    double height = keyboard.nextDouble();
                    if(height < 0){
                        throw new BadInputException("Height must be an integer");
                    } wallHeights.add(height);
                } catch (BadInputException e) {
                    System.out.println(e);
                }
            }

            do {
                System.out.println("Enter the number of windows in the room");
                while (!keyboard.hasNextInt()) {
                    System.out.println("This is not a valid number");
                }
                numberOfWindows = keyboard.nextInt();
            } while(numberOfWindows < 0);

            System.out.println("Enter the lengths of the windows (m)");
            for (int i = 0; i < numberOfWindows; i++) {
                try{
                    double wLength = keyboard.nextDouble();
                    if(wLength < 0){
                        throw new BadInputException("Length must be an integer");
                    } windowLengths.add(wLength);
                } catch (BadInputException e){
                    System.out.println(e);
                }
            }

            System.out.println("Enter the heights of the windows (m)");
        for (int i = 0; i < numberOfWindows; i++) {
            try{
                double wHeight = keyboard.nextDouble();
                if(wHeight < 0){
                    throw new BadInputException("Height must be an integer");
                } windowHeights.add(wHeight);
            } catch (BadInputException e){
                System.out.println(e);
            }
        }

            do {
                System.out.println("Enter the number of doors in the room");
                while(!keyboard.hasNextInt()){
                    System.out.println("That is not a valid number");
                    keyboard.next();
                }
                numberOfDoors = keyboard.nextInt();
            } while (numberOfDoors < 0);

            System.out.println("Enter the lengths of the doors (m)");
        for (int i = 0; i < numberOfDoors; i++) {
            try{
                double dLength = keyboard.nextDouble();
                if(dLength < 0){
                    throw new BadInputException("Length must be an integer");
                } doorLengths.add(dLength);
            } catch (BadInputException e){
                System.out.println(e);
            }
        }

            System.out.println("Enter the heights of the doors (m)");
            for (int i = 0; i < numberOfDoors; i++) {
                try{
                    double dHeight = keyboard.nextDouble();
                    if(dHeight < 0){
                        throw new BadInputException("Height must be an integer");
                    } doorHeights.add(dHeight);
                } catch (BadInputException e){
                    System.out.println(e);
                }
        }

            System.out.println("What is the price per gallon of paint you are using");
            pricePerGallon = keyboard.nextDouble();

            System.out.println("How many coats of paint are you planning on doing?");
            numberOfCoats = keyboard.nextDouble();

            System.out.println("How many workers are there?");
            numberOfWorkers = keyboard.nextInt();

            System.out.println("What is the cost per hour of the workers");
            costPerHour = keyboard.nextDouble();

            windowArea = totalWindowArea(windowLengths, windowHeights, numberOfWindows);
            doorArea = totalDoorArea(doorLengths, doorHeights, numberOfDoors);
            double wallArea = totalWallArea(numberOfWalls, wallLengths, wallHeights, windowArea, doorArea, numberOfCoats);
            double gallonsNeeded = gallonsNeeded(wallArea);
            double hoursNeeded = hoursNeeded(wallArea);
            double computePrice = computePrice(gallonsNeeded, pricePerGallon, hoursNeeded, costPerHour, numberOfWorkers);

            displayGallonsNeeded(gallonsNeeded);
            displayPrice(computePrice);
            displayHoursNeeded(wallArea);
    }
}