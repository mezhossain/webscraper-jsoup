package webscraper.jsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class App {
	public static void main(String[] args) {
		try {

			// Metallica Tour Dates
			Document tour = Jsoup.connect("https://www.metallica.com/tour/").get();
			System.out.println(tour.title() + "\n");
			for (Element row : tour.select(".show")) {
				final String date = row.select(".date-numbers p").text();
				final String city = row.select(".venue-city p").text();
				final String venue = row.select(".venue-name p").text();
				
				System.out.println("Date: " + date + " City: " + city + " Venue: " + venue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
