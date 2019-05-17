package main.java.annotation_injection_manuelle;

public class Presenter {
	@PleaseInject
	public Boundary boundary;

	@Override
	public String toString() {
		return "boundary = " + boundary;
	}
}
