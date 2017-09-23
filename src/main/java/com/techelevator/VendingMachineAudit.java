package com.techelevator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class VendingMachineAudit {
	
	  public static void auditReport(String fileName, String[] input) {
	        PrintWriter printWriter = null;
	        
	        
	        try {
	        	
	            printWriter = new PrintWriter(new FileOutputStream(fileName));
	            for (int i = 0; i < input.length; i++) {
	                printWriter.println(input[i]);
	            }
	            
	            
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	       
	        
	        } finally {
	            if (printWriter != null) {
	                printWriter.close();
	            }
	       
	        }
	   
	  }

}
