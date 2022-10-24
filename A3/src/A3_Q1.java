// -------------------------------------------------------
// Assignment 3
// Written by: Noa Chayer 40223439
// For COMP 248 U – Winter 2022
// --------------------------------------------------------

/*
Using an inputted sentence, this program returns the number of words, along with various data regarding the aforementioned.
*/

import java.util.Scanner;

public class A3_Q1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("_______****_______****_______****_______****_______\nWelcome To The AMAZING SENTENCE SCAN PROGRAM!\n_______****_______****_______****_______****_______");
        System.out.println("Please enter the sentence to scan:");

        String sentence = input.nextLine();
        String[] words = sentence.split(" ");

        System.out.println("\n\nHere are some data about your sentence:\n");

        int shortest = words[0].length();
        int longest = words[0].length();
        double sum = 0;

        for(int i=0; i<words.length; i++){
            //Checks if current word in iteration is the last word to quantitatively remove end punctuation (. ! ?).
            if(i != words.length-1){
                System.out.println("Word "+(i+1)+" has "+words[i].length()+" characters.");
            }
            else{
                System.out.println("Word "+(i+1)+" has "+(words[i].length()-1)+" characters.");
            }

            //Checks word length to count longest and shortest word. Same 'last word' check as before.
            sum += words[i].length();
            if(words[i].length() > longest){
                longest = words[i].length();
                if (i == words.length-1){
                    longest-=1;
                }
            }
            else if(words[i].length() < shortest){
                shortest = words[i].length();
                if (i == words.length-1){
                    shortest-=1;
                }
            }
        }
        double average = (sum-1)/words.length;

        System.out.println("\n\nThere are "+words.length+" words.");
        System.out.println("The longest word has "+longest+" characters.");
        System.out.println("The shortest word has "+shortest+" characters.");
        System.out.print("The average word length is "+average+" characters.\nThank you for using The AMAZING SENTENCE SCAN PROGRAM!");
    }
}
