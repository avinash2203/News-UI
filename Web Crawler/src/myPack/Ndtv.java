package myPack;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Ndtv {

	public static void main(String args[])
	{
		try {
			Document doc = Jsoup.connect("http://www.ndtv.com/india?pfrom=home-topnavigation").get();
			Elements date = doc.select("div.nstory_dateline");
			Elements head = doc.select("div.nstory_header");
			Elements body = doc.select("div.nstory_intro");
			
			for(int i=0;i<date.size()&&i<head.size()&&i<body.size();i++) {  
                //System.out.println("\nlink : http://www.ndtv.com/india?pfrom=home-topnavigation" + link.attr("href"));  
                System.out.println("Head : " + head.get(i).text());  
                System.out.println("Dateline : " + date.get(i).text());
                System.out.println("Description : " + body.get(i).text());
                System.out.println("");
            }  
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
