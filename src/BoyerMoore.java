import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoyerMoore extends Horspool {
	
	private List<Integer> suffix;

	
	public BoyerMoore(String pattern, String comeFromFile) {
		super(pattern, comeFromFile);
		this.suffix = generateSuffixTable(this.pattern);
		count();
	}
	
	private List<Integer> generateSuffixTable(String pattern) {
		
		List<Integer> table = new ArrayList();
		
		int k;	
		for(k=1;k<=pattern.length();k++) {
			
			if(pattern.substring(0,pattern.length()-1).contains((pattern.substring(pattern.length()-k))) ) {
				System.out.println(); //Hangilerini içinde bulabiliyor.
				table.add(pattern.length()-k-pattern.substring(0,pattern.length()-1).lastIndexOf(pattern.substring(pattern.length()-k)));
				System.out.println(k);
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
		int i = 0;
		while(i<=this.htmlFile.length() - this.pattern.length()) {	
			int j = 0;
			int k = i;
			while (this.htmlFile.substring(k, k+1).equals(this.pattern.substring(j,j+1)) && j+1!=this.pattern.length()) {
				
				comprasion ++;
				if(j+2==this.pattern.length() && this.htmlFile.substring(k+1, k+2).equals(this.pattern.substring(j+1,j+2))) {
					temp.add(k - this.pattern.length()+2);
				}
				j++;
				k++;
			}
			comprasion ++;
			
			i += table.get(htmlFile.substring(i + pattern.length() - 1, i + pattern.length()));	
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
