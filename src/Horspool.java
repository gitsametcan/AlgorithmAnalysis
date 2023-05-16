import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Horspool {
	private String pattern;
	private String htmlFile;
	private long time;
	private HashMap<String, Integer> table;
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
					if(l<0)break;
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
		int comprasion = 0;
		List<Integer> temp = new ArrayList();
		long startTime = System.currentTimeMillis();
		int i = 0;
		while(i<=this.htmlFile.length() - this.pattern.length()) {
			int j = this.pattern.length()-1;
			int k = i + this.pattern.length()-1 ;
			while (this.htmlFile.substring(k, k+1).equals(this.pattern.substring(j,j+1)) && j!=0) {
				//System.out.println(this.htmlFile.substring(k, k+1) +"  =  " + this.pattern.substring(j,j+1)+k);
				comprasion ++;
				if(j==1 && this.htmlFile.substring(k-1, k).equals(this.pattern.substring(j-1,j))) {
					temp.add(i);
				}
				j--;
				k--;
			}
			comprasion ++;
			i += table.get(htmlFile.substring(i + pattern.length() - 1, i + pattern.length()));	
		}
		
		this.time = System.currentTimeMillis() - startTime;
		this.compNumber = comprasion;
		this.indexes = temp;
	}
	

	public void printTable() {
		System.out.println("Table is:");
		for (int i = 0; i < this.table.toString().length(); i = i + 5) {
			if (this.table.toString().substring(i + 1, i + 2).equals("\n") 
					|| this.table.toString().substring(i + 1, i + 2).equals("\r") 
					||this.table.toString().substring(i + 1, i + 2).equals("\t")) {
				System.out.print("*" + "|");
			}
			else
				System.out.print(this.table.toString().substring(i + 1, i + 2) + "|");
			
		}
		System.out.println();
		for (int i = 0; i < this.table.toString().length(); i = i + 5) {
			System.out.print(this.table.toString().substring(i + 3, i + 4) + "|");
		}
		
	}
	
	public List<Integer> getIndexes() {
		return indexes;
	}
	
	public void print() {
		System.out.println("Comparison time is " + this.time + "(ms) comparison number is " + this.compNumber + " matching number is " + this.indexes.size() +" algorithm is Horspool");
	}
}

    