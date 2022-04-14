import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Gradebook {
	private Student[] students;
	private double[] possibleScores;
	
	public Gradebook(int numStudents, int numGrades, String inFile) throws FileNotFoundException {
		students = new Student[numStudents];
		possibleScores = new double[numGrades];
		Scanner fScan = new Scanner(new File(inFile));
		double totalPoints = 0;
		String tempName;
		double[] tempAr = new double[numGrades];
		
		while(fScan.hasNextLine()) {
			fScan.next();
			for(int i = 0; i < numGrades; i++) {
				possibleScores[i] = fScan.nextDouble();
			}
			
			for(int i = 0; i < possibleScores.length; i++) {
				totalPoints += possibleScores[i];
			}
			
			for(int i = 0; i < numStudents; i++) {
				tempName = fScan.next();
				for(int j = 0; j < numGrades; j++) {
					tempAr[j] = fScan.nextDouble();
				}
				students[i] = new Student(tempName, tempAr, totalPoints);
			}
		}
		
		fScan.close();
	}
	
	public double[] findAssignmentAverages() {
		double[] average = new double[possibleScores.length];
		double temp = 0;
		for(int i = 0; i < average.length; i++) {
			temp = 0;
			for(int j = 0; j < students.length; j++) {
				temp += students[j].getScores()[i]; 
			}
			average[i] = (temp/students.length) / possibleScores[i];
		}
		return average;
	}
	
	public double[] findStudentAverages() {
		double[] studentAverages = new double[students.length];
		for(int i = 0; i < students.length; i++) {
			studentAverages[i] = students[i].getGrade()/100;
		}
		return studentAverages;
	}
	
	public Student findTopStudent() {
		double max = 0;
		int maxIndex = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].getGrade() > max) {
				max = students[i].getGrade();
				maxIndex = i;
			}
		}
		return students[maxIndex];
	}
	
	public Student findStrugglingStudent() {
		double min = students[0].getGrade();
		int minIndex = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].getGrade() < min) {
				min = students[i].getGrade();
				minIndex = i;
			}
		}
		return students[minIndex];
	}
	
	public Student findTopStudentForAssignment(int assignmentNum) {
		double max = 0;
		int maxIndex = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].getScores()[assignmentNum] > max) {
				max = students[i].getScores()[assignmentNum];
				maxIndex = i;
			}
		}
		return students[maxIndex];
	}
	
	public Student findStrugglingStudentForAssignment(int assignmentNum) {
		double min = students[0].getScores()[assignmentNum];
		int minIndex = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].getScores()[assignmentNum] < min) {
				min = students[i].getScores()[assignmentNum];
				minIndex = i;
			}
		}
		return students[minIndex];
	}
	
	public Student[] getStudentArray() {
		return students;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < students.length; i++) {
			str += students[i].toString() + "\n";
		}
		return str;
	}
}
