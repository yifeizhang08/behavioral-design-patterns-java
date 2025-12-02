package patternComparison.strategyVsStateVsTemplate.state;

// Concrete State object

public class ProcessingState implements OrderState {
    OrderContext order;

    public ProcessingState(OrderContext order) {
        this.order = order;
    }

    @Override
    public void processOrder() {
        System.out.println("Shipping order " + order.getOrderId());
        order.setState(new ShippedState(order));
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cannot cancel - order " + order.getOrderId() + " already processing");
    }

    @Override
    public String getStateName() {
        return "PROCESSING";
    }
}
