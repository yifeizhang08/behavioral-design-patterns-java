package patternComparison.chainOfResponsibilityVsMediator;

import patternComparison.chainOfResponsibilityVsMediator.mediator.*;
import patternComparison.chainOfResponsibilityVsMediator.chainOfResponsibility.*;

public class ChainOfResponsibilityVsMediator {
    public static void demonstrateMediator() {
        System.out.println("=== MEDIATOR PATTERN: Centralized Communication ===\n");
        System.out.println("--- One 'ChatRoomMediator' object handles all communication between 'ChatUser' components ---");

        ChatMediator chatRoom = new ChatRoomMediator();

        User katherine = new ChatUser("Katherine", chatRoom);
        User yifei = new ChatUser("Yifei", chatRoom);
        User bill = new ChatUser("Bill", chatRoom);

        chatRoom.addUser(katherine);
        chatRoom.addUser(yifei);
        chatRoom.addUser(bill);

        katherine.send("Hello everyone!");
        System.out.println();
        bill.send("Hi all!");
        yifei.send("I love the Mediator Pattern!");

        System.out.println("\n--- Mediator Characteristics ---");
        System.out.println("✓ Centralized communication logic");
        System.out.println("✓ Components don't reference each other directly");
        System.out.println("✓ Easy to add new communication rules");
        System.out.println("✗ Mediator can become complex (God Object)");
    }

    public static void demonstrateMediatorComplexity() {
        System.out.println("\n=== MEDIATOR: Complexity Trade-off ===\n");

        ChatMediator moderatedRoom = new ModeratedChatRoomMediator();

        User kat = new ChatUser("Kat", moderatedRoom);
        User fei = new ChatUser("Fei", moderatedRoom);

        moderatedRoom.addUser(kat);
        moderatedRoom.addUser(fei);

        System.out.println("Testing moderation:");
        kat.send("This is spam!");
        System.out.println();
        kat.send("This is a legitimate message");

        System.out.println("\n--- Complexity Consideration ---");
        System.out.println("✓ All logic in one place (easier to find)");
        System.out.println("✗ Mediator accumulates responsibilities");
        System.out.println("✗ Can violate Single Responsibility Principle - Mediator responsible for sending messages between components AND filtering"); // Solution: Break complex mediator into smaller ones
    }

    public static void demonstrateChain() {
        System.out.println("\n=== CHAIN OF RESPONSIBILITY: Distributed Handling ===\n");
        System.out.println("--- 'SupportTicket' Request Objects are passed through a chain of objects in search of the correct Request Handler ---");

        // Build the chain
        SupportHandler level1 = new Priority1Support();
        SupportHandler level2 = new Priority2Support();
        SupportHandler level3 = new Priority3Support();

        level1.setNext(level2);
        level2.setNext(level3);

        // Process requests
        SupportTicket ticket1 = new SupportTicket("Password reset", 1);
        SupportTicket ticket2 = new SupportTicket("System outage", 3);
        SupportTicket ticket3 = new SupportTicket("Feature request", 2);

        System.out.println("Processing low priority ticket:");
        level1.handleRequest(ticket1);

        System.out.println("\nProcessing high priority ticket:");
        level1.handleRequest(ticket2);

        System.out.println("\nProcessing medium priority ticket:");
        level1.handleRequest(ticket3);

        System.out.println("\n--- Chain Characteristics ---");
        System.out.println("✓ Distributed responsibility");
        System.out.println("✓ Easy to add/remove handlers");
        System.out.println("✓ Loose coupling between handlers");
        System.out.println("✗ May traverse multiple handlers - potential performance implications");
    }

    public static void demonstrateChainPerformance() {
        System.out.println("\n=== CHAIN OF RESPONSIBILITY: Performance Implications ===\n");

        // Add logging to chain
        SupportHandler logger = new LoggingHandler();
        SupportHandler level1 = new Priority1Support();
        SupportHandler level2 = new Priority2Support();
        SupportHandler level3 = new Priority3Support();

        logger.setNext(level1);
        level1.setNext(level2);
        level2.setNext(level3);

        // High priority request goes through entire chain
        System.out.println("Worst case - a high priority request goes through the entire chain before being processed by last handler:");
        SupportTicket ticket = new SupportTicket("Critical database failure", 3);

        long start = System.nanoTime();
        logger.handleRequest(ticket);
        long end = System.nanoTime();

        System.out.println("\nTime: " + (end - start) + " ns");
        System.out.println("\n--- Performance Consideration ---");
        System.out.println("✗ Request may pass through multiple handlers");
        System.out.println("✗ O(n) complexity in worst case");
        System.out.println("✓ But improves scalability and separation");
        System.out.println("✓ Each handler is simple and focused");
    }

