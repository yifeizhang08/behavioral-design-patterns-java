package patternComparison.strategyVsStateVsTemplate.state;

// Concrete State object

public class ShippedState implements OrderState {
    OrderContext order;

    public ShippedState(OrderContext order) {
        this.order = order;
    }

    @Override
    public void processOrder() {
        System.out.println("Order " + order.getOrderId() + " delivered");
        order.setState(new DeliveredState(order));
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cannot cancel - order " + order.getOrderId() + " already shipped");
    }

    @Override
    public String getStateName() {
        return "SHIPPED";
    }
}
