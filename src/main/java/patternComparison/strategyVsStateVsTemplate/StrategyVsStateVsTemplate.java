package patternComparison.strategyVsStateVsTemplate;

import patternComparison.strategyVsStateVsTemplate.state.OrderContext;
import patternComparison.strategyVsStateVsTemplate.strategy.FileCompressorContext;
import patternComparison.strategyVsStateVsTemplate.strategy.Lz4CompressionStrategy;
import patternComparison.strategyVsStateVsTemplate.strategy.RarCompressionStrategy;
import patternComparison.strategyVsStateVsTemplate.strategy.ZipCompressionStrategy;
import patternComparison.strategyVsStateVsTemplate.template.FileProcessorTemplate;
import patternComparison.strategyVsStateVsTemplate.template.Lz4FileProcessor;
import patternComparison.strategyVsStateVsTemplate.template.RarFileProcessor;
import patternComparison.strategyVsStateVsTemplate.template.ZipFileProcessor;

public class StrategyVsStateVsTemplate {

    public static void demonstrateStrategy() {
        System.out.println("=== STRATEGY PATTERN: Encapsulating Algorithms ===\n");

        FileCompressorContext compressor = new FileCompressorContext();
        String file = "document.txt";

        System.out.println("-- Using Strategy Pattern to compress a file with different, interchangeable algorithms --");

        // Algorithm changes independently of client
        System.out.println("Scenario 1: Small file, need speed, using Lz4CompressionStrategy...");
        compressor.setStrategy(new Lz4CompressionStrategy());
        compressor.compressFile(file);

        System.out.println("\nScenario 2: Large file, need compression ratio, using RarCompressionStrategy...");
        compressor.setStrategy(new RarCompressionStrategy());
        compressor.compressFile(file);

        System.out.println("\nScenario 3: Standard compression, using ZipCompressionStrategy...");
        compressor.setStrategy(new ZipCompressionStrategy());
        compressor.compressFile(file);

        System.out.println("\n✓ Algorithms change independently");
        System.out.println("✓ Client code unchanged");
        System.out.println("✓ Easy to add new compression algorithms");
    }

    public static void demonstrateState() {
        System.out.println("\n=== STATE PATTERN: State-Dependent Behavior ===\n");

        OrderContext order1 = new OrderContext("ORD001");

        System.out.println("-- Using State Pattern to process an order based on its state (i.e. PENDING, PROCESSING, SHIPPED, etc.) --");

        System.out.println("Order lifecycle:");
        System.out.println(">>> Initial Order State: " + order1.getState());
        order1.process(); // PENDING -> PROCESSING
        System.out.println(">>> Order State: " + order1.getState());
        order1.process(); // PROCESSING -> SHIPPED
        System.out.println(">>> Order State: " + order1.getState());
        order1.cancel(); // Try to cancel (not allowed when shipped)
        System.out.println(">>> Order State: " + order1.getState());
        order1.process(); // SHIPPED -> DELIVERED
        System.out.println(">>> Final Order State: " + order1.getState());

        System.out.println("\nDifferent order path:");
        OrderContext order2 = new OrderContext("ORD002");
        System.out.println(">>> Initial Order State: " + order2.getState());
        order2.cancel(); // PENDING -> CANCELLED
        System.out.println(">>> Order State: " + order2.getState());
        order2.process(); // Try to process (not allowed when cancelled)
        System.out.println(">>> Final Order State: " + order2.getState());

        System.out.println("\n✓ Behavior changes based on state");
        System.out.println("✓ State transitions encapsulated");
        System.out.println("✓ Eliminates complex conditional logic");
    }

    public static void demonstrateTemplateMethod() {
        System.out.println("\n=== TEMPLATE METHOD PATTERN: Inheritance-Based ===\n");

        FileProcessorTemplate zipProcessor = new ZipFileProcessor();
        FileProcessorTemplate rarProcessor = new RarFileProcessor();
        FileProcessorTemplate lz4Processor = new Lz4FileProcessor();

        System.out.println("Processing ZIP file:");
        zipProcessor.processFile("document.zip");

        System.out.println("\nProcessing RAR file:");
        rarProcessor.processFile("document.rar");

        System.out.println("\nProcessing LZ4 file:");
        lz4Processor.processFile("document.lz4");

        System.out.println("\n✗ Algorithm structure FIXED in base class");
        System.out.println("✗ Must subclass to add new format");
        System.out.println("✗ Cannot change structure without modifying base");
        System.out.println("✗ Less flexible than Strategy pattern");
    }

    public static void compareAllThreePatterns() {
        System.out.println("\n=== THREE-WAY COMPARISON ===\n");

        System.out.println("STRATEGY PATTERN (Composition):");
        System.out.println("  What varies: Entire compression algorithm");
        System.out.println("  Flexibility: ★★★★★ - Can swap at runtime");
        System.out.println("  Extensibility: Add new CompressionStrategy implementation");
        System.out.println("  Coupling: Low - Context → Strategy interface");
        System.out.println("  Example: FileCompressor uses any CompressionStrategy");

        System.out.println("\nSTATE PATTERN (Composition):");
        System.out.println("  What varies: Behavior based on current state");
        System.out.println("  Flexibility: ★★★★★ - States change automatically");
        System.out.println("  Extensibility: Add new OrderState implementation");
        System.out.println("  Coupling: Low - Context → State interface");
        System.out.println("  Example: OrderContext transitions through states");

        System.out.println("\nTEMPLATE METHOD (Inheritance):");
        System.out.println("  What varies: Individual steps of fixed algorithm");
        System.out.println("  Flexibility: ★★☆☆☆ - Structure fixed at compile-time");
        System.out.println("  Extensibility: Must create new subclass");
        System.out.println("  Coupling: High - Subclass coupled to base class");
        System.out.println("  Example: FileProcessor defines structure, subclasses fill steps");

        System.out.println("\n--- Key Insight ---");
        System.out.println("Strategy & State use COMPOSITION → High flexibility");
        System.out.println("Template Method uses INHERITANCE → Lower flexibility, simpler for basic cases");
    }

    public static void main(String[] args) {
        demonstrateStrategy();
        demonstrateState();
        compareAllThreePatterns();
    }
}

