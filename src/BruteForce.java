
public class BruteForce {
	
	private String pattern;
	private String htmlFile;
	
	public BruteForce(String pattern, String comeFromFile) {
		this.pattern = pattern;
		this.htmlFile = comeFromFile;
	}
	
	
	public int count() {
		int count = 0;
		
		for (int i = 0; i<this.htmlFile.length()-2; i++) {	
			int j = 0;
			int k = i;
			while (this.htmlFile.substring(k, k+1).equals(this.pattern.substring(j,j+1)) && j+1!=this.pattern.length()) {
				if(j+2==this.pattern.length()) count ++;
				j++;
				k++;
				
			}
		}
		return count;
	}

}
