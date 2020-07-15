
import com.gargoylesoftware.htmlunit.Page;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //we get HTML page as a Document in order to perform selectors with it soon
        Document page = GetPage.getPage();

        //after we parse each item then we transform it to Java POJOes in order to manipulate with their data soon
        List<Product> productList = new ArrayList<Product>();

        //here we select the full table part of the page
        Elements theFullItemTable = page.select("div[class=ReactVirtualized__Grid__innerScrollContainer]");

        //then from that full table we select the rows that hold items
        Elements rowsOfItemTable = theFullItemTable.select("div[data-test-id=MixedTileRowContainer]");

        //for each row that holds items and data about current item we do selectors and then using the method parseProductsByPage we complete the List<Product> productList
        for (Element element : rowsOfItemTable) {

            Elements productElements = element.select("a[data-test-id=ProductTile]");
            ParseTheURLtoJavaPOJOes.parseProductsByPage(productElements, productList);
        }


        CreateXMLFileJava.createXMLFileJava(productList);
    }
}
