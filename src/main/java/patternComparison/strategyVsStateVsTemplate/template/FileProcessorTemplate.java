package patternComparison.strategyVsStateVsTemplate.template;

// Template Method allows for partial algorithm encapsulation through subclassing
// by declaring certain steps of the algorithms as abstract methods that subclasses must implement

abstract public class FileProcessorTemplate {
    // Template method - defines the algorithm structure
    public final void processFile(String filename) {
        openFile(filename);
        readData(filename);
        processData(filename);
        if (shouldValidate()) {
            validateData(filename);
        }
        closeFile(filename);
    }
    
    // Concrete methods - same for all subclasses
    private void openFile(String filename) {
        System.out.println("Opening file: " + filename);
    }
    
    private void closeFile(String filename) {
        System.out.println("Closing file: " + filename);
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract void readData(String filename);
    protected abstract void processData(String filename);
    
    // Hook method
    protected boolean shouldValidate() {
        return true;
    }
    
    // Hook with default implementation
    protected void validateData(String filename) {
        System.out.println("Default validation: checking file integrity");
    }
}