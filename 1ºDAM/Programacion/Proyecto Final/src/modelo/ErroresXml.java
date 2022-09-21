package modelo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ErroresXml {
	private Document document;
	private int contadorErrores;
	private String xmlPath;

	public ErroresXml() {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String xmlFileName = "errores.xml";
		String xmlFilePath = s + System.getProperty("file.separator") + xmlFileName;

		System.out.println(xmlFilePath);

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
		Document document = documentBuilder.newDocument();

		this.document = document;
		this.contadorErrores = 1;
		this.xmlPath = xmlFilePath;
	}

	public void escribirErr(Exception e) {
		Element errores = document.createElement("errores");
		this.document.appendChild(errores);

		Attr attr = document.createAttribute("código");
		attr.setValue(String.valueOf(this.contadorErrores));
		this.contadorErrores = this.contadorErrores++;
		errores.setAttributeNode(attr);

		Element error = document.createElement("error");
		error.appendChild(document.createTextNode(e.getMessage()));

		errores.appendChild(error);

	}

	public void crearErrXml() {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(this.document);
			StreamResult streamResult = new StreamResult(new File(this.xmlPath));

			try {
				transformer.transform(domSource, streamResult);
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}

	}
}
