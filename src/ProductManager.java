import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {
    private Map<String,Product> productMap;
    private static ProductManager instance;

    private ProductManager(){
        this.productMap = new HashMap<>();
    }

    public static ProductManager getInstance(){
        if(instance == null){
            instance = new ProductManager();
        }
        return instance;
    }

    public boolean placeOrder(Cart cart){
        List<CartItem> cartItemList = cart.getCartItemList();
        if(cartItemList == null){
            System.out.println("Your cart is empty!!");
            return false;
        }
        List<CartItem> outOfStockProducts = checkOutOfStockProducts(cartItemList);
        if(outOfStockProducts == null || outOfStockProducts.isEmpty()) {
            cartItemList.forEach(cartItem -> cartItem.getProduct().subtractQuantity(cartItem.getQuantity()));
            return true;
        }
        else {
            System.out.println("Some products are out of stock!!");
            outOfStockProducts.forEach(cartItem -> {
                System.out.println("Product : "+ cartItem.getProduct().getName() + " available qty: " + cartItem.getProduct().getCurrentQuantity() + " placed qty: " + cartItem.getQuantity());
            });
            return false;
        }
    }

    private List<CartItem> checkOutOfStockProducts(List<CartItem> cartItemList) {
        return cartItemList.stream().filter(cartItem ->
            cartItem.getProduct().getCurrentQuantity() < cartItem.getQuantity()
        ).toList();
    }
}
