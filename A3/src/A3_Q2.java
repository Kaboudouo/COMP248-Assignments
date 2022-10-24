// -------------------------------------------------------
// Assignment 3
// Written by: Noa Chayer 40223439
// For COMP 248 U – Winter 2022
// --------------------------------------------------------

/*
This program returns a list of course names, an average grade, and a letter grade based on the user's inputted courses.
*/

import java.util.Scanner;

public class A3_Q2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("_______****_______****_______****_______****_______\nWelcome To Amazing Student Grade Program!\n_______****_______****_______****_______****_______");
        System.out.println("Please enter the courses you are taking this semester (course|grade and separated by a semicolon):");

        //Empty course list check.
        String user_input = input.nextLine();
        if(user_input.equals("0")){
            System.out.println("\nYou are not taking any courses now!");
            System.out.print("\nThank you for using Amazing Student Courses Grade Program!");
            System.exit(0);
        }

        //Initialization of name and grade arrays of appropriate length to directly set values later.
        String[] courses = user_input.split(";");
        int[] course_grades = new int[courses.length];
        double sum = 0;

        int longest = courses[0].split("\\|")[0].length();
        for (int i =0; i < courses.length; i++){
            //Getting the longest word length to initialize a valid length 2d-character array.
            if (courses[i].split("\\|")[0].length()>longest){
                longest = courses[i].split("\\|")[0].length();
            }
        }

        char[][] char_array_2d = new char[courses.length][longest];
        for (int i=0; i < courses.length; i++){
            //Assignment of 2d character array.
            for(int j=0; j<courses[i].split("\\|")[0].length(); j++){
                char_array_2d[i][j] = courses[i].split("\\|")[0].toCharArray()[j];
            }
            course_grades[i] = Integer.parseInt(courses[i].split("\\|")[1]);
            sum += course_grades[i];
        }

        System.out.println("\nHere is the list of courses you are taking:\n");
        for (int i=0; i< courses.length; i++){
            System.out.print("No."+(i+1)+" ");
            for (int j=0; j<char_array_2d[i].length; j++){
                if (char_array_2d[i][j] != 0){
                    System.out.print(char_array_2d[i][j]);
                }
                else{
                    break;
                }
            }
            System.out.println();
        }

        double average = sum/courses.length;
        String ltr_grade;
        if (average<60){
            ltr_grade = "F";
        }
        else if(average >= 60 && average<67){
            ltr_grade = "D";
        }
        else if(average >= 67 && average<80){
            ltr_grade = "C";
        }
        else if(average >= 80 && average<88){
            ltr_grade = "B";
        }
        else{
            ltr_grade = "A";
        }
        System.out.println("The average of your courses: "+String.format("%.2f", average)+" and the average courses letter grade is: "+ ltr_grade);
        System.out.print("\nThank you for using Amazing Student Courses Grade Program!");
    }
}
