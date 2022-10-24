// -------------------------------------------------------
// Assignment 4
// Written by: Noa Chayer 40223439
// For COMP 248 Section U – Winter 2022
// --------------------------------------------------------

/*
The purpose of this program is to provide the user a class management system, where the user can create a new class with
all the relevant information. In that class, the user can add, remove, and modify student information, and attribute and
modify student's grades for a term's work (assignments, labs, and exams). Additionally, the program will calculate a
weighted average for any student's work term and return a final score and letter grade. Finally, the use can decide to
generate both an individual student's report card or the whole class', which provides information such as the minimum,
maximum, and average score for every category of term work, along with every student's grades and information.
 */

import java.util.Scanner;

class Comp248secU{
    private static String instructorFname;
    private static String instructorLname;
    private static String lectureRoom;
    private static String semesterYear;
    private static int classSize;

    private String[] studFname;
    private String[] studLname;
    private int[] studID;

    private double[] assgt1;
    private double[] assgt2;
    private double[] assgt3;
    private double[] assgt4;
    private double[] labs;
    private double[] midTerm;
    private double[] finalExam;

    public Comp248secU(String fname, String lname, String room, String semYr, int size){
        instructorFname = fname;
        instructorLname = lname;
        lectureRoom = room;
        semesterYear = semYr;
        classSize = size;

        //Every array is instantiated with a size of value classSize, since that is its maximum possible size.
        studFname = new String[classSize];
        studLname = new String[classSize];
        studID = new int[classSize];

        assgt1 = new double[classSize];
        assgt2 = new double[classSize];
        assgt3 = new double[classSize];
        assgt4 = new double[classSize];
        labs = new double[classSize];
        midTerm = new double[classSize];
        finalExam = new double[classSize];
    }

    public void addStudent(String fname, String lname, int studID_int, int arrIdx){
        studFname[arrIdx] = fname;
        studLname[arrIdx] = lname;
        studID[arrIdx] = studID_int;

        System.out.println("Student with ID: " + studID_int + " added successfully.");
    }

    //Individually looks through every studentID to return its position.
    public int getStudentIdx(int studID_int){
        for(int i=0; i<studID.length; i++){
            if (studID[i] == studID_int){
                return i;
            }
        }
        System.out.println("Student with ID: " + studID_int + " does NOT exist.");
        return -1;
    }

    //Student info is gathered and returned as an array of strings to be accessed by driver class.
    public String[] getStudentInfo(int studID){
        String[] student_Info = new String[10];

        int idx = getStudentIdx(studID);
        if (idx == -1){
            System.out.println("Unable to retrieve information for Student with ID: " + studID);
            return null;
        }
        student_Info[0] = studFname[idx];
        student_Info[1] = studLname[idx];
        student_Info[2] = String.valueOf(studID);
        student_Info[3] = String.valueOf(assgt1[idx]);
        student_Info[4] = String.valueOf(assgt2[idx]);
        student_Info[5] = String.valueOf(assgt3[idx]);
        student_Info[6] = String.valueOf(assgt4[idx]);
        student_Info[7] = String.valueOf(labs[idx]);
        student_Info[8] = String.valueOf(midTerm[idx]);
        student_Info[9] = String.valueOf(finalExam[idx]);

        return student_Info;
    }

