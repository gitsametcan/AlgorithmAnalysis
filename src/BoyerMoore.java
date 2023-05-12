import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoyerMoore extends Horspool {
	
	private HashMap<Integer, Integer> suffix;
	private int compNumber;
	private long time;
	private int match = 0;
	private List<Integer> indexes;
	
	
	public BoyerMoore(String pattern, String comeFromFile) {
		super(pattern, comeFromFile);
		this.suffix = generateSuffixTable(this.pattern);
		count();
		
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
	
	private void count() {
		
		int i = 0;
		List<Integer> temp = new ArrayList<Integer>();
		long startTime = System.currentTimeMillis();
		
		while(htmlFile.substring(i).length() >= pattern.length()){

			System.out.println(i);
			
			if(pattern.length() > htmlFile.length()) {
				this.compNumber = 0;
				break;
			}
		
		int k = 0;
			
		for(int j = pattern.length()-1; j>=0;j--) {
			
			
			if(htmlFile.substring(i+j, i+j+1).equals(pattern.substring(j,j+1))) {
				k++;
				compNumber++;
			}
			
			else{
				compNumber++;
				String a = htmlFile.substring(i+j,i+j+1);
				if(1<= k && k < pattern.length())
					i += Math.max(Math.max(table.get(a) - k,1),suffix.get(k));
				else
					i += Math.max(table.get(a) - k,1);
				break;
			}
			
			if(k == pattern.length()) {
				temp.add(i+j+1);
				match++;
				
			}
				
				
		}
			
			
	}
			System.out.println(compNumber);
			System.out.println(temp);
			System.err.println(match);
			
	}
	
	public void printSuffixTable() {
		System.out.println(this.suffix);
	}

}
