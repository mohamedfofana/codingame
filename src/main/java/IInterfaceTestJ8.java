package main.java;

public interface IInterfaceTestJ8 {
	int i = 0;
	final int j = 0;
	static final int k = 0;
	static  int l = 0;
	
	default void defaultMethod(){
		System.out.println("Default Method");
	}
	
	static void staticMethod(){
		System.out.println("Static Method");
	}
	
	default void defaultMethod2(){
		System.out.println("Default Method 2");
	}
	
	static void staticMethod2(){
		System.out.println("Static Method 2");
	}
	void test();
}

