package main.java.designpatterns.creational;

/**
 * This factory class returns different subclasses based on the input provided and factory class uses if-else or switch statement to achieve this. 
 * In the Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class. 
 * Then an Abstract Factory class that will return the sub-class based on the input factory class. 
 */
public class AbstractFactory {
/**
 * Lets you produce families of related objects without specifying their concrete classes.
 */
	interface Button {
		void onClick();
	}
	
	class AmazingMacOSButton implements Button {
		@Override
		public void onClick() {
			// TODO Auto-generated method stub
		}
	}
	class AmazingWindowsButton implements Button {
		@Override
		public void onClick() {
			// TODO Auto-generated method stub
		}
	}
	
	interface CheckBox {
		void isChecked();
	}
	
	class CoolWindowsCheckBox implements CheckBox {
		@Override
		public void isChecked() {
			// TODO Auto-generated method stub
		}
	}

	class CoolMacOsCheckBox implements CheckBox {
		@Override
		public void isChecked() {
			// TODO Auto-generated method stub
		}
	}
	
	interface GUIFactory {
		/**
		 * Abstract factory knows about all (abstract) product types.
		 */
		Button createButton();
		CheckBox createCheckBox();
	}
	
	class MacOsGuiFactory implements GUIFactory{
		/**
		 * Each concrete factory extends basic factory and responsible for creating
		 * products of a single variety.
		 */
		@Override
		public Button createButton() {
			return new AmazingMacOSButton();
		}

		@Override
		public CheckBox createCheckBox() {
			return new CoolMacOsCheckBox();
		}
	}
	
	class WindowsGuiFactory implements GUIFactory{
		/**
		 * Each concrete factory extends basic factory and responsible for creating
		 * products of a single variety.
		 */
		@Override
		public Button createButton() {
			return new AmazingWindowsButton();
		}

		@Override
		public CheckBox createCheckBox() {
			return new CoolWindowsCheckBox();
		}
	}
	
	/**
	 * Factory users don't care which concrete factory they use since they work with
	 * factories and products through abstract interfaces.
	 */
	class Application {
	    private Button button;
	    private CheckBox checkbox;

	    public Application(GUIFactory factory) {
	        button = factory.createButton();
	        checkbox = factory.createCheckBox();
	    }

	    public void actions() {
	        button.onClick();
	        checkbox.isChecked();
	    }
	}
	
	static Application configureApplication() {
		AbstractFactory abstractFactory = new AbstractFactory();
		Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = abstractFactory.new MacOsGuiFactory();
        } else {
            factory = abstractFactory.new WindowsGuiFactory();
        }
        app = abstractFactory.new Application(factory);
        
        return app;
    }
	public static void main(String[] args) {
		 Application app = configureApplication();
	     app.actions();
	}
}
