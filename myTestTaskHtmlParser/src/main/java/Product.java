import java.util.List;

public class Product {
    private String productId;
    private String brandName;
    private String price;
    private List<String> colorList;

    public Product() {
    }

    public Product(String productId, String brandName, String price, List<String> colorList) {
        this.productId = productId;
        this.brandName = brandName;
        this.price = price;
        this.colorList = colorList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrandName() {

        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }
}
