package patternComparison.strategyVsStateVsTemplate.strategy;

public class ZipCompressionStrategy implements ICompressionStrategy {
    @Override
    public void compress(String file) {
        System.out.println("Compressing " + file + " using ZIP algorithm (fast, moderate compression)");
    }
}
