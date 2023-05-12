import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoyerMoore extends Horspool {
	
	private List<Integer> suffix;
	private int compNumber;
	private long time;

	
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
		int i = 0;
		List<Integer> temp = new ArrayList();
		List<Integer> tempa = this.suffix;
		long startTime = System.currentTimeMillis();
		while(i < htmlFile.length() + pattern.length()) {
			
			if (i > htmlFile.length() - pattern.length()) {
				break;
			}
			int j = 0;		
			// if pattern's letter equals to html file's letter
			while (htmlFile.substring(i + pattern.length() - 1 - j,  i + pattern.length() - j).equals(pattern.substring(pattern.length() - 1 - j ,pattern.length() - j))) {
				this.compNumber++;
				j++;
				if (j == pattern.length()-1) {
					//System.out.println("esalka");
					temp.add(i + pattern.length() - j);
					break;
				}
			}
			String a = htmlFile.substring(i+this.pattern.length()-1-j, i+this.pattern.length()-j);
			int fromTable = this.table.get(a) - j;
			
			int fromSuffix = pattern.length();
			
			if (j < pattern.length()) fromSuffix = tempa.get(j);
			int jump = fromTable;
			
			if (fromTable < fromSuffix) jump = fromSuffix;
			
			if (j == pattern.length()-1) jump = 1;
			
			i += jump;
			
			//System.out.println("a is ="+ a+"d1 is = "+ fromTable + "d2 is = " + fromSuffix + " jump is = "+ jump);
			this.compNumber++;
		}
		this.time = System.currentTimeMillis() - startTime;
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
