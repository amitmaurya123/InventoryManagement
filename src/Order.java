import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private Cart cart;
    private User user;
    private ProductManager productManager;

    public Order(Cart cart, User user) {
        this.orderId = UUID.randomUUID().toString().substring(0,4);
        this.cart = cart;
        this.user = user;
        this.productManager = ProductManager.getInstance();
    }

    public List<CartItem> getOrderList() {
        return cart.getCartItemList();
    }

    public Cart getCart() {
        return cart;
    }

    public String placeOrder(){
        boolean isPlaced = productManager.placeOrder(cart);
        if(isPlaced){
            System.out.println("Hurrayyy " + user.getName() + " your order has been placed. Order Id: " + orderId);
            OrderHistoryManager.getInstance().addOrder(this);
            user.saveOrderHistory(this.getOrderId());
            return orderId;
        }
        return "";
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
