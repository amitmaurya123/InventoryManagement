import java.util.Objects;
import java.util.UUID;

public class CartItem {
    private Product product;
    private int quantity;
    private String cartItemId;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.cartItemId = product.getProductId();
    }

    public void addQuantity(int qty){
        this.quantity = this.quantity + qty;
    }

    public void removeQuantity(int qty){
        this.quantity = this.quantity - qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product.getProductId());
    }

    @Override
    public boolean equals(Object o) {
        return product.getProductId().equals(((Product)o).getProductId());
    }

    @Override
    public String toString(){
        return "CartItem{"+
                "cartItemId='" + cartItemId + '\'' +
                ", quantity: " + quantity +
                "product: " + product;
    }
}
