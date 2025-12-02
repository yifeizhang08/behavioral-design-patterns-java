package patternComparison.strategyVsStateVsTemplate.state;

// Context - maintains an instance of a OrderState object (representing its current condition)

public class OrderContext {
    private OrderState currentState;
    private String orderId;

    public OrderContext(String orderId) {
        this.orderId = orderId;
        this.currentState = new PendingState(this);
    }

    public void setState(OrderState state) {
        this.currentState = state;
        System.out.println("Order " + orderId + " -> " + state.getStateName());
    }

    public String getState() {
        return currentState.getStateName();
    }

    // "handle" method - delegates logic to current state
    public void process() {
        currentState.processOrder();
    }

    // "handle" method - delegates logic to current state
    public void cancel() {
        currentState.cancelOrder();
    }

    public String getOrderId() {
        return orderId;
    }
}
