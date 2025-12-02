package patternComparison.strategyVsStateVsTemplate.state;

// Concrete State object

public class PendingState implements OrderState {
    OrderContext order;

    public PendingState(OrderContext order) {
        this.order = order;
    }

    @Override
    public void processOrder() {
        System.out.println("Processing payment for order " + order.getOrderId());
        order.setState(new ProcessingState(order));
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cancelling pending order " + order.getOrderId());
        order.setState(new CancelledState(order));
    }

    @Override
    public String getStateName() {
        return "PENDING";
    }
}
