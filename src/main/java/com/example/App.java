
package com.example;

import java.util.Scanner;

public class App {

    // Method to calculate parking fee
    public static double calculateFee(String vehicleType, double hours) {

        if (hours <= 0 || !Double.isFinite(hours)) {
            throw new IllegalArgumentException(
                "Parking duration must be greater than zero.");
        }

        if (vehicleType == null || vehicleType.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Vehicle type cannot be empty.");
        }

        String vehicle = vehicleType.trim().toLowerCase();

        double rate;

        switch (vehicle) {

            case "two-wheeler":
            case "bike":
            case "scooter":
                rate = 10;
                break;

            case "four-wheeler":
            case "car":
                rate = 20;
                break;

            default:
                throw new IllegalArgumentException(
                    "Unsupported vehicle type.");
        }

        return Math.ceil(hours) * rate;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("   VEHICLE PARKING FEE CALCULATOR");
        System.out.println("======================================");

        try {

            System.out.println("1. Two-wheeler");
            System.out.println("2. Four-wheeler");

            System.out.print("Enter Vehicle Type (1/2): ");
            String choice = sc.nextLine().trim();

            String vehicleType;

            if (choice.equals("1")) {
                vehicleType = "two-wheeler";
            }
            else if (choice.equals("2")) {
                vehicleType = "four-wheeler";
            }
            else if (choice.equalsIgnoreCase("bike")
                    || choice.equalsIgnoreCase("scooter")
                    || choice.equalsIgnoreCase("two-wheeler")) {
                vehicleType = "two-wheeler";
            }
            else if (choice.equalsIgnoreCase("car")
                    || choice.equalsIgnoreCase("four-wheeler")) {
                vehicleType = "four-wheeler";
            }
            else {
                throw new IllegalArgumentException(
                    "Unsupported vehicle type.");
            }

            System.out.print("Enter Parking Duration in Hours: ");
            double hours = Double.parseDouble(sc.nextLine());

            double fee = calculateFee(vehicleType, hours);

            double rate = vehicleType.equals("two-wheeler") ? 10 : 20;

            System.out.println("\n========== PARKING DETAILS ==========");
            System.out.println("Vehicle Type      : " + vehicleType);
            System.out.println("Parking Duration  : " + hours + " hours");
            System.out.println("Charged Hours     : " + (int) Math.ceil(hours));
            System.out.println("Hourly Rate       : Rs. " + rate);
            System.out.println("-------------------------------------");
            System.out.println("Total Parking Fee : Rs. " + fee);
            System.out.println("=====================================");

        }
        catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
