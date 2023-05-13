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
		
		for (int i = 1; i<this.pattern.length(); i++) {
			int k = 0;
			String a = this.pattern.substring(this.pattern.length()-i);
			int l = pattern.length()-i-1;
			while(!a.equals(pattern.substring(l,l+i))&&l>0) {
				k++;
				l--;
			}
			table.add(k+i);
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
		System.out.println("The suffix table is:\n");
		
	}

	public List<Integer> getSuffix() {
		return suffix;
	}
	
	public void print() {
		System.out.println("Comparison time is " + this.time + "(ms) comparison number is " + this.compNumber + " matching number is " + this.indexes.size() +" algorithm is BoyerMoore");
	}

}
