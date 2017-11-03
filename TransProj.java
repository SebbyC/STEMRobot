package TransProject;
//*****************************************************
//  Author: Sebastian Colon / Kellen Tison
//
///
//
//********************************************
import java.util.Scanner;


// 10 / 30 / 2017 Implented TransReader into a Class file.
//10 / 31 / 2017 ADDED BREAKS FOR NO PARAMETER CASES

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;




public class TransProj
{
	public enum Operators			
	{				DLM,FRE,RDI,MSR,MRI,CRP			}
	Scanner transScanner;
	Scanner lineScanner;
	Random Gen = new Random();
	DecimalFormat DF = new DecimalFormat("#.##");
	String line = "";
	int lineCounter = 1;
	int lineNumber = 1;
	String Delimiter;
	String firstName = "";
	String lastName = "";
	double actions = 0;
	double invalidActions = 0;
	int totalLines = 0;
	File Myfile1;
	static PrintWriter outFile;
		
	
	
	public TransProj(File Myfile) 
	{
	  
		try
		{
			transScanner = new Scanner(Myfile);
			outFile = new PrintWriter("D:\\TransData.txt");
			Myfile1 = Myfile;
		} catch (FileNotFoundException e)
		{
			System.out.println("Invalid File:");
			e.printStackTrace();
		}
		
			
		
		
		
		
		
	}
	
	
	public static boolean ifOperator(String Op) // CHECK IF VALID ENUM
	{
		
		for( Operators F : Operators.values())
		{
			if(Op.equals(F.toString()))
				return true;

		}
		return false;
		
		
		
			
	}
	
	
	
	public void lineCounter() throws IOException // COUNTS ALL LINES IN THE FILE
	{
		
		while(transScanner.hasNextLine())
		{
			transScanner.nextLine();
			totalLines++;
		
			
			
		}
		System.out.println(totalLines);
		transScanner.reset();
		transScanner = new Scanner(Myfile1);
	}
	
	public void nameChecker() throws IOException  // SCANS WHOLE FILE FOR NAME
	{
		
		if(firstName.length() == 0)
		{
		       while(transScanner.hasNext()) {
				
		    	   line = transScanner.nextLine();
		    	   lineScanner = new Scanner(line);
		    	   if(line.length() > 2)
				{
				if(line.substring(0,2).equalsIgnoreCase("/N"))
					{

					lineScanner.useDelimiter(" ");
					if(lineScanner.hasNext())
						lineScanner.next();
					if(lineScanner.hasNext())				
						firstName = lineScanner.next();
					if(lineScanner.hasNext())
						lastName = lineScanner.next();
				System.out.println("Hi  " + firstName + " " + lastName);
				continue;
					}
				}
//				if(firstName.length() == 0)
//				{
//					line = transScanner.nextLine();
//				
//					
//				}
				if(firstName.length() > 0)
				{
					transScanner.reset();
					break;
				}
		     }
		}
		
		
		transScanner.reset();
		transScanner = new Scanner(Myfile1);
	}
	
	public void TransProcessor() throws IOException

	{
//		PrintWriter outFile = new PrintWriter("D:\\TransData.txt");
		Scanner scan = new Scanner(System.in);
		nameChecker();
		if(firstName.length() == 0)
		{			System.out.println("Please enter a Name: " );
				firstName = scan.nextLine();
		}
		scan.close();
			
		while (transScanner.hasNext())
		{
			
			
			line = transScanner.nextLine();
			
			lineScanner = new Scanner(line);
			
					
		if(lineCounter == 1)
			{
			
			if(line.length() > 3)
			{
				if(line.substring(0,3).equals("DLM")) 
				{
					 Delimiter = line.substring(3,4);
				}
			}	
				else
				{
				System.out.println("Error: Misplaced Trans Code:  " + "\n Line One : " + line );
				 break;
				}
			}
			
		

		//lineScanner2.close();
		lineScanner.useDelimiter(Delimiter);
		//String word = lineScanner.next();
		//System.out.println(word);
		
		lineCounter++;
		while (lineScanner.hasNext())

		{
				
					
			String input = lineScanner.next();
			int loops;
			
			//int lineNumber = 1;
			
			
			if (ifOperator(input))
				switch(input) 
				{
			
				case "FRE":
					loops = lineScanner.nextInt();
					String loopInput = "";
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;

						
					}
					loopInput = lineScanner.next();
					System.out.println(firstName + " FRE CASE:");
					if(loopInput.substring(0,1).equals("\""))
					{
						for( int i = 0; i < loops; i++)							
						System.out.println("\t" + loopInput);
					break;
					}
						else
							{
							
							outFile.println(firstName +" Line : " + lineNumber + " \nInvalid Parameter: " + input);
							invalidActions++;
							break;
							}
					
					
					
				case "RDI":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;
						
						}
					String num1 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;
						break;
						
						}
					String num2 = lineScanner.next();
					int int1 = 0;
					int int2 = 0;
					//Added try and catch for num1 10/30/17
					try {
					int1 = Integer.parseInt(num1);
					}
					catch(NumberFormatException e) {
						outFile.println("Line : " + lineNumber);
						outFile.println("\tInvalid Parameter: " + num1);
						invalidActions++;
						break;
					}
					//Added try and catch for num2 10/30/17
					try {
					int2 = Integer.parseInt(num2);
					}
					catch(NumberFormatException e) {
						outFile.println("Line : " + lineNumber);
						outFile.println("\tInvalid Parameter: " + num2);
						invalidActions++;
						break;
					}
					int randomNum = int1 + Gen.nextInt(Math.abs(int2));
					System.out.println(firstName + " RDI CASE: \n\t" + randomNum);
					actions++;
					break;
					
				case "MSR":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;
						
						}
					String input2 = lineScanner.next();
					  double Dub;
					 try
					 
