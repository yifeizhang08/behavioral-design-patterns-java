package patternComparison.strategyVsStateVsTemplate.state;

// Concrete State object

public class CancelledState implements OrderState {
    OrderContext order;

    public CancelledState(OrderContext order) {
        this.order = order;
    }

    @Override
    public void processOrder() {
        System.out.println("Cannot process - order " + order.getOrderId() + " was cancelled");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order " + order.getOrderId() + " already cancelled");
    }

    @Override
    public String getStateName() {
        return "CANCELLED";
    }
}
