import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WildMoviesScraper {
	
	public static void main(String[] args) throws IOException
    {
    	String path = "/home/alice/Documenti/AIDE/LSMD/Task 2/";
    	int year = 2021;
    	int i = 1;
    	
    	while(year > 2019) {
    		System.out.print("year "+year);
    		String url = "https://www.wildaboutmovies.com/"+year+"_movies/";
    		String hrefString = "/"+year+"_movies/";
    				
	        Document doc = Jsoup.connect(url).get();
	        System.out.println(": get");
	        Elements titles = doc.select("a[href]");
	        
	        for (Element title : titles) {
	        	//String href=titles.attr("href");
	        	//String html = titles.html();
	        	//if(href.contains(hrefString)) {
	        		//System.out.println(i + ": " + title.text());
		            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path+"wildMovies2021-2020.txt",true))) {
					    String fileContent = title.text()+"\n";
					    bufferedWriter.write(fileContent);
					}
		            i++;
	        	//}
	        }
	        year--;
        }
        
    }
}