    public int delStudent(int studID_int) {
        int idx = getStudentIdx(studID_int);
        if (idx == -1) {
            System.out.println("Unable to retrieve information for Student with ID: " + studID_int);
            return 0;
        } else {
            //A temporary array is created for every of its corresponding attributes.
            int[] temp_ID = new int[classSize];
            String[] temp_Fname = new String[classSize];
            String[] temp_Lname = new String[classSize];
            double[] temp_a1 = new double[classSize];
            double[] temp_a2 = new double[classSize];
            double[] temp_a3 = new double[classSize];
            double[] temp_a4 = new double[classSize];
            double[] temp_labs = new double[classSize];
            double[] temp_mid = new double[classSize];
            double[] temp_final = new double[classSize];

            //Here 'j' and 'i' increment together unless 'i' is equal to the index of the student that we wish to remove.
            //We thus avoid copying its elements into the temporary arrays, effectively removing the student from the class.
            int j = 0;
            for (int i=0; i<classSize; i++){
                if (i != idx){
                    temp_ID[j] = studID[i];
                    temp_Fname[j] = studFname[i];
                    temp_Lname[j] = studLname[i];
                    temp_a1[j] = assgt1[i];
                    temp_a2[j] = assgt2[i];
                    temp_a3[j] = assgt3[i];
                    temp_a4[j] = assgt4[i];
                    temp_labs[j] = labs[i];
                    temp_mid[j] = midTerm[i];
                    temp_final[j] = finalExam[i];
                    j++;
                }
            }

            //We then recopy the values of the temporary arrays in to the 'real' arrays, which will no longer have the student.
            studID = temp_ID;
            studFname = temp_Fname;
            studLname = temp_Lname;
            assgt1 = temp_a1;
            assgt2 = temp_a2;
            assgt3 = temp_a3;
            assgt4 = temp_a4;
            labs = temp_labs;
            midTerm = temp_mid;
            finalExam = temp_final;

            System.out.println("Successfully remove Student with ID: " + studID_int);
            return 1;
        }
    }

    //Next three methods are straight-forward, the given values are inserted into the wanted variables.
    public int updateStudentPart (String fname, String lname, int studID_int){
        int idx = getStudentIdx(studID_int);
        if (idx == -1) {
            System.out.println("Unable to retrieve information for Student with ID: " + studID_int);
            return 0;
        } else {
            studFname[idx] = fname;
            studLname[idx] = lname;
            System.out.println("Successfully updated identification particulars for Student with ID: " + studID_int);
            return 1;
        }
    }

    public int updateAssgtScore (double a1, double a2, double a3, double a4, int studID_int){
        int idx = getStudentIdx(studID_int);
        if (idx == -1) {
            System.out.println("Unable to retrieve information for Student with ID: " + studID_int);
            return 0;
        } else {
            assgt1[idx] = a1;
            assgt2[idx] = a2;
            assgt3[idx] = a3;
            assgt4[idx] = a4;
            System.out.println("Successfully updated Assignment's scores for Student with ID: " + studID_int);
            return 1;
        }
    }

    public int updateOtherScore (double lab, double test, double exam, int studID_int){
        int idx = getStudentIdx(studID_int);
        if (idx == -1) {
            System.out.println("Unable to retrieve information for Student with ID: " + studID_int);
            return 0;
        } else {
            labs[idx] = lab;
            midTerm[idx] = test;
            finalExam[idx] = exam;
            System.out.println("Successfully updated Cumulative Labs, Mid-Term Test, and Final Examination scores for Student with ID: " + studID_int);
            return 1;
        }
    }

    public double computeWeightScore(int studID){
        int idx = getStudentIdx(studID);
        if (idx == -1) {
            System.out.println("Unable to retrieve information for Student with ID: " + studID);
            return -1;
        }
        else{
            //Weighted average formula (Grade/MaxGrade)*weight for every term work.
            return ((assgt1[idx]/20)*2)+((assgt2[idx]/20)*3)+((assgt3[idx]/20)*5)+((assgt4[idx]/20)*8)+((labs[idx]/12)*12)+((midTerm[idx]/30)*30)+((finalExam[idx]/40)*40);
        }
    }

    public static char computeGrade (double wgtScore){
        if (wgtScore>=88){
            return 'A';
        }
        else if (wgtScore>=80){
            return 'B';
        }
        else if (wgtScore >= 67){
            return 'C';
        }
        else if (wgtScore >= 60){
            return 'D';
        }
        else{
            return 'F';
        }
    }

    //Checks every value of dataArr and compares it to the 'min' variable, which is set to the first element by default.
    public static double findMin(double[] dataArr){
        double min = dataArr[0];
        for (int i=1; i<dataArr.length; i++){
            if (dataArr[i] < min){
                min = dataArr[i];
            }
        }
        return min;
    }

