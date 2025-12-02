package patternComparison.strategyVsStateVsTemplate.state;

// State interface - encapsulates a family or algorithms; concrete State objects must implement

public interface OrderState {
    void processOrder();
    void cancelOrder();
    String getStateName();
}
