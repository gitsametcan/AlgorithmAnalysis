import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoyerMoore {
	
	private String pattern;
	private String htmlFile;
	private long time;
	private HashMap<String, Integer> table;
	private List<Integer> indexes;
	private int compNumber;
	private List<Integer> suffix;

	
	public BoyerMoore(String pattern, String comeFromFile) {
		this.pattern = pattern;
		this.htmlFile = comeFromFile;
		this.table = generateTable(this.pattern,this.htmlFile);
		this.suffix = generateSuffixTable(this.pattern);
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
	
	
	private List<Integer> generateSuffixTable(String pattern) {
		
		List<Integer> table = new ArrayList();	
		int k;	
		for(k=1;k<=pattern.length();k++) {
			
			if(pattern.substring(0,pattern.length()-1).contains((pattern.substring(pattern.length()-k))) ) {
				//System.out.println(); //Hangilerini icinde bulabiliyor.
				table.add(pattern.length()-k-pattern.substring(0,pattern.length()-1).lastIndexOf(pattern.substring(pattern.length()-k)));
				//System.out.println(k);
			}
			
			else {
				
				if(k==1)
					table.add(pattern.length());
				
				else{
					
					int index = pattern.substring(0,pattern.length()-1).lastIndexOf(pattern.charAt(pattern.length()-1));
					//StringBuilder sb = new StringBuilder();
					int end=0;
					
					for(int t = index,j = 1;t>=0;t--,j++) {
						
						if(pattern.charAt(pattern.length()-j) == pattern.charAt(t)) {
							end++;
							//sb.insert(0,pattern.charAt(t));
						}
							
						else {
							index = pattern.substring(0,t).lastIndexOf(pattern.charAt(pattern.length()-1));
							t = index + 1;
							j = 0;
							end = 0;
							//sb.setLength(0);
						}
					
					}				
						table.add(pattern.length()- end);
						/*String s = sb.toString();
						//if(pattern.contains(s)){
						}*/			
				}
					
			}				
		}
			return table;
	}
	
	
	private void count() {
		int comprasion = 0;
		List<Integer> temp = new ArrayList();
		long startTime = System.currentTimeMillis();
		System.out.print(table);
		int i = pattern.length()-1;
		while(i<=this.htmlFile.length() - this.pattern.length()) {	
			int j = 0;
			int k = i;
			System.out.println("kictaki = " +this.htmlFile.substring(k, k+1));
			while (this.htmlFile.substring(k, k+1).equals(this.pattern.substring(j,j+1)) && j+1!=this.pattern.length()) {
				System.out.println("girdi"+this.htmlFile.substring(k, k+1) +"  =  " + this.pattern.substring(j,j+1)+k);
				comprasion ++;
				if(j+2==this.pattern.length() && this.htmlFile.substring(k+1, k+2).equals(this.pattern.substring(j+1,j+2))) {
					temp.add(k - this.pattern.length()+2);
				}
				j++;
				k--;
				
			}
			//System.out.println(this.htmlFile.substring(k, k+1) +"  =  " + this.pattern.substring(j,j+1));
			comprasion ++;
			System.out.println("aranan =" + this.htmlFile.substring(i-j, i-j+1));
			System.out.println("j = "+ j);
			int l = table.get(this.htmlFile.substring(i-j, i-j+1)) - j;
			
			
			int m = 0;
			if ( j == 0) m = this.suffix.get(pattern.length()-1);
			else m = this.suffix.get(j-1);
			
			if (j==this.pattern.length()) i++;
			else i += Math.max(l,m);
			System.out.println("d is =" +l +" d2 is ="+ m +" jump is =" + Math.max(l,m) );
		}
		
		this.time = System.currentTimeMillis() - startTime;
		this.compNumber = comprasion;
		this.indexes = temp;
	}
	
	public void printSuffixTable() {
		System.out.println("\nThe suffix table is:\n" + suffix);
		
	}

	public List<Integer> getSuffix() {
		return suffix;
	}
	
	public void print() {
		System.out.println("Comparison time is " + this.time + "(ms) comparison number is " + this.compNumber + " matching number is " + this.indexes.size() +" algorithm is BoyerMoore");
	}

}
