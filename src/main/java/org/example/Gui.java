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
        return wallArea / 175;
    }

    public static void displayHoursNeeded(double hoursNeeded){
        System.out.printf("Total hours needed are: %f", hoursNeeded);
    }

    public static void main(String[] args){

        List<Double> wallLengths = new ArrayList<>();
        List<Double> wallHeights = new ArrayList<>();
        double doorLength;
        double windowLength;
        double doorHeight;
        double windowHeight;
        double numberOfCoats;
        double pricePerGallon;
        int numberOfWalls;
        double costPerHour;
        int numberOfWorkers;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the number of walls you wish to paint");
        numberOfWalls = keyboard.nextInt();

        System.out.println("Enter the lengths of the walls");
        for(int i = 0; i < numberOfWalls; i++){
            double length = keyboard.nextDouble();
            wallLengths.add(length);
        }

        System.out.println("Enter the heights of the walls");
        for(int i = 0; i < numberOfWalls; i++){
            double height = keyboard.nextDouble();
            wallHeights.add(height);
        }

        System.out.println("What is the length of your windows?");
        windowLength = keyboard.nextDouble();

        System.out.println("What is the height of your windows?");
        windowHeight = keyboard.nextDouble();

        System.out.println("What is the length of your doors?");
        doorLength = keyboard.nextDouble();

        System.out.println("What is the height of your doors?");
        doorHeight = keyboard.nextDouble();

        System.out.println("What is the price per gallon of paint you are using");
        pricePerGallon = keyboard.nextDouble();

        System.out.println("How many coats of paint are you planning on doing?");
        numberOfCoats = keyboard.nextDouble();

        System.out.println("How many workers are there?");
        numberOfWorkers = keyboard.nextInt();

        System.out.println("What is the cost per hour of the workers");
        costPerHour = keyboard.nextDouble();

        double doorArea = calculateDoorArea(doorLength, doorHeight);
        double windowArea = calculateWindowArea(windowLength, windowHeight);
        double wallArea = totalWallArea(numberOfWalls, wallLengths, wallHeights, windowArea, doorArea, numberOfCoats);
        double gallonsNeeded = gallonsNeeded(wallArea);
        double hoursNeeded = hoursNeeded(wallArea);
        double computePrice = computePrice(gallonsNeeded, pricePerGallon, hoursNeeded, costPerHour, numberOfWorkers);

        displayGallonsNeeded(gallonsNeeded);
        displayPrice(computePrice);
        displayHoursNeeded(wallArea);
    }
}