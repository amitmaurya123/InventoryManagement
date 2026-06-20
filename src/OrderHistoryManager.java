import java.util.HashMap;
import java.util.Map;

public class OrderHistoryManager {
    private Map<String,Order> orderMap;
    private static OrderHistoryManager instance;

    private OrderHistoryManager(){
        this.orderMap = new HashMap<>();
    }

    public static OrderHistoryManager getInstance(){
        if(instance == null){
            instance = new OrderHistoryManager();
        }
        return instance;
    }

    public void addOrder(Order order){
        orderMap.put(order.getOrderId(), order);
    }

    public void getAllOrderItems(String orderId){
        Order order = orderMap.getOrDefault(orderId,null);
        if(order == null){
            System.out.println("Invalid order id");
            return;
        }
        order.getOrderList();
    }
}
