package patternComparison.strategyVsStateVsTemplate.strategy;

public class RarCompressionStrategy implements ICompressionStrategy {
    @Override
    public void compress(String file) {
        System.out.println("Compressing " + file + " using RAR algorithm (slower, high compression)");
    }
}
