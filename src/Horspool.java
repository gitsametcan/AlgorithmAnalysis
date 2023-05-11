import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Horspool {
	protected String pattern;
	protected String htmlFile;
	protected HashMap<String, Integer> table;
	private List<Integer> indexes;
	private int compNumber;
	
	
	public Horspool(String pattern, String comeFromFile) {
		this.pattern = pattern;
		this.htmlFile = comeFromFile;
		this.table = generateTable(this.pattern,this.htmlFile);
		this.count();
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
	
	private void count() {
		int i = 0;
		List<Integer> temp = new ArrayList();
		while(i < htmlFile.length() + pattern.length()) {
			
			if (i > htmlFile.length() - pattern.length()) {
				break;
			}
			int j = 0;
			
			// if pattern's letter equals to html file's letter
			while (htmlFile.substring(i + pattern.length() - 1 - j,  i + pattern.length() - j).equals(pattern.substring(pattern.length() - 1 - j ,pattern.length() - j))) {
				this.compNumber++;
				
				j++;
				if (j == pattern.length()) {
					temp.add(i + pattern.length() - j);
					break;
				}
			}
				
			i += table.get(htmlFile.substring(i + pattern.length() - 1, i + pattern.length()));
			
			
			this.compNumber++;
		}
		this.indexes = temp;
	}
	

	
	public void printTable() {
		System.out.println(this.table);
	}
	
	public int getCompNumber(){
    	return this.compNumber;
    }
	
	public List<Integer> getIndexes() {
		return indexes;
	}
}

    