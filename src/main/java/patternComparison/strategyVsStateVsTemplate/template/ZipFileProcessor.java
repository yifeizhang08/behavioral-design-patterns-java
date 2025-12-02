package patternComparison.strategyVsStateVsTemplate.template;

// Subclass extending algorithm Template - partially encapsulates some algorithm steps

public class ZipFileProcessor extends FileProcessorTemplate {
    @Override
    protected void readData(String filename) {
        System.out.println("Reading ZIP compressed data");
    }

    @Override
    protected void processData(String filename) {
        System.out.println("Decompressing ZIP data");
    }

    @Override
    protected void validateData(String filename) {
        System.out.println("ZIP validation: checking CRC32 checksums");
    }
}
