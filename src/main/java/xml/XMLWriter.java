package xml;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class XMLWriter {
	public final String DEFAULT_ERROR_MESSAGE = "No deberías estar viendo esto";
	
	public String writeXML(ArrayList<String> elements) {
		
		String ERROR_MESSAGE = DEFAULT_ERROR_MESSAGE;
		try {
			SaveXMLToFile(XMLcreator(elements));
		} catch (IOException | TransformerException | ParserConfigurationException e) {
			ERROR_MESSAGE = "Se produjo un error durante la escritura del fichero";
			e.printStackTrace();
		}
		return ERROR_MESSAGE;
	}
	
	private Document XMLcreator(ArrayList<String> elements) throws ParserConfigurationException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document xml = db.newDocument();
		
		Element mainElement = xml.createElement("Elements");
		
		for (String s : elements) {
			Element eElement = xml.createElement("Element");
			Text tContent = xml.createTextNode(s);
			
			eElement.appendChild(tContent);
			eElement.setAttribute("id", String.valueOf(elements.indexOf(s)));
			mainElement.appendChild(eElement);
			
		}
		
		xml.appendChild(mainElement);
		
		return xml;
		
	}
	
	private void SaveXMLToFile(Document xml) throws IOException, TransformerException {
		String filename = System.getProperty("user.dir") + "/src/main/java/xml/resultado.xml";
		
		
		DOMSource domsource = new DOMSource(xml);
		FileWriter writer = new FileWriter(filename);
		StreamResult strResult = new StreamResult(writer);
		
		TransformerFactory trFac = TransformerFactory.newInstance();
		Transformer transformer = trFac.newTransformer();
		
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
		
		transformer.transform(domsource, strResult);
		
		Desktop.getDesktop().open(new File(filename));
		writer.close();
		
		
	}

}
