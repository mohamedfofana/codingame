package main.java.fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This abstract class is the superclass of all classes representing an output stream of bytes. 
 * An output stream accepts output bytes and sends them to some sink.
 */
public class OutputStreamMy {
	static void output() throws IOException {
		 OutputStream os = new FileOutputStream("file.txt"); 
	        byte b[] = {65, 66, 67, 68, 69, 70}; 
	          
	        //illustrating write(byte[] b) method 
	        os.write(b); 
	          
	        //illustrating flush() method 
	        os.flush(); 
	  
	        //illustrating write(int b) method 
	        for (int i = 71; i <75 ; i++)  
	        { 
	            os.write(i); 
	        } 
	          
	        os.flush(); 
	          
	        //close the stream 
	        os.close(); 
	}
}
