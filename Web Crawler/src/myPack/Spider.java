package myPack;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Spider {
	
	public static void main(String args[])
	{
		try {
			Document doc = Jsoup.connect("http://www.imdb.com/list/ls055386972/").userAgent("Mozilla/17.0").get();
			Elements temp = doc.select("div.info");
			//Elements links = doc.select("a[href]");
			int i = 1;
			for(Element movielist:temp)
			{
				System.out.println(i+" "+ movielist.getElementsByTag("a").first().text());
				//System.out.println(movielist.attr("abs:href"));
				i++;
			}
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
