import java.util.HashMap;

public class Horspool {
	protected String pattern;
	protected String htmlFile;
	protected HashMap<String, Integer> table;
	private int compNumber;
	
	
	public Horspool(String pattern, String comeFromFile) {
		this.pattern = pattern;
		this.htmlFile = comeFromFile;
		this.table = generateTable(this.pattern,this.htmlFile);
		
	}
	
	private HashMap<String, Integer> generateTable(String pattern, String htmlFile) {
		
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		
		htmlFile = withOutDublicate(htmlFile);
		
		
		for(int i = 0; i<htmlFile.length();i++) {
			
			if (!isThere(htmlFile.substring(i,i+1), pattern)) { table.put(htmlFile.substring(i,i+1), pattern.length());
			
			}
			else {
				
				
				int k = 1;
				int l = pattern.length()-2;
				while(!htmlFile.substring(i,i+1).equals(pattern.substring(l,l+1))) {
					k++;
					l--;
					
				}
				table.put(htmlFile.substring(i,i+1), k);
				
				
			}
		}
		
		return table;
	}
	
	private boolean isThere(String a, String pattern) {
		boolean isThere = false;
		for (int i = 0; i<pattern.length();i++) {
			if (pattern.substring(i,i+1).equals(a)) isThere = true;
		}
		
		return isThere;
	}
	
	private String withOutDublicate(String string) {
		String temp = "";
		for(int i = 0; i<string.length(); i++) {
			boolean isThere = false;
			for(int j = 0; j<temp.length(); j++) {
				if(string.substring(i, i+1).equals(temp.substring(j,j+1))) isThere = true;
			}
			if (!isThere) temp = temp + string.substring(i, i+1);
		}
		return temp;	
	}
	
	public void count() {
		for(int i = 0; i < htmlFile.length() - pattern.length(); i++ ) {
			int tempi = i;
			if (i != 0 ) {
				i = i - 1;
			}
			
			int j = 0;
			if (htmlFile.substring(i + pattern.length() - 3, i + pattern.length()-2 ).equals(pattern.substring(pattern.length() - 3 - j ,pattern.length() - 2 - j))) {
				System.out.println("first1  " + htmlFile.substring(i + pattern.length() - 3, i + pattern.length()-2));
				compNumber --;
			}
			while (htmlFile.substring(i + pattern.length() - 3, i + pattern.length()-2 ).equals(pattern.substring(pattern.length() - 3 - j ,pattern.length() - 2 - j))) {
				System.out.println("first2  " + htmlFile.substring(i + pattern.length() - 3, i + pattern.length()-2));
				System.out.println("xxxxxxxxxxxxxxxxx");
				this.compNumber++;
				i--;
				j++;
			}
			
			
			i = tempi;
			
			System.out.println("first3  " + htmlFile.substring(i + pattern.length() - 2, i + pattern.length()-1));
			i += table.get(htmlFile.substring(i + pattern.length() - 1, i + pattern.length()));
			System.out.println(htmlFile.substring(i + pattern.length() - 1, i + pattern.length()));
			System.out.println("i= " + i);
			
			
			this.compNumber++;
		}
		
	}
	

	
	public void printTable() {
		System.out.println(this.table);
	}
	
	public int getCompNumber(){
    	return this.compNumber;
    }
}

    