package patternComparison.strategyVsStateVsTemplate.strategy;

public class Lz4CompressionStrategy implements ICompressionStrategy {
    @Override
    public void compress(String file) {
        System.out.println("Compressing " + file + " using LZ4 algorithm (very fast, low compression)");
    }
}
