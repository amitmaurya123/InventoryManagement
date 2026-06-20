import java.util.*;

public class Cart {
    private String cartId;
    private Map<String,CartItem> cartItemMap;

    public Cart() {
        this.cartId = UUID.randomUUID().toString().substring(0,4);
        this.cartItemMap = new HashMap<>();
    }

    public void addItemInCart(CartItem cartItem){
        CartItem currentItemInCart = cartItemMap.getOrDefault(cartItem.getCartItemId(),null);
        if(currentItemInCart != null){
            currentItemInCart.addQuantity(cartItem.getQuantity());
        }
        else{
            cartItemMap.put(cartItem.getCartItemId(),cartItem);
        }
        System.out.println("Item added to cart: "+ cartItem);
    }

    public void increaseItemQtyInCart(String productId){
        CartItem cartItem = cartItemMap.get(productId);
        cartItem.addQuantity(1);
    }

    public void decreaseItemQtyInCart(String productId){
        CartItem cartItem = cartItemMap.get(productId);
        cartItem.removeQuantity(1);
        if(cartItem.getQuantity() == 0){
            cartItemMap.remove(productId);
            System.out.println("Product removed from cart: " + cartItem.getProduct());
        }
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItemList() {
        List<CartItem> cartItemList = cartItemMap.values().stream().toList();
        cartItemList.forEach(System.out::println);
        return cartItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", cartItems=" + cartItemMap.values() +
                '}';
    }
}
