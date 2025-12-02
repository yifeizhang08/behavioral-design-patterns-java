package patternComparison.strategyVsStateVsTemplate.template;

// Subclass extending algorithm Template - partially encapsulates some algorithm steps

public class RarFileProcessor extends FileProcessorTemplate{
    @Override
    protected void readData(String filename) {
        System.out.println("Reading RAR compressed data");
    }

    @Override
    protected void processData(String filename) {
        System.out.println("Decompressing RAR data");
    }

    @Override
    protected boolean shouldValidate() {
        return false;
    }
}
