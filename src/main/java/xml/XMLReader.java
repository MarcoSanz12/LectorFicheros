package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import xml.pojo.Film;

public class XMLReader {

	// XML ejemplo sacado de:
	//	https://gist.github.com/Abhishek249/6356baab2a5abb5008b6f836b78522cf
	
	public static ArrayList<Film> xmlReader(){
		ArrayList<Film> filmList = new ArrayList<>();
		
		
		try {
			SAXParserFactory saxFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxFactory.newSAXParser();
			XMLSAXManagerFilms handler = new XMLSAXManagerFilms();
			
			
			File file = new File(System.getProperty("user.dir") + "/src/main/java/xml/movies.xml");
			
			saxParser.parse(file, handler);
			
			filmList = handler.getFilms();
			
			for (Film film : filmList) {
				
				System.out.println("["+ (filmList.indexOf(film) + 1) + "]\n" + film + "\n");
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filmList;
	}

}
