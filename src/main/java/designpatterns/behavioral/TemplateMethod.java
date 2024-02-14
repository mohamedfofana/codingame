package main.java.designpatterns.behavioral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Template Method is a behavioral design pattern that allows you to defines a skeleton of an algorithm in a base class 
 * and let subclasses override the steps without changing the overall algorithm’s structure.
 */
public class TemplateMethod {
	/**
	 * 
	All non-abstract methods of java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer.

	All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap.

	In javax.servlet.http.HttpServlet class, all the doXXX() methods send the HTTP 405 “Method Not Allowed” error by default. However, you can override any of those methods to send a different response.

	Identification: Template Method can 
	 */
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        Network network = null;
	        System.out.print("Input user name: ");
	        String userName = reader.readLine();
	        System.out.print("Input password: ");
	        String password = reader.readLine();

	        // Enter the message.
	        System.out.print("Input message: ");
	        String message = reader.readLine();

	        System.out.println("\nChoose social network for posting message.\n" +
	                "1 - FacebookMeta\n" +
	                "2 - Twitter");
	        int choice = Integer.parseInt(reader.readLine());

	        // Create proper network object and send the message.
	        if (choice == 1) {
	            network = new FacebookMeta(userName, password);
	        } else if (choice == 2) {
	            network = new Twitter(userName, password);
	        }
	        network.post(message);
	    }
}
abstract class Network {
    String userName;
    String password;

    Network() {}

    /**
     * Publish the data to whatever network.
     */
    public boolean post(String message) {
        // Authenticate before posting. Every network uses a different
        // authentication method.
        if (logIn(this.userName, this.password)) {
            // Send the post data.
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}


class FacebookMeta extends Network {
    public FacebookMeta(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on FacebookMeta");
        return true;
    }

    public boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on FacebookMeta");
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        System.out.println("User: '" + userName + "' was logged out from FacebookMeta");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
class Twitter extends Network {

    public Twitter(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Twitter");
        return true;
    }

    public boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on Twitter");
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        System.out.println("User: '" + userName + "' was logged out from Twitter");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}