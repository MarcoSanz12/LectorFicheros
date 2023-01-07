package xml;

import java.util.ArrayList;
import java.util.Arrays;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xml.pojo.Film;

public class XMLSAXManagerFilms extends DefaultHandler {
	
	private ArrayList<Film> films = new ArrayList<Film>();
	private Film film;
	private boolean bTitle,bGenre,bDirector,bFamousFilm,bStudio,bYear;
	
	public void startDocument() throws SAXException {
		
	}
	
	public void endDocument() throws SAXException {
		
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("Movie")) {
			film = new Film();
		}else {
			bTitle = qName.equals("Title");
			bGenre = qName.equals("Genre");
			bDirector = qName.equals("First") || qName.equals("Last");
			bStudio = qName.equals("Studio");
			bYear = qName.equals("Year");
			if (bTitle) {
				if (attributes.getLength() > 0) {
					film.setRunTime(attributes.getValue(0));
				}
			}
			else if (qName.equals("Name")) {
				if (attributes.getLength() > 0) {
					film.setFamousFilm(attributes.getValue(0));
				}
			}
			
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String content = (String.valueOf(Arrays.copyOfRange(ch, start, start + length)));
		
		if(bTitle) {
			film.setTitle(content);
			System.out.println("Titulo: " + content);
			bTitle = false;
		}
		else if (bGenre) {
			film.setGenre(content);
			bGenre = false;
		}
		else if (bDirector) {
			if (film.getDirector().length() > 0) {
				content = " " + content;
			}
			film.setDirector(film.getDirector().concat(content));
			bDirector = false;
		}
		else if (bStudio) {
			film.setStudio(content);
			bStudio = false;
		}
		else if (bYear) {
			film.setYear(content);
			bYear = false;
		}
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if (qName.equals("Movie")) {
			films.add(film);
		}
	}
	
	public ArrayList<Film> getFilms(){
		return films;
	}

}
