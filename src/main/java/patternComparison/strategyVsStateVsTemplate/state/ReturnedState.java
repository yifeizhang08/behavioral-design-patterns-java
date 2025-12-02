package patternComparison.strategyVsStateVsTemplate.state;

// Concrete State object

public class ReturnedState implements OrderState {
    OrderContext order;

    public ReturnedState(OrderContext order) {
        this.order = order;
    }

    @Override
    public void processOrder() {
        System.out.println("Cannot process - order " + order.getOrderId() + " was returned");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order " + order.getOrderId() + " already returned");
    }

    @Override
    public String getStateName() {
        return "RETURNED";
    }
}
