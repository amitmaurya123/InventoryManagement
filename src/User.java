import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String name;
    private String userId;
    private List<String> orderHistory;

    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID().toString().substring(0,4);
        orderHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getOrderHistory() {
        return orderHistory;
    }

    public void saveOrderHistory(String orderId){
        orderHistory.add(orderId);
    }

}
