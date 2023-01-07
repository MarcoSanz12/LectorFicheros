package oldExample;

import java.util.ArrayList;
import java.util.Arrays;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLSAXManagerPeliculas extends DefaultHandler {

	boolean bTitulo, bTituloOriginal, bPuntuacion, bAnyo;
	private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
	private Pelicula pelicula;

	public void startDocument() throws SAXException {

	}

	public void endDocument() throws SAXException {

	}

	public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {

		if (qName.equals("movie")) {
			pelicula = new Pelicula();
		} else if (bTitulo = qName.equals("title")) {

		} else if (bTituloOriginal = qName.equals("originaltitle")) {

		} else if (bPuntuacion = qName.equals("value")) {

		} else if (bAnyo = qName.equals("year")) {
		}
		
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		String contenido = (String.valueOf(Arrays.copyOfRange(ch, start, start + length)));
		
		if (bTitulo) {
			pelicula.setTitulo(contenido);
			bTitulo = false;
		}
		else if (bTituloOriginal) {
			pelicula.setTituloOriginal(contenido);
			bTituloOriginal = false;
		}
		else if (bPuntuacion) {
			
			pelicula.setPuntuacion(Double.parseDouble(contenido));
			
				
			
			bPuntuacion = false;
		}
		else if (bAnyo) {
			
			pelicula.setAnyo(Integer.parseInt(contenido));

			
		
			bAnyo = false;
		}
		
	}
	
	public void endElement (String uri, String localName, String qName) throws SAXException{
		if (qName.equals("movie")) {
			peliculas.add(pelicula);
		}
		
	}
	
	public ArrayList<Pelicula> getFilmography () {
		
		return peliculas;
	}
}
