//Author: Daniel Hart
//
//This program will compare two college applicants and
//determine which is the stronger applicant.
//
//Fixes needed: Error catches for bad inputs.
//Possible improvements: Update the program to compare more than two applicants.
//  In the main method, ask the user how many applicants they want to compare.
//  Then make a for loop that creates an applicant double for each number
//  (or should it be an applicant object?). Append each double to an arraylist.
//  Have decision go through the array list to retrieve the highest number.
//  The final output can be "Applicant " + (index # + 1) + " is the best
//  applicant."

package admit;

import java.util.*;

public class Admit {
    
    public static void main(String[] args) {
            intro();
            Scanner console = new Scanner(System.in);
            double applicant1 = overallScore(1, console);
            double applicant2 = overallScore(2, console);
            decision(applicant1, applicant2);
	}
	
	//introduces the program to the user
	public static void intro() {
            System.out.println("This program compares two applicants to");
            System.out.println("determine which one seems like the stronger");
            System.out.println("applicant.  For each candidate I will need");
            System.out.println("either SAT or ACT scores plus a weighted GPA.");
            System.out.println();
	}
	
	//calculates and returns overall score
	public static double overallScore(int appnum, Scanner console) {
            System.out.println("Information for applicant #" + appnum + ":");
            double exam = examScore(console);
            double gpa = getGpa(console);
            double overall = exam + gpa;
            return overall;
	}
	
	//introduces applicant; caluclates and returns exam score
	public static double examScore(Scanner console) {
            double exam = 0;
            for(;;) {
                System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
                int determine = console.nextInt();
                if (determine == 1) {
                    exam = satScore(console);
                    break;
                } else if (determine == 2) {
                    exam = actScore(console);
                    break;
                } else { //any other number
                    System.out.println("    Please choose either 1 or 2.");
                }
            }
            System.out.println("    exam score = " + round2(exam));
            return exam;
	}
	
	//calculates and returns SAT score
	public static double satScore(Scanner console) {
		System.out.print("    SAT math? ");
		int satMath = console.nextInt();
		System.out.print("    SAT critical reading? ");
		int satCr = console.nextInt();
		System.out.print("    SAT writing? ");
		int satWrit = console.nextInt();
		double satScore = (2*satMath + satCr + satWrit)/32.0;
		return satScore;
	}
	
	//calculates and returns ACT score
	public static double actScore(Scanner console) {
		System.out.print("    ACT English? ");
		int actEng = console.nextInt();
		System.out.print("    ACT math? ");
		int actMath = console.nextInt();
		System.out.print("    ACT reading? ");
		int actRead = console.nextInt();
		System.out.print("    ACT science? ");
		int actSci = console.nextInt();
		double actScore = (actEng + 2*actMath + actRead + actSci)/1.8;
		return actScore;
	}
	
	//calculates and returns GPA score
	public static double getGpa(Scanner console) {
		System.out.print("    overall GPA? ");
		double earned = console.nextDouble();
		System.out.print("    max GPA? ");
		double max = console.nextDouble();
		System.out.print("    Transcript Multiplier? ");
		double tm = console.nextDouble();
		double gpa = (earned/max)*100*tm;
		System.out.println("    GPA score = " + round2(gpa));
		System.out.println();
		return gpa;
	}
	
	//compares applicants
	public static void decision(double overall1, double overall2) {
		System.out.println("First applicant overall score  = " + round2(overall1));
		System.out.println("Second applicant overall score = " + round2(overall2));
		if (overall1 > overall2) {
			System.out.println("The first applicant seems to be better");
		} else if (overall1 < overall2) {
			System.out.println("The second applicant seems to be better");
		} else { //overall1 = overall2
			System.out.println("The two applicants seem to be equal");
		}
	}
	
	//rounds n to 2 digits after the decimal point
	public static double round2(double n) {
		return (int) (n * 100.0 + 0.5)/100.0;
	}
    
}