    //Same principle
    public static double findMax(double[] dataArr){
        double max = dataArr[0];
        for (int i=1; i<dataArr.length; i++){
            if (dataArr[i] > max){
                max = dataArr[i];
            }
        }
        return max;
    }

    public static double findAvg(double[] dataArr){
        double sum = 0;
        for (double value : dataArr) {
            sum += value;
        }
        return sum/dataArr.length;
    }

    public double[] getClassMin(){
        double[] class_min = new double[7];
        class_min[0] = findMin(assgt1);
        class_min[1] = findMin(assgt2);
        class_min[2] = findMin(assgt3);
        class_min[3] = findMin(assgt4);
        class_min[4] = findMin(labs);
        class_min[5] = findMin(midTerm);
        class_min[6] = findMin(finalExam);

        return class_min;
    }

    public double[] getClassMax(){
        double[] class_max = new double[7];
        class_max[0] = findMax(assgt1);
        class_max[1] = findMax(assgt2);
        class_max[2] = findMax(assgt3);
        class_max[3] = findMax(assgt4);
        class_max[4] = findMax(labs);
        class_max[5] = findMax(midTerm);
        class_max[6] = findMax(finalExam);

        return class_max;
    }

    public double[] getClassAvg(){
        double[] class_avg = new double[7];
        class_avg[0] = findAvg(assgt1);
        class_avg[1] = findAvg(assgt2);
        class_avg[2] = findAvg(assgt3);
        class_avg[3] = findAvg(assgt4);
        class_avg[4] = findAvg(labs);
        class_avg[5] = findAvg(midTerm);
        class_avg[6] = findAvg(finalExam);

        return class_avg;
    }

    public void classReportCard(){
        double[] classMin = getClassMin();
        double[] classMax = getClassMax();
        double[] classAvg = getClassAvg();

        //Easier to draw
        String line = new String(new char[100]).replace("\0", "-");

        //Counts the amount of actual students in the class as to avoid printing empty lines.
        int n_student = 0;
        for (int id : studID){
            if (id == 0){
                break;
            }
            n_student += 1;
        }

        System.out.println(line + "\nFirst Name      Last Name       Stud. ID     A1     A2     A3     A4   Labs   Test   Exam    Wgt.  *\n" + line);
        double[][] term_work = {assgt1, assgt2, assgt3, assgt4, labs, midTerm, finalExam};

        //Spacing between values in the report card is calculated to align everything correctly.
        //space() method at line 371
        int spacing;
        for (int i=0; i<n_student; i++){
            double weighted_grade = computeWeightScore(studID[i]);
            spacing = 16 - studFname[i].length();
            System.out.print(studFname[i]); space(spacing);

            spacing = 16 - studLname[i].length();
            System.out.print(studLname[i]); space(spacing);

            System.out.print(studID[i]); space(2);

            //This block is just to ensure that if a grade is <10, the indentation will adapt to keep things aligned.
            for (int j=0; j<term_work.length; j++){
                //Calculates needed amount of spaces to keep drawing aligned.
                spacing = 5 - String.format("%.2f", term_work[j][i]).length();
                space(spacing);
                if (j == term_work.length - 1){
                    System.out.printf("%.2f", term_work[j][i]); space(3);
                }
                else{
                    System.out.printf("%.2f", term_work[j][i]); space(2);
                }
            }
            spacing = 5 - String.format("%.2f", weighted_grade).length(); space(spacing);
            System.out.printf("%.2f", weighted_grade); space(2);
            System.out.println(computeGrade(weighted_grade));
        }

        System.out.println(line);
        space(16); System.out.print("Minimum Score in Class:"); space(3);
        for (double score: classMin){
            //Same alignment calculation
            spacing = 5 - String.format("%.2f", score).length();
            space(spacing);
            System.out.printf("%.2f", score); space(2);
        }

        System.out.print("\n"); space(16); System.out.print("Average Score in Class:"); space(3);
        for (double score: classAvg){
            spacing = 5 - String.format("%.2f", score).length();
            space(spacing);
            System.out.printf("%.2f", score); space(2);
        }

        System.out.print("\n"); space(16); System.out.print("Maximum Score in Class:"); space(3);
        for (double score: classMax){
            spacing = 5 - String.format("%.2f", score).length();
            space(spacing);
            System.out.printf("%.2f", score); space(2);
        }
        System.out.println("\n" + line);
    }

