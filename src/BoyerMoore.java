import java.util.HashMap;

public class BoyerMoore extends Horspool {
	private HashMap<Integer, Integer> suffix;
	
	public BoyerMoore(String pattern, String comeFromFile) {
		super(pattern, comeFromFile);
		
		this.suffix = generateSuffixTable(this.pattern);
		
	}
	
	private HashMap<Integer, Integer> generateSuffixTable(String pattern) {
		
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		
		for (int i = 1; i<this.pattern.length(); i++) {
			int k = 0;
			String a = this.pattern.substring(this.pattern.length()-i);
			int l = pattern.length()-i-1;
			while(!a.equals(pattern.substring(l,l+i))&&l>0) {
				k++;
				l--;
			}
			
			if(i == 1 && !isThere(pattern.substring(pattern.length()-1),pattern.substring(0,pattern.length()-1)))
			table.put(i, k+i+1);
			
			else
			table.put(i, k+i);
		}
		
		return table;
		
	}
	
	public void printSuffixTable() {
		System.out.println(this.suffix);
	}

}
