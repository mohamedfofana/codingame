package main.java.designpatterns.creational;
/**
 * Despite this, there are quite a lot of Singleton examples in Java core libraries:

java.lang.Runtime#getRuntime()
java.awt.Desktop#getDesktop()
java.lang.System#getSecurityManager()
 */
public class Singleton {

	private static Singleton instance;
	public String value;

	private Singleton(String value) {
		// The following code emulates slow initialization.
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException ex) {
//			ex.printStackTrace();
//		}
		this.value = value;
	}

	public static Singleton getInstance(String value) {
		if (instance == null) {
			instance = new Singleton(value);
		}
		return instance;
	}

}
/***
 * 
 The approach taken here is called double-checked locking (DCL). It
 exists to prevent race condition between multiple threads that may
 attempt to get singleton instance at the same time, creating separate
 instances as a result.

 It may seem that having the `result` variable here is completely
 pointless. There is, however, a very important caveat when
 implementing double-checked locking in Java, which is solved by
 introducing this local variable.

 You can read more info DCL issues in Java here:
 https://refactoring.guru/java-dcl-issue
 */
class SingletonDCL {
	private static volatile SingletonDCL _instance;

	private SingletonDCL() {
		// Implémentation
	}

	public static SingletonDCL getInstance() {
		if (_instance == null) {
			synchronized(SingletonDCL.class) {
				if (_instance == null) {
					return new SingletonDCL();
				}
			}
		}
		return _instance;
	}
}

class SingletonHolder {
	private SingletonHolder() {
		// Implémentation
	}

	private static class Holder{
		private final static SingletonHolder instance = new SingletonHolder();
	}

	public static SingletonHolder getInstance() {
		return Holder.instance;
	}
}
/***
 * 
 The approach taken here is called double-checked locking (DCL). It
 exists to prevent race condition between multiple threads that may
 attempt to get singleton instance at the same time, creating separate
 instances as a result.

 It may seem that having the `result` variable here is completely
 pointless. There is, however, a very important caveat when
 implementing double-checked locking in Java, which is solved by
 introducing this local variable.

 You can read more info DCL issues in Java here:
 https://refactoring.guru/java-dcl-issue
 */
class SingletonDCLWithValue {
	// The field must be declared volatile so that double check lock would work
	// correctly.
	// volatile Memory Order
	//	We can use volatile to tackle the issues with Cache Coherence.
	//	To ensure that updates to variables propagate predictably to other threads, 
	//	we should apply the volatile modifier to those variables.

	//	This way, we can communicate with runtime and processor to not reorder any instruction involving the volatile variable. 
	//	Also, processors understand that they should immediately flush any updates to these variables.

	private static volatile SingletonDCLWithValue _instance;

	public String value;
	private SingletonDCLWithValue(String value) {
		this.value = value;
	}
	// The approach taken here is called double-checked locking (DCL). It
	// exists to prevent race condition between multiple threads that may
	// attempt to get singleton instance at the same time, creating separate
	// instances as a result.
	//
	// It may seem that having the `result` variable here is completely
	// pointless. There is, however, a very important caveat when
	// implementing double-checked locking in Java, which is solved by
	// introducing this local variable.
	//
	// You can read more info DCL issues in Java here:
	// https://refactoring.guru/java-dcl-issue
	public static SingletonDCLWithValue getInstance(String value) {
		if (_instance == null) {
			synchronized(SingletonDCLWithValue.class) {
				if (_instance == null) {
					return new SingletonDCLWithValue(value);
				}
			}
		}

		return _instance;
	}
}



