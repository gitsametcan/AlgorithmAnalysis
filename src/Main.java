
public class Main {

	public static void main(String[] args) {
		
		//BruteForce bc = new BruteForce("baobab", "bard loved bananas");
		
		//bc.count();
		
		//System.out.print(bc.getCount());
		
		BoyerMoore hp = new BoyerMoore("baobab", "bard loved bananas");
		
		hp.printTable();
		
		hp.printSuffixTable();
		
		

	}

}
