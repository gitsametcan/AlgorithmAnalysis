import java.io.File;
import java.io.FileNotFoundException;
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

}