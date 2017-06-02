package data;

public class Student {
	private long studentId;
	private String studentName;
	private int score1;
	private int score2;
	private int totalScore;
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public Student(long studentId,String studentName,int score1,int score2){
		this.studentId = studentId;
		this.studentName = studentName;
		this.score1 = score1;
		this.score2 = score2;
		this.totalScore = score1 + score2;
	}
}
