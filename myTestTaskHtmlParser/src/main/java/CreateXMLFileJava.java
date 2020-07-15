
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLFileJava {

    public static final String xmlFilePath = "xml/xmlFile.xml";

    public synchronized static void createXMLFileJava(List<Product> productList) {

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("productList");
            document.appendChild(root);

            //counter
            Integer i = 0;

            for (Product product : productList) {

                // productList consists of products
                Element productXML = document.createElement("product");

                root.appendChild(productXML);

                // set an attribute productId to current product
                Attr counter = document.createAttribute("num");
                counter.setValue(Integer.toString(i));
                productXML.setAttributeNode(counter);

                // productId
                Element productId = document.createElement("productId");
                productId.appendChild(document.createTextNode(product.getProductId()));
                productXML.appendChild(productId);

                // brandName element
                Element brandName = document.createElement("brandName");
                brandName.appendChild(document.createTextNode(product.getBrandName()));
                productXML.appendChild(brandName);

                // price element
                Element price = document.createElement("price");
                price.appendChild(document.createTextNode(product.getPrice()));
                productXML.appendChild(price);

                // colors list element
                Element colorsList = document.createElement("colorsList");
                List<String> colorsListOfCurrentProduct = product.getColorList();
                for (String color : colorsListOfCurrentProduct) {
                    Element currentColor = document.createElement("color");
                    currentColor.appendChild(document.createTextNode(color));
                    colorsList.appendChild(currentColor);
                }
                //colorsList.appendChild(document.createTextNode(product.getColorList()));
                productXML.appendChild(colorsList);
                i++;
            }

            System.out.println("The number of requests to the source by URL is 1 as I haven't got any ideas how to implement the task for the HTML page full-load in order to get all the items presented on page 1");
            System.out.println("The number of read items by the link is: " + i);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}