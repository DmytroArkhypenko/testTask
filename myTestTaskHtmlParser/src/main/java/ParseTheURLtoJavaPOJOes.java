import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class ParseTheURLtoJavaPOJOes {

    public synchronized static void parseProductsByPage(Elements productElements, List<Product> productList) {

        for (Element element : productElements) {
            Product product = new Product();

            String productIdForCurrentItem = element.attr("id");
            product.setProductId(productIdForCurrentItem);

            String brandNameForCurrentItem = element.select("div[class=sc-1gv4rhx-1 dHyWOl]").first().select("p").first().text();
            product.setBrandName(brandNameForCurrentItem);

            String currentPriceForCurrentItem = element.select("div[class=sc-1gv4rhx-7 dIxCnn]").first().select("span:first-of-type").first().text();
            product.setPrice(currentPriceForCurrentItem);

            Elements colorsElementsForCurrentItem = element.select("div[class=sc-1gv4rhx-8 dIFYRw]").first().select("ul[data-test-id=ColorContainer]").first().select("li[data-test-id=ColorBubble]");
            List<String> colorsListForCurrentItem = new ArrayList<String>();
            for (Element element1 : colorsElementsForCurrentItem
                    ) {
                String iterableColor = element1.attr("color");
                colorsListForCurrentItem.add(iterableColor);
            }
            product.setColorList(colorsListForCurrentItem);

            productList.add(product);
        }

    }
}