    public static void compareCoupling() {
        System.out.println("\n=== COUPLING COMPARISON ===\n");

        System.out.println("MEDIATOR:");
        System.out.println("- Components coupled to mediator only");
        System.out.println("- Components decoupled from each other");
        System.out.println("- Star topology: N components -> 1 mediator");
        System.out.println("- Coupling factor: N-to-1");

        System.out.println("\nWITHOUT MEDIATOR:");
        System.out.println("- Each component coupled to many others");
        System.out.println("- Mesh topology: N components -> N(N-1)/2 connections");
        System.out.println("- Coupling factor: N²");

        System.out.println("\nCHAIN OF RESPONSIBILITY:");
        System.out.println("- Each handler coupled to next handler only");
        System.out.println("- Linear topology: handler1 -> handler2 -> handler3");
        System.out.println("- Coupling factor: N-1 (sequential)");
        System.out.println("- Most loosely coupled pattern");
    }

    public static void compareModularity() {
        System.out.println("\n=== MODULARITY COMPARISON ===\n");

        System.out.println("MEDIATOR:");
        System.out.println("✓ Components are independent modules");
        System.out.println("✓ Easy to add new components");
        System.out.println("✓ Components don't know about each other");
        System.out.println("✗ Mediator knows about all components");
        System.out.println("✗ Mediator can become bloated");

        System.out.println("\nCHAIN OF RESPONSIBILITY:");
        System.out.println("✓ Handlers are independent modules");
        System.out.println("✓ Easy to add/remove/reorder handlers");
        System.out.println("✓ Each handler has single responsibility");
        System.out.println("✓ No central coordinator needed");
        System.out.println("✓ Better adherence to SRP");
    }

    public static void demonstrateScalability() {
        System.out.println("\n=== SCALABILITY & SEPARATION OF CONCERNS ===\n");

        System.out.println("CHAIN OF RESPONSIBILITY:");
        System.out.println("✓ Adding handler: Create new class, insert in chain");
        System.out.println("✓ Removing handler: Remove from chain, no other changes");
        System.out.println("✓ Each handler focuses on one concern");

        System.out.println("\nMEDIATOR:");
        System.out.println("✓ Adding component: Register with mediator");
        System.out.println("✗ Adding interaction: Modify mediator logic");
        System.out.println("✗ Multiple concerns may accumulate in mediator");

        System.out.println("\nConclusion:");
        System.out.println("Chain: Better separation, but slower (multiple handlers)");
        System.out.println("Mediator: Faster direct routing, but centralized complexity");
        System.out.println("Engineers must balance performance vs. design clarity");
    }

    public static void compareUseCases() {
        System.out.println("\n=== USE CASE COMPARISON ===\n");

        System.out.println("MEDIATOR best for:");
        System.out.println("- Complex interactions between many objects");
        System.out.println("- GUI components (button clicks, form validation)");
        System.out.println("- Chat rooms, game lobbies");
        System.out.println("- When components need to communicate with many others");
        System.out.println("Example: Air traffic control coordinating planes");

        System.out.println("\nCHAIN OF RESPONSIBILITY best for:");
        System.out.println("- Request processing with multiple possible handlers");
        System.out.println("- Support ticket systems, approval workflows");
        System.out.println("- Event handling, middleware pipelines");
        System.out.println("- When you don't know which handler will process request");
        System.out.println("Example: Customer support escalation levels");
    }

    public static void main(String[] args) {
        demonstrateMediator();
        demonstrateMediatorComplexity();
        demonstrateChain();
        demonstrateChainPerformance();
        compareCoupling();
        compareModularity();
        compareUseCases();
        demonstrateScalability();
    }

}
