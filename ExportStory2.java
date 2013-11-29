package psd3Sprint1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ExportStory2 {

	ArrayList<Course> arrayofcourse = new ArrayList<Course>();
	
	public void printFunc() throws IOException{
		
		System.out.println("===============Please select an option by entering the number:============");
		/*1*/System.out.println("[1] Export all grades of a student");//select student after this
		/*2*/System.out.println("[2] Export all student grades for all completed assignments from a course");//select course after this
		/*3*/System.out.println("[3] Go back to main menu");
		System.out.println("==========================================================================");
		
		Scanner sc = new Scanner(System.in);
		int val = sc.nextInt();
		
		
		if(val==1){
			//Export all grades of a student, select student
			
			exportAllGrade();
			
		}
		else if(val==2){
			//call method to Export all student's grade for all assignment, select course
			
			exportAllAssignmentGrade();
			
		}
		
		else if(val==3){
			//should go back to main function	
			justforfun();
			
			
		}
		 else{
			 System.out.println("");System.out.println(""); System.out.println("");System.out.println("");
			 printFunc();
		 }
		sc.close();
	}
	

	
	
	
	
	
	//1
	private void exportAllGrade() throws IOException{
	
		System.out.println("");
		System.out.println("<<Export all grades of a student>>");
		System.out.println("=======================PLEASE SELECT A STUDENT TO EXPORT GRADE=============================");
		int i = 0;
		String name;
		Set<String> nodupe = new LinkedHashSet<String>();
		for(Course c:arrayofcourse){
			for(int k=0; k < c.getAllstudentgradelist().size(); k++){
				Student stu = c.getAllstudentgradelist(k);
					name = stu.getStudentName();
					
					nodupe.add(name);
			}
		}
			
		ArrayList<String> allnames = new ArrayList<String>(nodupe);//list of names
		for(String s:allnames){
			System.out.println("["+(++i)+"] "+ s);
		}
		
			System.out.println("["+(++i)+"] Back to export menu");
			System.out.println("==========================================================================");
			
			
			
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){		
				int val = sc.nextInt();
	
				if(val==i){ 
					printFunc(); 
					}
	
					else if(val>allnames.size() || val<0){
						
						exportAllGrade();
					}
						else{
							String studentname = allnames.get(val-1);
							String outputFileName= studentname+"_course grade.csv";
							System.out.println(studentname);
							//loop all course
							//get the value of the student
							//wirte to writer
							try
							{

							FileWriter writer = new FileWriter(outputFileName);
							writer.append("Student_Name");
							writer.append(',');
							writer.append("Studen_ID");
							writer.append(',');
							writer.append("Course_Name");
							writer.append(',');
							writer.append("Assignment_1");
							writer.append(',');
							writer.append("Assignment_2");
							writer.append('\n');
							
							for(Course c:arrayofcourse){
								for(int k=0; k < c.getAllstudentgradelist().size(); k++){
									Student stu = c.getAllstudentgradelist(k);
									if(stu.getStudentName().compareTo(studentname)==0){
										writer.append(stu.getStudentName());
										writer.append(',');
										writer.append(stu.getStudentId());
										writer.append(',');
										writer.append(c.getCoursename());
										writer.append(',');
										writer.append(stu.getAssignment1grade());
										writer.append(',');
										writer.append(stu.getAssignment2grade());
										writer.append('\n');
									}
								}
								}
								
    
					
							System.out.println("##########################################");
							System.out.println("# Exported as "+studentname+"_course grade.csv ");
							System.out.println("##########################################");
							System.out.println("");
							System.out.println("");
						
							
							writer.close();
							exportAllGrade();
							}
	
	
							catch(IOException e)
							{
		
							e.printStackTrace();
							System.out.println("ERROR EXPORTING");
							exportAllGrade();
							} 
							
							
							
	
							
							
   
	
	
						}
	
	
			}
			else{
			
					exportAllAssignmentGrade();
				}
		
	
		sc.close();	
			
			
			
			
			
			
			
			
			
			
			
		
	}
	
	//2 <Export all student grades for all completed assignments from a course>
	private void exportAllAssignmentGrade() throws IOException{
	
		System.out.println("");
		System.out.println("<<Export all student grades for all completed assignments from a course>>");
		
		System.out.println("=======================PLEASE SELECT A COURSE TO EXPORT GRADE=============================");
		int i = 0;
		for(Course c:arrayofcourse){
			System.out.println("["+(++i)+"] " + c.getCoursename().toString());	
		}
		
			System.out.println("["+(++i)+"] Back to export menu");
			System.out.println("==========================================================================");
		
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()){		
				int val = sc.nextInt();
	
				if(val==i){ 
					printFunc(); 
					}
	
					else if(val>arrayofcourse.size() || val<0){
						
						exportAllAssignmentGrade();
					}
						else{
		
							Course co = arrayofcourse.get((val-1));
							//System.out.println(co.getCoursename());
	
							String coursename=co.getCoursename();
	
							String outputFileName= coursename+"_grade all student.csv";
							try
							{

							FileWriter writer = new FileWriter(outputFileName);
							writer.append("Student_Name");
							writer.append(',');
							writer.append("Studen_ID");
							writer.append(',');
							writer.append("Assignment_1");
							writer.append(',');
							writer.append("Assignment_2");
							writer.append('\n');
    
							for(int k=0; k < co.getAllstudentgradelist().size(); k++){
							Student stu = co.getAllstudentgradelist(k);
							writer.append(stu.getStudentName());
							writer.append(',');
							writer.append(stu.getStudentId());
							writer.append(',');
							writer.append(stu.getAssignment1grade());
							writer.append(',');
							writer.append(stu.getAssignment2grade());
							writer.append('\n');
							}
							System.out.println("##########################################");
							System.out.println("# Exported as "+coursename+"_grade all student.csv ");
							System.out.println("##########################################");
							
							writer.close();
							exportAllAssignmentGrade();
							}
	
	
							catch(IOException e)
							{
		
							e.printStackTrace();
							System.out.println("ERROR EXPORTING");
							exportAllAssignmentGrade();
							} 

   
	
	
						}
	
	
			}
			else{
			
					exportAllAssignmentGrade();
				}
		
	
		sc.close();
		
			
	}
		
		
		
		
		
		
	

	
	//3
	private void justforfun(){
		System.out.println("3 entered");
	}
	
	
	

	
	
	
	
	public static void main(String[] args) throws IOException{
		
		ExportStory2 es2 = new ExportStory2();
		
		ArrayList<Student> arrayofstudent = new ArrayList<Student>();
		
		arrayofstudent.add(new Student("2110011","alpha",'B','C'));
		arrayofstudent.add(new Student("2110022","bravo",'A','C'));
		arrayofstudent.add(new Student("2110033","charlie",'C','C'));
		arrayofstudent.add(new Student("2110044","delta",'D','C'));
		arrayofstudent.add(new Student("2110055","echo",'A','A'));
		
		Course c1= new Course("PSD3",arrayofstudent);
		
		ArrayList<Student> arrayofstudent2 = new ArrayList<Student>();
		
		arrayofstudent2.add(new Student("2110066","fooer",'B','C'));
		arrayofstudent2.add(new Student("2110022","bravo",'D','D'));
		arrayofstudent2.add(new Student("2110033","charlie",'C','C'));
		arrayofstudent2.add(new Student("2110044","delta",'D','C'));
		arrayofstudent2.add(new Student("2110077","golf",'A','A'));
		
		
		
		Course c2= new Course("ALG3",arrayofstudent2);
		
		
		es2.arrayofcourse.add(c1);
		es2.arrayofcourse.add(c2);
		
		
		
		
		
		es2.printFunc();
		
	}
}
