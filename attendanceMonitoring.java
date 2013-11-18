import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class attendanceMonitoring{
	
	ArrayList<String> allStudent = new ArrayList<String>();
	ArrayList<String> studentBarcode = new ArrayList<String>();
	String csvFile = "";
   
	public void printFunctions() throws IOException{
		
		ArrayList<String> allCourses = new ArrayList<String>();
		allCourses.add("PSD3");
		allCourses.add("ALG3");
		allCourses.add("PL3");
		
		System.out.println("All courses: ");
		
		for(int i=0; i<allCourses.size(); i++){
			
			System.out.println(i+1 + ". " + allCourses.get(i));
			
		}
		System.out.println("4. Exit");
		System.out.println("Please select a course: ");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		int getAttInput = Integer.parseInt(getInput);	
		switch(getAttInput){
			case 1:
				importAttendance("studentAttPSD");
				printNextFunction("PSD3");
				break;
			case 2:
				importAttendance("studentAttALG");
				printNextFunction("ALG33");
				break;
			case 3:
				importAttendance("studentAttPL");
				printNextFunction("PL3");
				break;
			case 4:
				Main.main(null);
				break;
			default: 
				System.out.print("That is not a valid input!\nPlease enter 1 to 3: ");
				getInput = scan.next();
				getAttInput = Integer.parseInt(getInput);
				break;
		}
		scan.close();
	}
	
	public void printNextFunction(String course) throws IOException{
		
		System.out.println("You have slected: "+course+".\nDo you want to: ");
		System.out.println("1. View all students");
		System.out.println("2. Edit attendance");
		System.out.println("3. Export CSV file");
		System.out.println("4. Import Barcode CSV File");
		System.out.println("5. Edit Barcode CSV File");
		System.out.println("6. Back");
		System.out.println("Please select 1 - 6: ");
		
		Scanner scan2 = new Scanner(System.in);
		
		String getInput2 = scan2.next();
		int getUserInput = Integer.parseInt(getInput2);	
		switch(getUserInput){
			case 1:
				System.out.println("Students in "+ course +" lesson");
				printAllAtt();
				printNextFunction(course);
				break;
			case 2:
				printEditAtt(course);
				printNextFunction(course);
				break;
			case 3:
				exportAllAtt();
				printNextFunction(course);
				break;
			case 4:
				importBarcodeCSV();
				printNextFunction(course);
				break;
			case 5:
				printEditBarcode(course);
				printNextFunction(course);
				break;
			case 6:
				allStudent.clear();
				printFunctions();
				break;
			default: 
				System.out.print("That is not a valid input!\nPlease enter 1 - 6: ");
				getInput2 = scan2.next();
				getUserInput = Integer.parseInt(getInput2);
				break;
		}
		scan2.close();
	}
	
	public void printAllAtt(){
			
			String line = "";
			String cvsSplitBy = ",";
			for(int i=0; i<allStudent.size(); i++){
				line = allStudent.get(i);
				
				String[] info = line.split(cvsSplitBy);
			
				System.out.println("Student ID: " + info[0] + "\tName: " + info[1] + "\nAttendance: "+ info[2]);
			}
		}
	
	public void printEditAtt(String course){
		
		String line = "";
		String cvsSplitBy = ",";
		
		int totalStudent = allStudent.size();
		
		for(int i=0; i<totalStudent; i++){
			line = allStudent.get(i);
			
			String[] info = line.split(cvsSplitBy);
			
			System.out.println("Student ID: " + info[0] + "\tName: " + info[1]);
			System.out.println("Attendance: 1. Present\t2. Absent\t3. mv");
			System.out.println("Please select 1 - 3");
			
			Scanner scan = new Scanner(System.in);
			
			String getInput = scan.next();
			int getUserInput = Integer.parseInt(getInput);	
			
			String newAttendance = "";
			switch(getUserInput){
				case 1:
					
					newAttendance = info[0] + "," + info[1] + ","+ "Present";
					System.out.println(newAttendance);
					allStudent.add(newAttendance);
					break;
				case 2:
					
					newAttendance = info[0] + "," + info[1] + ","+ "Absent";
					System.out.println(newAttendance);
					allStudent.add(newAttendance);
					break;
				case 3:
					
					newAttendance = info[0] + "," + info[1] + ","+ "mv";
					System.out.println(newAttendance);
					allStudent.add(newAttendance);
					break;
				default: 
					System.out.print("That is not a valid input!\nPlease enter 1 - 3: ");
					getInput = scan.next();
					getUserInput = Integer.parseInt(getInput);
					break;
			}
		}
		
		
		for(int i=0; i<totalStudent; i++){
			allStudent.remove(0);
		}
	}
	
	public void exportAllAtt(){
		
		System.out.println("File Name(without any extention name):");
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();
		String getUserInput = getInput;	
		
		try
		{
			File newFile = new File("/Users/User/workspace/PSD3-Assignment1/" + getUserInput + ".csv");
			if(newFile.exists()){
			    newFile.delete();
			    
			    FileWriter writer = new FileWriter(newFile, true);
			    
			    String line = "";
			    
				for(int i=0; i<allStudent.size(); i++){
					
					line = allStudent.get(i);
					writer.append(line+'\n');
				}
				writer.close();
			}
			else{
				FileWriter writer = new FileWriter(newFile, true);
			    
			    String line = "";
				for(int i=0; i<allStudent.size(); i++){
					
					line = allStudent.get(i);
					writer.append(line+'\n');
				}
				writer.close();
			}
			    //generate whatever data you want
		 
				System.out.println("File sucessfully exported");
			
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		}
	}
	
	public void importBarcodeCSV(){
		System.out.println("Where is your CSV file located?");
		
		Scanner scan = new Scanner(System.in);
		
		String getInput = scan.next();	
		
		csvFile = getInput;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				
				studentBarcode.add(line);
			        // use comma as separator
				String[] info = line.split(cvsSplitBy);
				
				System.out.println("Student ID(Barcode No.): " + info[0] + "\tAttendance: " + info[1]);
	 
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
		System.out.println("Succesfully imported");
	}
	
public void printEditBarcode(String course){
		
		String line = "";
		String cvsSplitBy = ",";
		
		int totalStudent = studentBarcode.size();
		
		for(int i=0; i<totalStudent; i++){
			line = studentBarcode.get(i);
			
			String[] info = line.split(cvsSplitBy);
			
			System.out.println("Student ID(Barcode No.): " + info[0]);
			System.out.println("Attendance: 1. Present\t2. Absent\t3. mv");
			System.out.println("Please select 1 - 3");
			
			Scanner scan = new Scanner(System.in);
			
			String getInput = scan.next();
			int getUserInput = Integer.parseInt(getInput);	
			
			String newAttendance = "";
			switch(getUserInput){
				case 1:
					
					newAttendance = info[0] + "," + "Present";
					System.out.println(newAttendance);
					studentBarcode.add(newAttendance);
					break;
				case 2:
					
					newAttendance = info[0] + "," + "Absent";
					System.out.println(newAttendance);
					studentBarcode.add(newAttendance);
					break;
				case 3:
					
					newAttendance = info[0] + "," + "mv";
					System.out.println(newAttendance);
					studentBarcode.add(newAttendance);
					break;
				default: 
					System.out.print("That is not a valid input!\nPlease enter 1 - 3: ");
					getInput = scan.next();
					getUserInput = Integer.parseInt(getInput);
					break;
			}
		}
		
		
		for(int i=0; i<totalStudent; i++){
			studentBarcode.remove(0);
		}
		
		try
		{
			File newFile = new File(csvFile);
			System.out.println(csvFile);
			if(newFile.exists()){
			    newFile.delete();
			    
			    FileWriter writer = new FileWriter(newFile, true);
			    
			    String lineName = "";
				for(int i=0; i<studentBarcode.size(); i++){
					
					lineName = studentBarcode.get(i);
					writer.append(lineName+'\n');
				}
				writer.close();
			}
			else{
				FileWriter writer = new FileWriter(newFile, true);
			    
			    String lineName = "";
				for(int i=0; i<allStudent.size(); i++){
					
					lineName = allStudent.get(i);
					writer.append(lineName+'\n');
				}
				writer.close();
			}
			    //generate whatever data you want
				System.out.println("File sucessfully exported");
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		}
	}
	
	  public void importAttendance(String courses) {
		  
		  String csvFile = "/Users/User/workspace/PSD3-Assignment1/" + courses + ".csv";
    	  BufferedReader br = null;
		  String line = "";
		  	try {
		 
		  		
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					
					allStudent.add(line);
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
		  }
	
}