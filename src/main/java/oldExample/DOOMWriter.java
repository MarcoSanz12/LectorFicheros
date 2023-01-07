package oldExample;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DOOMWriter {

	public static void main(String[] args) {
		ArrayList<Pelicula> peliculas = LectorSAX.saxReader();

		try {
			Document document = createXMLPelicula(peliculas);

			saveXMLtoFile(document);
		} catch (ParserConfigurationException | IOException | TransformerException e) {

			e.printStackTrace();
		}

	}

	public static Document createXMLPelicula(ArrayList<Pelicula> peliculas) throws ParserConfigurationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element peliculasGeneral = doc.createElement("peliculas");

		for (Pelicula peli : peliculas) {

			/* Creación de elementos */
			Element ePelicula = doc.createElement("pelicula");

			Element eTitulo = doc.createElement("titulo");
			Element eTituloOriginal = doc.createElement("tituloOriginal");
			Element ePuntuacion = doc.createElement("puntuacion");
			Element eAnyo = doc.createElement("anyo");

			/* Creación de contenidos */

			Text tTitulo = doc.createTextNode(peli.getTitulo());
			Text tTituloOriginal = doc.createTextNode(peli.getTituloOriginal());
			Text tPuntuacion = doc.createTextNode(Double.toString(peli.getPuntuacion()));
			Text tAnyo = doc.createTextNode(Integer.toString(peli.getAnyo()));

			/* Asignación de contenidos */

			eTitulo.appendChild(tTitulo);
			eTituloOriginal.appendChild(tTituloOriginal);
			ePuntuacion.appendChild(tPuntuacion);
			eAnyo.appendChild(tAnyo);

			ePelicula.appendChild(eTitulo);
			ePelicula.appendChild(eTituloOriginal);
			ePelicula.appendChild(ePuntuacion);
			ePelicula.appendChild(eAnyo);

			peliculasGeneral.appendChild(ePelicula);

		}
		doc.appendChild(peliculasGeneral);

		return doc;

	}

	public static void saveXMLtoFile(Document doc) throws IOException, TransformerException {
		String filename = "src//xml//peliculas.xml";

		DOMSource domsource = new DOMSource(doc);
		FileWriter writer = new FileWriter(filename);
		StreamResult streamResult = new StreamResult(writer);

		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();

		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

		transformer.transform(domsource, streamResult);

		writer.close();

	}

}
