package main.java;

public class Singleton {
	private Singleton() {
		// Implémentation
	}
	
	private static class SingletonHolder{
		private final static Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
	
}

class SingletonDCL {
	private static volatile SingletonDCL _instance = null;
	
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






class A {
	
}

interface IA {
	
}


class B {
	
}

interface IB {
	
}

class C extends A implements IA,IB  {
	
}