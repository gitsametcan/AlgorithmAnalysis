
public class Main {

	public static void main(String[] args) {
		
		BruteForce bc = new BruteForce("baobab", "bard loved bananas");
		
		System.out.print(bc.print());
		
		ReadHTML html = new ReadHTML("form_advanced");
		
		System.out.print(html.htmlContent);
		
		
	}

}
