
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyMoviesScraper
{
    public static void main(String[] args) throws IOException
    {
    	String path = "/home/alice/Documenti/AIDE/Statistica II/2° Progetto/";
    	int i = 1;
    	int page;
    	int pages = 10;
    	int year = 2019;
    	int years = 10;
    	while(years > 0) {
	        page = 1;
	    	while(page < pages){
	    		String url = "https://www.mymovies.it/film/"+year+"/?p=" + page;
		        
		        Document doc = Jsoup.connect(url).get();
		        Elements titles = doc.getElementsByClass("schedine-titolo");
		        
		        for (Element title : titles) {
		            System.out.println("\n" + i + "," + title.text());
		            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path+"movies2019-2010.txt",true))) {
					    String fileContent = title.text()+"\n";
					    bufferedWriter.write(fileContent);
					}
		            i++;
		        }
		        page++;
	        }
	        year--;
	        years--;
        }
    }
}
