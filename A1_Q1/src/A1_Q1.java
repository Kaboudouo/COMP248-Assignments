// -------------------------------------------------------------------------------
// Assignment 1
// Written by: Noa Chayer 40223439
// For COMP 248 Section 2214 – Winter 2022
// ---------------------------------------------------------------------------------

/*
Written by Noa Chayer, submitted on 16/01/22:
This program is made to calculate an approximate caloric expenditure based on a person's weight and predefined activities'
durations. The time values for each activity is scanned and stored in an array. This array is passed through a function designed to
calculate the caloric expenditure and return them under the form of another array. Sum is evaluated and results are printed.
*/

import java.util.Scanner;

public class A1_Q1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Weight input
        System.out.print("Welcome to Crazy Calorie Calculator!\n_______________________\nPlease enter your weight in pounds: ");
        double weight_value_kg = input.nextInt() / 2.2; //Input is immediately adjusted from lbs to kg.

        //Time inputs
        System.out.print("Please enter your running time (minutes): ");
        double run_time = input.nextDouble();
        System.out.print("Please enter your walking time (minutes): ");
        double walk_time = input.nextDouble();
        System.out.print("Please enter your mountain climbing time (minutes): ");
        double climb_time = input.nextDouble();
        double[] time_values = {run_time, walk_time, climb_time};

        //Declared results array based on function's returned array
        double[] burned_Calories = calculate_Expenditure(weight_value_kg, time_values);

        //Sum of calories
        double sum = 0;
        for (int i = 0; i<=2; i++){
            sum += burned_Calories[i];
        }

        System.out.println("\nYou burned approximately "+ String.format("%.2f",burned_Calories[0]) + " calories running, "+ String.format("%.2f",burned_Calories[1]) + " calories walking, and " + String.format("%.2f",burned_Calories[2]) + " calories mountain climbing.");
        System.out.println("All of that for a total of "+ String.format("%.2f", sum) + " calories!");
        System.out.println("That was a hard workout! Keep it up! Till next time...");
    }

    public static double[] calculate_Expenditure(double weight, double[] time_array){
        //Declaration of METs constants array for ease of access.
        int[] mets = {10, 4, 8};

        //Loop evaluates caloric expenditure.
        double[] burned_Calories = new double[3];
        for (int i=0; i<=2; i++){
            burned_Calories[i] = weight*0.0175*mets[i]*time_array[i];
        }
        return burned_Calories;
    }
}
