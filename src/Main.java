import java.io.File;

import javax.swing.text.html.HTMLDocument;

public class Main {

	public static void main(String[] args) {
		
		//BruteForce bc = new BruteForce("baobab", "bard loved bananas");
		
		//bc.count();
		
		//System.out.print(bc.getCount());
		
		File htmlFile = new File("<HTML><BODY>WHICH_FINALLY_HALTS. _ _ AT_THAT POINT </BODY></HTML>");
		
		String text = htmlFile.getPath();
		System.out.println(text);
		
		HTMLDocument html = new HTMLDocument();
		htmlFile.setWritable(true);
		BruteForce hp = new BruteForce("b", "aaaaaaa");
		
		
		
		

	}

}
