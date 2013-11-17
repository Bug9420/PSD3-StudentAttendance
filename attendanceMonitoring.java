import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class attendanceMonitoring{
	
	/*public void printFunctions(){
		
		ArrayList<String> allCourses = new ArrayList<String>();
		allCourses.add("PSD3");
		allCourses.add("ALG3");
		allCourses.add("PL3");
		
		System.out.println("All courses: ");
		
		for(int i=0; i<allCourses.size(); i++){
			
			System.out.println(i+1 + ". " + allCourses.get(i));
			
		}
		
		System.out.println("Please select a course: ");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		int getAttInput = Integer.parseInt(getInput);	
		switch(getAttInput){
			case 1:
				//call another function
				printPSD3();
				break;
			case 2:
				//call another function
				
				break;
			case 3:
				//call another function
			default: 
				System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
				getInput = scan.next();
				getAttInput = Integer.parseInt(getInput);
				break;
		}
		scan.close();
	}
	
	public void printPSD3(){
		System.out.println("Please select which date");
		System.out.println("1. 04/11/2013");
		System.out.println("2. 11/11/2013");
		System.out.println("3. 18/11/2013");
		System.out.println("4. 25/11/2013");
		
		ArrayList<String> studentNames = new ArrayList<String>();
		//String[] arr = null;
		
		studentNames.add("2010001, Yee Keng, YTT");
		studentNames.add("2010002, Daemian, YTT");
		studentNames.add("2010003, Boon Keong, YTT");
		studentNames.add("2010004, WinWin, YTT");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		int getDateInput = Integer.parseInt(getInput);	
		switch(getDateInput){
			case 1:

				System.out.println("Timing available for 04/11/2013");
				System.out.println("0900 hrs - 1100 hrs");
				System.out.println("1300 hrs - 1500 hrs");
				
				Scanner scan2 = new Scanner(System.in);
				
				String getInput2 = scan2.next();
				int getTimeInput = Integer.parseInt(getInput2);	
				switch(getTimeInput){
					case 1:
						//print all students who are in this course at 0900-1100hrs
						System.out.println("You selected 0900 hrs - 1100 hrs");
						for(int x=0; x<studentNames.size(); x++){
							System.out.println(x + ". " +studentNames.get(x));
						}
						
						Scanner scan3 = new Scanner(System.in);
						
						String getInput3 = scan3.next();
						//arr = getInput3;
						
						break;
					case 2:
						//print all students who are in this course at 1300-1500hrs
						break;
					default: 
						System.out.print("That is not a valid input!\nPlease re-enter: ");
						getInput2 = scan.next();
						getDateInput = Integer.parseInt(getInput2);
						break;
				}
				scan2.close();
			case 2:
				//call another function
				
				break;
			case 3:
				//call another function
				break;
			
			case 4:
				
				break;
			default: 
				System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
				getInput = scan.next();
				getDateInput = Integer.parseInt(getInput);
				break;
		}
		scan.close();
	}*/
	
	ArrayList<String> allStudent = new ArrayList<String>();
   
	public void printFunctions(){
		
		ArrayList<String> allCourses = new ArrayList<String>();
		allCourses.add("PSD3");
		allCourses.add("ALG3");
		allCourses.add("PL3");
		
		System.out.println("All courses: ");
		
		for(int i=0; i<allCourses.size(); i++){
			
			System.out.println(i+1 + ". " + allCourses.get(i));
			
		}
		
		System.out.println("Please select a course: ");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		int getAttInput = Integer.parseInt(getInput);	
		switch(getAttInput){
			case 1:
				importAttendance("studentAttPSD");
				break;
			case 2:
				//call another function
				importAttendance("studentAttALG");
				break;
			case 3:
				//call another function
				importAttendance("studentAttPL");
				break;
			default: 
				System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
				getInput = scan.next();
				getAttInput = Integer.parseInt(getInput);
				break;
		}
		scan.close();
	}
	
	  public void importAttendance(String courses) {
		  
		  String csvFile = "/Users/User/workspace/PSD3-Assignment1/" + courses + ".csv";
    	  BufferedReader br = null;
		  String line = "";
		  //String cvsSplitBy = ",";
		 
		  	try {
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					
					allStudent.add(line);
					//System.out.println(line);
				        // use comma as separator
					//String[] info = line.split(cvsSplitBy);
					
					//System.out.println("Student ID: " + info[0] + "\tName: " + info[1] + "\nAttendance: "+ info[2]);
		 
				}
		 
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				if (br != null) {
					try {
						br.close();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			//System.out.println("Import Successful!");
		  }
	
}