public class Student {
	private String name = "";
	private double[] scores;
	private double grade;
	
	public Student(String nm, double[] scoresList, double totalPoints) {
		double totalScore = 0;
		scores = new double[scoresList.length];
		name = nm;
		for(int i = 0; i < scoresList.length; i++) {
			scores[i] = scoresList[i];
		}
		for(int i = 0; i < scoresList.length; i++) {
			totalScore += scoresList[i];
		}
		grade = totalScore/totalPoints * 100;
	}
	
	public String toString() {
		return"Name: " + name + "    Grade: " + ((int)((grade * 100) + 0.5)) /100.0 + "%";
	}
	
	public void newName(String nm) {
		name = nm;
	}
	
	public String getName() {
		return name;
	}
	
	public double[] getScores() {
		return scores;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public static void main(String[] args)
	{
		double[] grades = {10, 9.5, 10, 8};
		Student me = new Student("Prosser", grades, 40);
		System.out.println(me);
	}
}
