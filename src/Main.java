
public class Main {

	public static void main(String[] args) {
		
		String a = "the";
		ReadHTML html = new ReadHTML("typeoneinput");
		
		BruteForce bc = new BruteForce(a, html.getHtmlContent());
		
		html.addMarkAndWrite(bc.getIndexes(), a.length());
		
		//System.out.println(bc.print());
		//System.out.print(bc.getIndexes());
		
		//Horspool hp = new Horspool("baobab", "bard baobab loved bananas");
		
		//hp.printTable();
		
		
		//System.out.println(hp.getCompNumber());
		
		
		//System.out.print(html.htmlContent);
		
		
	}
	

}
