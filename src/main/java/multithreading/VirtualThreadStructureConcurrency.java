package main.java.multithreading;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.Stream;

/**
 * Structured concurrency treats groups of related tasks running in different threads as a single unit of work, 
 * thereby streamlining error handling and cancellation, improving reliability, and enhancing observability.
 * Java 21
 * The principal class of the structured concurrency API is StructuredTaskScope in the java.util.concurrent package. 
 */
public class VirtualThreadStructureConcurrency {
/**
 * Basic Usage of the StructuredTaskScope Class
	To use the StructuredTaskScope class, you follow these general steps:
	
	Create a StructuredTaskScope; use it with a try-with-resources statement.
	Define your subtasks as instances of Callable.
	Within the try block, fork each subtask in its own thread with StructuredTaskScope::fork.
	Call StructuredTaskScope::join.
	Handle the outcome from the subtasks.
	Ensure that the StructuredTaskScope is shut down.
 */
	public static void main(String[] args) {
//		 Callable<String> task1 = ...
//		 Callable<Integer> task2 = ...
//        try (var scope = new StructuredTaskScope<Object>()) {
//
//	        Subtask<String> subtask1 = scope.fork(task1);
//	        Subtask<Integer> subtask2 = scope.fork(task2);
//	        scope.join();
//        ... process results/exceptions ...
//
//		} // close
	}
}

/**
 * mplement Your Own StructuredTaskScope Policies
 * You can implement your own StructuredTaskScope policies that handle subtasks differently than ShutdownOnFailure and ShutdownOnSuccess. 
 * Do this by extending the StructuredTaskScope class.
 * @param <T>
 */
class CollectingScope<T> extends StructuredTaskScope<T> {
/**
 * The following example, CollectingScope, contains two methods that return two streams of subtasks of the same type: successfulTasks() 
 * returns a stream of successful subtasks, and failedTasks() returns a stream of subtasks that threw an exception:
 */
    private final Queue<Subtask<? extends T>> successSubtasks = new LinkedTransferQueue<>();
    private final Queue<Subtask<? extends T>> failedSubtasks = new LinkedTransferQueue<>();

    @Override
    protected void handleComplete(Subtask<? extends T> subtask) {
        if (subtask.state() == Subtask.State.SUCCESS) {
            successSubtasks.add(subtask);
        } else if (subtask.state() == Subtask.State.FAILED) {
            failedSubtasks.add(subtask);
        }
    }

    @Override
    public CollectingScope<T> join() throws InterruptedException {
        super.join();
        return this;
    }

    public Stream<Subtask<? extends T>> successfulTasks() {
        super.ensureOwnerAndJoined();
        return successSubtasks.stream();
    }
    
    public Stream<Subtask<? extends T>> failedTasks() {
        super.ensureOwnerAndJoined();
        return failedSubtasks.stream();
    }  
    
//    void handleBoth() throws InterruptedException {
//        try (var scope = new CollectingScope())  {
//            // var t = new SCRandomTasks();
//            var subtasks = IntStream.range(0, 5)
//                                    .mapToObj(i -> scope.fork(() -> randomTask(1000, 500)))
//                                    .toList();
//            scope.join();
//
//            var totalDuration = scope.successfulTasks()
//                                     .mapToInt(st -> (Integer)((Subtask)st).get())
//                                     .reduce(0, Integer::sum);
//            System.out.println("Total duration: " + totalDuration);
//            
//            scope.failedTasks()
//                 .forEach(ft ->
//                    System.out.println(((Exception)((Subtask)ft).exception()).getMessage()));
//        }        
//    }
}
