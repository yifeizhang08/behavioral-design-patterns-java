package behavioralDesignPatterns;

import behavioralDesignPatterns.chainOfResponsibility.ChainDemo;
import behavioralDesignPatterns.command.CommandDemo;
import behavioralDesignPatterns.interpreter.InterpreterDemo;
import behavioralDesignPatterns.iterator.IteratorDemo;
import behavioralDesignPatterns.mediator.MediatorDemo;
import behavioralDesignPatterns.memento.MementoDemo;
import behavioralDesignPatterns.observer.ObserverDemo;
import behavioralDesignPatterns.state.StateDemo;
import behavioralDesignPatterns.strategy.StrategyDemo;
import behavioralDesignPatterns.templateMethod.TemplateMethodDemo;
import behavioralDesignPatterns.visitor.VisitorDemo;

public class RunAllDemos {
    public static void main(String[] args) {
        System.out.println("--- 1. CHAIN OF RESPONSIBILITY ---");
        ChainDemo.main(args);
        System.out.println("--- 2. COMMAND ---");
        CommandDemo.main(args);
        System.out.println("--- 3. INTERPRETER ---");
        InterpreterDemo.main(args);
        System.out.println("--- 4. ITERATOR ---");
        IteratorDemo.main(args);
        System.out.println("--- 5. MEDIATOR ---");
        MediatorDemo.main(args);
        System.out.println("--- 6. MEMENTO ---");
        MementoDemo.main(args);
        System.out.println("--- 7. OBSERVER ---");
        ObserverDemo.main(args);
        System.out.println("--- 8. STATE ---");
        StateDemo.main(args);
        System.out.println("--- 9. STRATEGY ---");
        StrategyDemo.main(args);
        System.out.println("--- 10. TEMPLATE ---");
        TemplateMethodDemo.main(args);
        System.out.println("--- 11. VISITOR ---");
        VisitorDemo.main(args);
    }
}
