package psd3Sprint1;

import java.util.ArrayList;

public class Student {
	private CharSequence studentId;
	private String studentName;
	private char assignment1grade;
	private char assignment2grade;
	
	
	public Student(){
		
	}
	
	public Student(CharSequence i, String studentName, char assignment1grade, char assignment2grade){
		this.studentId = i;
		this.studentName = studentName;
		this.assignment1grade = assignment1grade;
		this.assignment2grade =assignment2grade;
	}
	
	/*******GETTER SETTERS**********/
	public CharSequence getStudentId() {
		return studentId;
	}
	public void setStudentId(CharSequence studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public char getAssignment1grade() {
		return assignment1grade;
	}
	public void setAssignment1grade(char assignment1grade) {
		this.assignment1grade = assignment1grade;
	}
	public char getAssignment2grade() {
		return assignment2grade;
	}
	public void setAssignment2grade(char assignment2grade) {
		this.assignment2grade = assignment2grade;
	}
	/*********************************************/
	
}
