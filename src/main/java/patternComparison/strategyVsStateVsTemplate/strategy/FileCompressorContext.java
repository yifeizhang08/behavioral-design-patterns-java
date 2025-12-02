package patternComparison.strategyVsStateVsTemplate.strategy;

// Context - contains a reference to a ICompressionStrategy object

public class FileCompressorContext {
    private ICompressionStrategy strategy;

    public void setStrategy(ICompressionStrategy strategy) {
        this.strategy = strategy; // ICompressionStrategy can be changed at runtime
    }

    public void compressFile(String file) {
        if (strategy == null) {
            throw new IllegalStateException("No compression strategy set");
        }
        strategy.compress(file);
    }
}
