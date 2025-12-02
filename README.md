# Behavioral Design Patterns

This project demonstrates all **11 Behavioral Design Patterns** from the Gang of Four, implemented in Java.

### GoF Behavioral Design Patterns:

1. Chain of Responsibility
2. Command
3. Interpreter
4. Iterator
5. Mediator
6. Memento
7. Observer
8. State
9. Strategy
10. Template Method
11. Visitor

## Pattern Comparison

Over the course of this project, we compare similar Behavioral Patterns on
how they do addressing key object-oriented design principles such as encapsulation of behavior,
loose coupling, extensibility, and performance.

This repo contains code examples to support the following comparisons:

---

### **1. Observer vs Command**: Decoupling Comparison

\_\_

Both the Observer and Command pattern emphasize _**loose coupling**_ between system components, however the do so in different way.

The **Observer pattern**
_**decouples subjects and observers dynamically**_ through a one-to-many relationship between the subject object and its dependent (observer) objects. Subjects maintain a collection of reference to dependents (which all adhere to a common Observer interface, allowing the Subject to remain unaware of the concrete details of their observers), and when the subject changes state, its dependents are notified.

The **Command Pattern** focuses on encapsulating a request as an object, thus _**decoupling the sender of a request from the object that executes that request**_ and allowing for features such as undo or deferred execution.
\_\_

_Example:_

The code demonstrating how these patterns compare form a _**decoupling and performance**_ perspective can be found here: [`patternComparison/observerVsCommand/`](src/main/java/patternComparison/observerVsCommand).

The demo can be run via the file: [ObserverVsCommand.java](src/main/java/patternComparison/observerVsCommand/src/main/java/patternComparison/observerVsCommand/ObserverVsCommand.java)

\_\_

_Findings:_

At a high level, both the Observer and Command patterns allow an action in one object (such as a state change or method call) to trigger behavior in another object, while keeping the two objects loosely coupled and unaware of each other’s implementation.

From a performance perspective, the time to notify observers with the Observer pattern scales linearly with the number of observers, O(_n_) execution for _n_ observers. The code demonstrates how the time to notify 1 observer vs 1000 observers increases by about 5x. This performance consideration could be significant if you are designing a system with many dependents. In this case, encapsulating operations via the Command Pattern could be a better solution, as the execution time for a single Command is O(1) and this pattern allows for operations to be queued (delayed execution) and undine/redone.

---

### **2. Strategy vs State vs Template**: Encapsulation Comparison

The Strategy, State, and Template patterns focus on encapsulating a certain set of behaviors as objects, and allowing these behaviors to be swapped at runtime.

The **Strategy Pattern** encapsulates an interchangeable family of algorithms by first defining a common interface that these algorithms must implement. This allows the Client to select which algorithm to use at runtime, offering future flexibility and extensibility as algorithms can be added or modified without affecting existing code.

The **State Pattern** encapsulates state-dependent behavior, meaning changes in object behavior happen automatically in response to state changes, making objects appear to have changed classes.

The **Template Pattern** allows for only partial encapsulation of an algorithm by defining the structure of an algorithm as an abstract class and defferring the implementation of certain steps to subclasses.

\_\_

_Example:_

The code demonstrating how these patterns compare form an _**encapsulation**_ perspective can be found here: [`patternComparison/strategyVsStateVsTemplate/`](src/main/java/patternComparison/strategyVsStateVsTemplate).

The demo can be run via the file: [StrategyVsStateVsTemplate.java](src/main/java/patternComparison/strategyVsStateVsTemplate/StrategyVsStateVsTemplate.java)

\_\_

_Findings:_

Both Strategy and State patterns favor **_Composition over Inheritance_** through behavior encapsulation, however the decision on which pattern to use has a lot to do with the use-case.

The Strategy Pattern could be more appropriate when you select an algorithm at runtime, and the context that is delegating to this algorithm object does not fundamentally change. Examples might include selecting between different file compression or sorting algorithms.

The State Pattern could prove more useful when the context object is changing conditions frequently, and certain behaviors are dependent on that state. In this case, you likely want the object to manage its own state transitions (as opposed to interventions from the client). Examples might include order processing or a document workflow.

If an algorithm always follows the same order of steps, but these steps may vary in implementation or occasionally be skipped all together, the Template Method could be a good choice, as it offers the simplest implementation of the three patterns. An example might be a file processing system, where the file is processed in the same order each time, but certain steps my vary depending on the file type.

While all patterns allow for operations to be encapsulated, the State and Strategy allow for encapsulation of the entire algorithm, meaning the steps and implementation of these algorithms can be as similar or dissimilar as desired. This offered a greater degree of flexibility over the Template Method.
