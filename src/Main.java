
public class Main {

	public static void main(String[] args) {
		
		String a = "01";
		ReadHTML html = new ReadHTML("typetwoinput");
		
		//BruteForce bc = new BruteForce(a, html.getHtmlContent());
		
		//bc.print();
		
		

		
		//BoyerMoore bm = new BoyerMoore("baobab", "bess_knew_about_baobabaobabs bess_baobabknew_about_baobabs");
		
		
		
		
		//BruteForce bc = new BruteForce(a, html.getHtmlContent());
		
		//bc.print();
				
		//Horspool hp = new Horspool("baobab", "bess_knew_about_baobabaobabs bess_baobabknew_about_baobabs");
		
		//hp.print();
		//hp.printTable();
		//BoyerMoore bm = new BoyerMoore("11011","0516235123351");
		
		//bm.printSuffixTable();
				
		BoyerMoore bm = new BoyerMoore(a, html.getHtmlContent());
				
				
		bm.print();
		//bm.printSuffixTable();
		
		//System.out.println(hp.getIndexes());
		//hp.print();
		//System.out.print(html.htmlContent);
		
		
	}
	

}
