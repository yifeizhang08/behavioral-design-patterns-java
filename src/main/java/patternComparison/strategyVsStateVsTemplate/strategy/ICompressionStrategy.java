package patternComparison.strategyVsStateVsTemplate.strategy;

// Strategy Interface - defines interface for a family of algorithms that all Concrete Strategies must implement

public interface ICompressionStrategy {
    void compress(String file);
}
