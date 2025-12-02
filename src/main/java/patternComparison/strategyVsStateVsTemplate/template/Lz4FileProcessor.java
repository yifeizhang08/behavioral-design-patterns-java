package patternComparison.strategyVsStateVsTemplate.template;

// Subclass extending algorithm Template - partially encapsulates some algorithm steps

public class Lz4FileProcessor extends FileProcessorTemplate {
    @Override
    protected void readData(String filename) {
        System.out.println("Reading LZ4 compressed data");
    }

    @Override
    protected void processData(String filename) {
        System.out.println("Decompressing LZ4 data (ultra fast)");
    }
}
