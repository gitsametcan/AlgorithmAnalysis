
public class BruteForce {
	
	private String pattern;
	private String htmlFile;
	private int comp;
	private int count;
	private long time;
	
	public BruteForce(String pattern, String comeFromFile) {
		this.pattern = pattern;
		this.htmlFile = comeFromFile;
		this.count();
	}
	
	
	public void count() {
		int count = 0;
		int comprasion = 0;
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i<this.htmlFile.length()-2; i++) {	
			int j = 0;
			int k = i;
			while (this.htmlFile.substring(k, k+1).equals(this.pattern.substring(j,j+1)) && j+1!=this.pattern.length()) {
				comprasion ++;
				if(j+2==this.pattern.length()) count ++;
				j++;
				k++;
			}
			comprasion ++;
		}
		
		this.time = System.currentTimeMillis() - startTime;
		System.out.println("time is" + time);
		this.comp = comprasion;
		System.out.println("comp is" + comprasion);
		this.count = count;
		System.out.println("count is" + count);
	}


	public int getComp() {
		return this.comp;
	}


	public int getCount() {
		return this.count;
	}


	public long getTime() {
		return this.time;
	}
	
	

}
