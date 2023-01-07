package oldExample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class LectorSAX {

	public static ArrayList<Pelicula> saxReader() {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			XMLSAXManagerPeliculas handler = new XMLSAXManagerPeliculas();
			File fichero = new File("src//xml//videodbCompleto.xml");
			
			saxParser.parse(fichero, handler);
			
			peliculas = handler.getFilmography();
			
			for (Pelicula peli : peliculas) {
				
				System.out.println("["+ (peliculas.indexOf(peli) + 1) + "]\n" + peli + "\n");
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			
			
		}
		return peliculas;
	}

}
