	
	import java.io.IOException;
	
	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.nodes.Element;
	import org.jsoup.select.Elements;
	
	
	public class FetchIMDBMovieLists {
	
		public static void main(String[] args){
			
			try{
				Document doc = Jsoup.connect("https://www.imdb.com/search/title?group"
						+ "s=top_250&sort=user_rating").userAgent("Mozilla/17.0").get();
				
				Elements temp = doc.select("div.lister-item-content");
				
				int i = 0;
				for(Element movieList:temp){
					++i;
					System.out.println(i + ". " + movieList.getElementsByTag("a").first().text());
				}
				
			}catch( Exception e){
				System.out.println("Something went wrong");
			}
			
		}
		
	}
