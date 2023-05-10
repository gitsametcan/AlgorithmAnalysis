import java.util.ArrayList;
import java.util.List;

public class BruteForce {
	
	private String pattern;
	private String htmlFile;
	private int comp;
	private int count;
	private long time;
	private List<Integer> indexes;
	

	public BruteForce(String pattern, String comeFromFile) {
		this.pattern = pattern;
		this.htmlFile = comeFromFile;
		this.count();
	}
	
	
	private void count() {
		int count = 0;
		int comprasion = 0;
		List<Integer> temp = new ArrayList();
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i<=this.htmlFile.length() - this.pattern.length(); i++) {	
			int j = 0;
			int k = i;
			while (this.htmlFile.substring(k, k+1).equals(this.pattern.substring(j,j+1)) && j+1!=this.pattern.length()) {
				
				comprasion ++;
				if(j+2==this.pattern.length()) {
					temp.add(k - this.pattern.length()+2);
					count ++;
				}
				j++;
				k++;
			}
			comprasion ++;
		}
		
		this.time = System.currentTimeMillis() - startTime;
		this.comp = comprasion;
		this.count = count;
		this.indexes = temp;
	}
	
	public String print() {
		return "Comparison time is "+this.time+"(ms) comparison number is "+this.comp+" matching number is " + this.count;
	}
	
	public List<Integer> getIndexes() {
		return indexes;
	}

	
	

}
