
public class Main {

	public static void main(String[] args) {
		
		//String a = "BAOBAB";
		String a = "algorithm";
		ReadHTML html = new ReadHTML("typeoneinput");
		//String b = "BESS_KNEW_ABOUT_BAOBABSBAOBABAOBAB";
		String b = html.getHtmlContent();
		

		//System.out.print(a.substring(a.length()-1,a.length()));
		BruteForce bc = new BruteForce(a, b);
		
		bc.print();
				
		//Horspool hp = new Horspool("baobab", "bess_knew_about_baobabaobabs bess_baobabknew_about_baobabs");
		Horspool hp = new Horspool(a, b);
		
		hp.print();
		
		hp.printTable();
		BoyerMoore bm = new BoyerMoore(a,b);
		//System.out.print(a.substring(a.length()-3,a.length()-3+1));
		//bm.printSuffixTable();
				
		//BoyerMoore bm = new BoyerMoore("11101011", html.getHtmlContent());
				
				
		bm.print();
		//bm.printSuffixTable();
		//System.out.println(bm.getTable());
		//bm.print();
		//bm.printTable();
		//bm.printSuffixTable();
		
		//html.addMarkAndWrite(bc.getIndexes(), a.length());
		
		//System.out.println(hp.getIndexes());
		//hp.print();
		//System.out.print(html.htmlContent);
		
		
	}
	
	
	

}
