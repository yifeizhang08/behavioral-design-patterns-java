package patternComparison.strategyVsStateVsTemplate.state;

// Concrete State object

public class DeliveredState implements OrderState {
    OrderContext order;

    public DeliveredState(OrderContext order) {
        this.order = order;
    }

    @Override
    public void processOrder() {
        System.out.println("Order " + order.getOrderId() + " already delivered");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Processing return for delivered order " + order.getOrderId());
        order.setState(new ReturnedState(order));
    }

    @Override
    public String getStateName() {
        return "DELIVERED";
    }
}
