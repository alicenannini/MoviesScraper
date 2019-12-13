import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class OmdbScraper {
	final static String key = "804f7738";
	
	public static void main(String[] args) throws IOException{
    	int i = 0;
    	String url = "http://www.omdbapi.com/?apikey="+key+"&t=";
    	String path = "/home/marco/Downloads/";
    	String source = "marco_2.txt";
    	String destination = "moviesDB_3.json";
	    
    	try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path+source))) {
    		while(i < 560) {    	    	
	    		String movie = bufferedReader.readLine();
	    		System.out.println(i+": "+movie);
		    	Document doc = Jsoup.connect(url+movie).ignoreContentType(true).get();
	    		//Document doc = Jsoup.connect(url).ignoreContentType(true).get();
			    Elements body = doc.getElementsByTag("body");//getElementsByClass("data");
			    //System.out.println(body.text()+"\n");
	        	try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path+destination,true))) {
	        	    String fileContent = body.text()+"\n";
	        	    bufferedWriter.write(fileContent);
	        	}
		    i++;
	    	}
    	}
	}
}
