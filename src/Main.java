
public class Main {

	public static void main(String[] args) {
		
		BruteForce bc = new BruteForce("baobab", "bard loved bananas");
		
		long startTime = System.currentTimeMillis();
		
		System.out.println(bc.count());
		
		System.out.println(System.currentTimeMillis() - startTime);
		
		BoyerMoore hp = new BoyerMoore("baobab", "bard loved bananas");
		
		hp.printTable();
		
		hp.printSuffixTable();
		
		

	}

}
