package main.java.fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamMy {
	static void readFile() throws IOException {
		 InputStream geek = null; 
	        try { 
	  
	            geek = new FileInputStream("ABC.txt"); 
	  
	            // read() method : reading and printing Characters 
	            // one by one 
	            System.out.println("Char : "+(char)geek.read()); 
	            System.out.println("Char : "+(char)geek.read()); 
	            System.out.println("Char : "+(char)geek.read()); 
	  
	            // mark() : read limiing the 'geek' input stream 
	            geek.mark(0); 
	  
	            // skip() : it results in redaing of 'e' in G'e'eeks 
	            geek.skip(1); 
	            System.out.println("skip() method comes to play"); 
	            System.out.println("mark() method comes to play"); 
	            System.out.println("Char : "+(char)geek.read()); 
	            System.out.println("Char : "+(char)geek.read()); 
	            System.out.println("Char : "+(char)geek.read()); 
	  
	            boolean check = geek.markSupported(); 
	            if (geek.markSupported()) 
	            { 
	                // reset() method : repositioning the stram to 
	                // marked positions. 
	                geek.reset(); 
	                System.out.println("reset() invoked"); 
	                System.out.println("Char : "+(char)geek.read()); 
	                System.out.println("Char : "+(char)geek.read()); 
	            } 
	            else
	                System.out.println("reset() method not supported."); 
	  
	  
	            System.out.println("geek.markSupported() supported"+ 
	                              " reset() : "+check); 
	  
	        } 
	        catch(Exception excpt) 
	        { 
	            // in case of I/O error 
	            excpt.printStackTrace(); 
	        } 
	        finally
	        { 
	            // releasing the resources back to the 
	            // GarbageCollector when closes 
	            if (geek!=null) 
	            { 
	                // Use of close() : closing the file 
	                // and releasing resources 
	                geek.close(); 
	            } 
	        } 
	}
}
