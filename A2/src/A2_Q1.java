// -------------------------------------------------------
// Assignment 2
// Written by: Noa Chayer 40223439
// For COMP 248 2214-U – Winter 2022
// --------------------------------------------------------

/*
This program displays a list of COVID-19 symptoms and their associated symptom code. The program then prompts the user
for a symptom code and prints the associated symptom category and advice note.
*/

import java.util.Scanner;

public class A2_Q1 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        //Storing symptoms and advices in string arrays for ease of access.
        String[] symptoms = {"Fever", "Cough", "Tiredness", "Loss of Taste and/or Smell", "Sore Throat", "Headache", "Body Aches and/or Pains", "Diarrhoea", "Skin Rash", "Fingers/Toes Discoloration", "Red and/or Irritated Eyes", "Shortness of Breath", "Confusion and/or Loss of Speech", "Chest Pains"};
        String[] advice_notes ={"You are experiencing a common symptom with regard to either COVID-19 or a respiratory infection (e.g. flu).\nKindly isolate yourself as soon as possible, and endeavor to perform a PCR (Polymerase Chain Reaction) test to confirm your COVID-19 status.",
                                "You are experiencing a CRITICAL/SEVERE symptom with regard to either COVID-19 or a respiratory infection (e.g. flu).\nKindly isolate yourself as soon as possible and call 911, immediately.",
                                "You are currently experiencing no observable symptom with regard to either COVID-19 or a respiratory infection (e.g. flu).\nAlthough, you may be asymptomatic. Thus, kindly adhere to all the COVID-19 safety regulations within your city and province."};

        System.out.println("Welcome to the Amazing COVID-19 Diagnostics Expert System:\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nSymptom Code => Symptom Description\n-----------------------------------");

        for(int i=0; i < symptoms.length; i++){
            System.out.println(i+10 + " => "+symptoms[i]);
        }

        System.out.print("\nPlease enter the Symptom Code, from the aforementioned, that corresponds to your current health symptoms: ");
        int answer = input.nextInt();

        //Checking if input is valid before going through the main condition filters.
        if(answer<-128 || answer>127){
            System.out.println("ERROR: Your input/entry is not a valid integer between -128 to 127. Kindly try again!");
            System.exit(0);
        }
        else if(answer>=10 && answer<=13){
            System.out.println("Symptom Status: MOST COMMON SYMPTOM");
            System.out.println(advice_notes[0]);
        }
        else if(answer>=13 && answer<=20){
            System.out.println("Symptom Status: LESS COMMON SYMPTOM");
            System.out.println(advice_notes[0]);
        }
        else if(answer>=21 && answer<=23){
            System.out.println("Symptom Status: CRITICAL SYMPTOM");
            System.out.println(advice_notes[1]);
        }
        else{
            System.out.println("Symptom Status: NO OBVIOUS SYMPTOM");
            System.out.println(advice_notes[2]);
        }
        System.out.println("\nThank you! Please stay safe and healthy.");
    }
}
