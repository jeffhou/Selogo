package slogo_tests;
import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import commands.Command;
public class XMLReaderTest {



	public XMLReaderTest() {
	}

	protected Document makeDocumentFromFile(String fileName) {
		try {
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (Exception e) {
			return null;
		}
	}

	public void read(String filename, Map<String, Command> commands) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Document doc = this.makeDocumentFromFile(filename);
		NodeList nList = doc.getElementsByTagName("command");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				commands.put(eElement.getAttribute("code"),
						(Command) Class.forName(eElement.getAttribute("commandClass"))
						.newInstance());
			}
		}
	}


}
