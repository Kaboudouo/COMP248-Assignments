// -------------------------------------------------------
// Assignment 2
// Written by: Noa Chayer 40223439
// For COMP 248 2214-U – Winter 2022
// --------------------------------------------------------

/*
This program returns a learning function value (result of an empirical formula) based on the user's date and time input.
*/

import java.util.Scanner;
public class A2_Q2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] valid_strings = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "day-light", "night-time"};

        System.out.println("Welcome to the Amazing Machine-Learning Function Program:\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("\nPlease enter a Weekday and Time, respectively: ");
        String date = input.next().toLowerCase();
        String time = input.next().toLowerCase();

        //Validity check
        boolean valid_date = false;
        boolean valid_time = false;
        for(int i = 0; i < 9; i++){
            if(i < 7 && !valid_date){
                valid_date = date.equals(valid_strings[i]);
            }
            else if(!valid_time){
                valid_time = time.equals(valid_strings[i]);
            }
        }

        //Adaptive error message
        if(!valid_time || !valid_date) {
            if(valid_date){
                System.out.println("Error: An invalid value has been entered for the 'Time' variable. Kindly try again!");
            }
            else if(valid_time){
                System.out.println("Error: An invalid value has been entered for the 'Weekday' variable. Kindly try again!");
            }
            else{
                System.out.println("Error: An invalid value has been entered for both the 'Weekday' and 'Time' variable. Kindly try again!");
            }
            System.exit(0);
        }

        //Main control flow
        double y_value = 0;
        switch(time) {
            case "night-time":
                switch (date) {
                    case "monday" -> y_value = 3.25;
                    case "tuesday" -> y_value = 2.99;
                    case "wednesday" -> y_value = 3.99;
                    case "thursday" -> y_value = 2.68;
                    case "friday" -> y_value = 3.73;
                    case "saturday" -> y_value = 2.86;
                    case "sunday" -> y_value = 2.59;
                }
                break;
            case "day-light":
                switch (date) {
                    case "monday" -> y_value = 2.53;
                    case "tuesday" -> y_value = 3.15;
                    case "wednesday" -> y_value = 3.00;
                    case "thursday" -> y_value = 2.41;
                    case "friday" -> y_value = 1.99;
                    case "saturday" -> y_value = 3.59;
                    case "sunday" -> y_value = 2.00;
                }
                break;
        }

        //Empirical formula
        double omega = 0.567143;
        double z_value = Math.round(y_value * omega * 100.0)/100.0;

        System.out.println("\nValue of the prototype Learning Function, Z, is: "+z_value);
        System.out.println("Thank you for contributing to this Machine Learning project!");
    }
}
