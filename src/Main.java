
public class Main {

	public static void main(String[] args) {
		
		//String a = "the";
		//ReadHTML html = new ReadHTML("typeoneinput");
		
		//BruteForce bc = new BruteForce(a, html.getHtmlContent());
		
		//html.addMarkAndWrite(bc.getIndexes(), a.length());
		
		//System.out.println(bc.print());
		//System.out.print(bc.getIndexes());
		
		BoyerMoore hp = new BoyerMoore("baobab", "bard baobab loved baobab bananas");
		
		hp.printSuffixTable();
		
		
		//System.out.println(hp.getCompNumber());
		
		//System.out.println(hp.getIndexes());
		//hp.print();
		//System.out.print(html.htmlContent);
		
		
	}
	

}
