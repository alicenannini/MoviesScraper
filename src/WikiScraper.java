import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WikiScraper {
	public static void main(String[] args) throws IOException{
    	String url = "https://en.wikipedia.org/wiki/2019_in_film";
    	String path = "/home/alice/Documenti/AIDE/Statistica II/2° Progetto/";
	    
    	Document doc = Jsoup.connect(url).ignoreContentType(true).get();
	    Elements list = doc.getElementsByClass("hlist hlist-separated");
	    for(Element elem : list) {
	    	for(Element ul : elem.children()) {
	    		for(Element il : ul.children()) {
			    	System.out.println(il.text()+"\n");
					try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path+"moviesDB.txt",true))) {
					    String fileContent = il.text()+"\n";
					    bufferedWriter.write(fileContent);
					}
	    		}
	    	}
	    }
	}
}
