package main.java;

public class Sample {
	public static void main(String[] args) {
		Base b = new Base();
		Sub s = new Sub();
		b = s;
		System.out.println("test");
	}
}
class Base{
	
}

class Sub extends Base{
	
}
class Sub2 extends Base{
	
}