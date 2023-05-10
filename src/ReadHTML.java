import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadHTML {

	public String htmlContent;
	
	public ReadHTML(String filename){
		Scanner scanner;
		StringBuilder str = new StringBuilder();
		try {
			scanner = new Scanner(new File(filename + ".html"));
			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				
				str.append(line);
				str.append(System.getProperty("line.separator"));
				
				 	   	   
			}
		} catch (FileNotFoundException e) {
			System.out.print("HTML file problem");
		}
		
		this.htmlContent = str.toString();
		
	}
	
	public void writeHTML(String output) {
		try {
			FileWriter writer = new FileWriter("output.html"); 
			writer.write(output);
			
			writer.close();
		      System.out.println("Successfully wrote to the file.");
		    } 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}