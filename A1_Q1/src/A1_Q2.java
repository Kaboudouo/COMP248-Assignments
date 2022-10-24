// -------------------------------------------------------------------------------
// Assignment 1
// Written by: Noa Chayer 40223439
// For COMP 248 Section 2214 – Winter 2022
// ---------------------------------------------------------------------------------

/*
Written by Noa Chayer, submitted on 16/01/22:
This program calculates general asset depreciation information on an annual scale based on the inputted price,
salvage value, and years of use. These values are scanned and stored in an array. Wanted information is calculated
using that array and results are printed.
*/

import java.util.Scanner;

public class A1_Q2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Asset values input
        System.out.println("Welcome to the amazing asset depreciation tool.\n_______________________");
        System.out.println("Please enter values (Price, Salvage value, and years used) respectively and spaced: ");

        double[] asset_values = {input.nextDouble(), input.nextDouble(), input.nextDouble()};

        //Wanted information calculations
        double yrly_deprec = (asset_values[0] - asset_values[1])/asset_values[2];
        double perc_yrly_deprec = (yrly_deprec/asset_values[0])*100;
        double half_price_years = 50/perc_yrly_deprec;

        System.out.println("Yearly depreciation = $" + String.format("%.2f", yrly_deprec));
        System.out.println("Yearly depreciation % = " + String.format("%.2f", perc_yrly_deprec) + "%");
        System.out.println("Time before salvage value becomes 50% of purchase price = " + String.format("%.2f", half_price_years) + " years");

        System.out.println("\nThank you for using our amazing asset depreciation tool!\nTill next time..." );
    }
}
