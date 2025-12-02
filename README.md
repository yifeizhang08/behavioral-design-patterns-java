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

### **1. Observer vs Command**: Decoupling Comparison

Both the Observer and Command pattern emphasize _**loose coupling**_ between system components, however the do so in different way.

The **Observer pattern**
_**decouples subjects and observers dynamically**_ through a one-to-many relationship between the subject object and its dependent (observer) objects. Subjects maintain a collection of reference to dependents (which all adhere to a common Observer interface, allowing the Subject to remain unaware of the concrete details of their observers), and when the subject changes state, its dependents are notified.

The **Command Pattern** focuses on encapsulating a request as an object, thus _**decoupling the sender of a request from the object that executes that request**_ and allowing for features such as undo or deferred execution.

_Findings:_

At a high level, both the Observer and Command patterns allow an action in one object (such as a state change or method call) to trigger behavior in another object, while keeping the two objects loosely coupled and unaware of each other’s implementation.

From a performance perspective, the time to notify observers with the Observer pattern scales linearly with the number of observers, O(_n_) execution for _n_ observers. The code demonstrates how the time to notify 1 observer vs 1000 observers increases by about 5x. This performance consideration could be significant if you are designing a system with many dependents. In this case, encapsulating operations via the Command Pattern could be a better solution, as the execution time for a single Command is O(1) and this pattern allows for operations to be queued (delayed execution) and undine/redone.

_Example:_

The code demonstrating how these patterns compare form a _**decoupling and performance**_ perspective can be found here: [`patternComparison/observerVsCommand/`](src/main/java/patternComparison/observerVsCommand).

The demo can be run via the file: [ObserverVsCommand.java](src/main/java/patternComparison/observerVsCommand/src/main/java/patternComparison/observerVsCommand/ObserverVsCommand.java)
