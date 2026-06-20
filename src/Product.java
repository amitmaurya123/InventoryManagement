import java.util.UUID;

public class Product {
    private String productId;
    private String name;
    private String description;
    private int currentQuantity;

    public Product(String name, String description, int currentQuantity) {
        this.name = name;
        this.description = description;
        this.currentQuantity = currentQuantity;
        this.productId = UUID.randomUUID().toString().substring(0,4);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public void addQuantity(int qty) {
        this.currentQuantity = this.currentQuantity + qty;
    }

    public void subtractQuantity(int qty){
        this.currentQuantity = this.currentQuantity - qty;
    }

    @Override
    public String toString(){
        return "Product Id = '" + productId + '\'' +
                ", name: " + name +
                ", current quantity: " + currentQuantity +
                ", desciption: " + description;
    }
}