    //Easier to write space(n spaces) than System.out.print("     "), especially when drawing.
    public void space(int n){
        for (int i=0; i<n; i++){
            System.out.print(" ");
        }
    }
}


public class A4_Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int array_indexer = 0;
        String[] code_Descriptions = {"Enrol New Student", "Find Student Position in Class List", "Retrieve Student's Information", "Unenrol Student", "Update Student's Particulars", "Update Assignment Scores", "Update Other Scores", "Display Student's Report CArd", "Display Class Report Card", "Exit"};

        System.out.println("Welcome to the Amazing Classroom Management System:\n+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nEnter instructor's particulars (FirstName, LastNAme, LectureRoom, Semester, MaxClassSize) as a single-line entry:");

        //Since these variables never get referenced, I decided to assign them all in one line as they are not important.
        String firstName = input.next(); String lastName = input.next(); String lectureRoom = input.next(); String semester = input.next();

        //Valid class size check (The .hasNextInput() method is used for every check)
        int classSize = 0;
        if (input.hasNextInt()){
            classSize = input.nextInt();
        }
        else{
            System.out.println("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
            System.exit(0);
        }

        Comp248secU comp_class = new Comp248secU(firstName, lastName, lectureRoom, semester, classSize);

        //Every code follows 103+i*3 except the last code, being 0. Draws code list.
        System.out.println("\nCode => Description\n-------------------");
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                System.out.println("0 ===> " + code_Descriptions[i]);
            } else {
                System.out.println((103 + i * 3) + " => " + code_Descriptions[i]);
            }
        }
        System.out.print("\nPlease enter a Code, from the aforementioned, that corresponds to your task: ");

        //The while loop ensures that the user is prompt with entering another code upon completion of an action.
        while (true) {
            int code_answer = input.nextInt();
            if (code_answer < -128 || code_answer > 127) {
                System.out.println("ERROR: Your input/entry is not a valid integer between -128 to 127. Kindly try again!");
                System.exit(0);
            } else if (code_answer == 103) {
                System.out.println("\n\nEnrolling New Student...\n------------------------");
                System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
                String fname = input.next();
                String lname = input.next();
                if (input.hasNextInt()) {
                    //Full class check
                    if (array_indexer == classSize){
                        System.out.println("Student with ID: " + input.nextInt() + " CANNOT be added. Class is already full.");
                    }
                    else{
                        comp_class.addStudent(fname, lname, input.nextInt(), array_indexer);
                        array_indexer += 1;
                    }
                } else {
                    input.next();
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                }
            } else if (code_answer == 106) {
                System.out.println("\nFinding Student's Position in Class List...\n-------------------------------------------");
                System.out.println("Enter StudentID: ");
                if (input.hasNextInt()) {
                    //-1 is the default return value if no student with a given ID is found.
                    int id_answer = input.nextInt();
                    int idx = comp_class.getStudentIdx(id_answer);
                    if (idx != -1) {
                        System.out.println("The position of student with ID: " + id_answer + ", in the class list, is: " + idx);
                    }
                }
                else {
                    input.next();
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                }
            } else if (code_answer == 109){
                System.out.println("Retrieving Student's Information...\n-----------------------------------");
                System.out.println("Enter StudentID:");
                String[] info = comp_class.getStudentInfo(input.nextInt());
                if (info != null){
                    System.out.println("Student's First Name = " + info[0]);
                    System.out.println("Student's Last Name = " + info[1]);
                    System.out.println("Student's ID = " + info[2]);
                    System.out.println("Score in Assignment 1 = " + info[3]);
                    System.out.println("Score in Assignment 2 = " + info[4]);
                    System.out.println("Score in Assignment 3 = " + info[5]);
                    System.out.println("Score in Assignment 4 = " + info[6]);
                    System.out.println("Cumulative Score in Labs = " + info[7]);
                    System.out.println("Mid-term Test Score = " + info[8]);
                    System.out.println("Final Examination Score = " + info[9]);
                }
            } else if (code_answer == 112){
                System.out.println("\nUnenrolling Student...\n----------------------");
                System.out.println("Enter StudentID:");
                //If deletion is successful, indexer is decremented as to not leave a null space when further adding students.
                if (comp_class.delStudent(input.nextInt()) == 1){
                    array_indexer -= 1;
                }
            } else if (code_answer == 115){
                System.out.println("\nUpdating Student's Particulars...\n---------------------------------");
                System.out.println("Enter update to student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
                String updatedfname = input.next();
                String updatedlname = input.next();
                if (input.hasNextInt()){
                    comp_class.updateStudentPart(updatedfname, updatedlname, input.nextInt());
                }
                else{
                    input.next();
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                }
            } else if (code_answer == 118){
                System.out.println("\nUpdating Assignment Scores...\n-----------------------------");
                System.out.println("Enter update to student's Assignment scores (Assignment1, Assignment2, Assignment3, Assignment4, StudentID) as a single-line entry:");
                int a1 = input.nextInt();
                int a2 = input.nextInt();
                int a3 = input.nextInt();
                int a4 = input.nextInt();
                if (input.hasNextInt()){
                    comp_class.updateAssgtScore(a1, a2, a3, a4, input.nextInt());
                }
                else{
                    input.next();
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                }
            }  else if (code_answer == 121){
                System.out.println("\nUpdating Other Scores...\n------------------------");
                System.out.println("Enter update to student's other scores (CumulativeLabs, MidTerm, FinalEXam, StudentID) as a single-line entry:");
                int lab = input.nextInt();
                int mid = input.nextInt();
                int last = input.nextInt();
                if (input.hasNextInt()){
                    comp_class.updateOtherScore(lab, mid, last, input.nextInt());
                }
                else{
                    input.next();
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                }
            } else if (code_answer == 124){
                System.out.println("Displaying Student's Report Card...\n-----------------------------------");
                System.out.println("Enter StudentID:");
                if (input.hasNextInt()){
                    int id = input.nextInt();
                    String[] info = comp_class.getStudentInfo(id);
                    if (info != null){
                        System.out.println("Student's First Name = " + info[0]);
                        System.out.println("Student's Last Name = " + info[1]);
                        System.out.println("Student's ID = " + info[2]);
                        System.out.println("Score in Assignment 1 = " + info[3]);
                        System.out.println("Score in Assignment 2 = " + info[4]);
                        System.out.println("Score in Assignment 3 = " + info[5]);
                        System.out.println("Score in Assignment 4 = " + info[6]);
                        System.out.println("Cumulative Score in Labs = " + info[7]);
                        System.out.println("Mid-term Test Score = " + info[8]);
                        System.out.println("Final Examination Score = " + info[9]);
                        System.out.println("-----------------------------------------");

                        double final_score = comp_class.computeWeightScore(id);
                        System.out.println("Student's Cumulative Weighted Score = " + final_score);
                        System.out.println("Student's Final Letter Grade = " + Comp248secU.computeGrade(final_score));
                    }
                }
                else{
                    input.next();
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                }
            } else if (code_answer == 127){
                System.out.println("\n\n\nDisplaying Class Report Card...\n-------------------------------");
                comp_class.classReportCard();
            } else if (code_answer == 0){
                System.out.println("Thank you for using the Amazing Classroom Management System! See you next time...");
                System.exit(0);
            }
            else{
                System.out.println("Thank you for patronizing our Amazing Classroom Management System.");
                System.exit(0);
            }
            System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
        }
    }
}