					 {
					  Dub = Double.parseDouble(input2);
					 }
					 catch(NumberFormatException e) {
						 outFile.println("Line : " + lineNumber);
						 outFile.println("\tInvalid Parameter " + input2);
						 invalidActions++;
						 break;
						 
					 }
					 {
						double sqrtNum = Math.sqrt(Dub);
						System.out.println(firstName + " MSR CASE :\n\t" + sqrtNum);
						actions++;
						break;
					}
					
				case "MDB":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;
						
						}
					String dub1 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;
						
					}
					String dub2 = lineScanner.next();
					double input3 = 0;
					double input4 = 0;
					//Added try and catch for dub1 10/30/17
					try {
					input3 = Double.parseDouble(dub1);
					}
					catch(NumberFormatException e) {
						
						outFile.println("Line : " + lineNumber);
						 outFile.println("\tInvalid Parameter " + dub1);
						 invalidActions++;
						 break;
					}
					//Added try and catch for dub2 10/30/17
					try {
					input4 = Double.parseDouble(dub2);
					}
					
					catch(NumberFormatException e) {
						 
						outFile.println("Line : " + lineNumber);
						 outFile.println("\tInvalid Parameter " + dub2);
						 invalidActions++;
						 break;
						 
					 }
					System.out.println(firstName + " MDB CASE : \n\t" + (input3 * input4));
					break;
				case "CRP":
					char char1 = 'a' ;
					 char char2 = 'a' ;
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;						
					}
					String input1 = lineScanner.next();
					if(input1.length() > 2)	  
						char1 = input1.charAt(1);
					
					
						 
						
				
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;						
					}
					input2 = lineScanner.next();
					if(input2.length() > 2)	  
					char2 = input2.charAt(1);
				
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;
							break;						
					}
					String strReplace = lineScanner.next();
					strReplace = strReplace.toLowerCase();
					char1 = Character.toLowerCase(char1);
					char2 = Character.toLowerCase(char2);
				
					String strReplaced = strReplace.replace(char1, char2);
					System.out.println(firstName + " CRP CASE \n\t" + strReplaced);
					actions++;	
					break;
						
						
				case "MRI":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;						
					}
					String num3 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;						
					}
					String num4 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
						invalidActions++;	
						break;						
					}
					String num5 = lineScanner.next();
					
					int input5 = 0;
					int input6 = 0;
					int input7 = 0;
					int randomInt = 0;
					input5 = Integer.parseInt(num3);
					input6 = Integer.parseInt(num4);
					input7 = Integer.parseInt(num5);
					System.out.println(firstName + " MRI CASE: ");
					for (int i = 0; i < input7; i++)
					{	
						randomInt = (int)(Math.random() * input6) + input5;
						System.out.print("\t" + randomInt + " ");
					
					}
					System.out.println();
					actions++;	
					break;
						
		}
  lineNumber++;
	}
		
		
} // ENDS TRANSREADER METHOD
		outFile.println("Invalid Transactions : " + invalidActions);
		outFile.println("Valid Transactions : " + actions);
		//System.out.println(actions+  "\t" + invalidActions);
//		double ErrorPerc = (invalidActions / actions);
//		//System.out.println(ErrorPerc);
//		String ErrorPerc1 = String.valueOf(ErrorPerc);
//		//System.out.println(ErrorPerc1); 
//		ErrorPerc1 = DF.format(ErrorPerc);
//		// System.out.println(ErrorPerc1);
//		 ErrorPerc = Double.parseDouble(ErrorPerc1) * 100;
//		outFile.println("Error Perct : " + (ErrorPerc) + "% ");
		outFile.close();
}
	}
