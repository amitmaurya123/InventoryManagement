public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Fan" , "This is a fan for you", 10);
        Product p2 = new Product("Bulb", "This is a bulb", 15);

        User user1 = new User("Amit");
        User user2 = new User("Meraj");

        Cart cart = new Cart();
        cart.addItemInCart(new CartItem(p1,5));
        cart.addItemInCart(new CartItem(p2, 8));
        cart.getCartItemList();

        Cart cart2 = new Cart();
        cart2.addItemInCart(new CartItem(p1,5));
        cart2.addItemInCart(new CartItem(p2, 8));
        cart2.getCartItemList();

        Order order = new Order(cart,user1);
        String orderId = order.placeOrder();

        Order order2 = new Order(cart2,user2);
        String orderId2 = order2.placeOrder();

        OrderHistoryManager orderHistoryManager = OrderHistoryManager.getInstance();
        System.out.println();
        orderHistoryManager.getAllOrderItems(orderId);

        System.out.println();
        orderHistoryManager.getAllOrderItems(orderId2);

    }
}