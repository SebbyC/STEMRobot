package com.chapter4.pa;

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

public class TransReader

{
	public enum Operators			
	{				DLM,FRE,RDI,MSR,MRI			}
	
	
	
	
	public static boolean ifOperator(String Op)
	{
		
		for( Operators F : Operators.values())
		{
			if(Op.equals(F.toString()))
				return true;

		}
		return false;
		
		
	
	}
	
	public static void main(String[] args) throws IOException

	{
		String Delimiter = "";
		DecimalFormat DF = new DecimalFormat("#.###");
		Random Gen = new Random();
		int lineCounter = 1;
		
		String line = "";
		String name;
		if(args.length > 0)
		 name = args[0];
		else
		{
			Scanner nameScan = new Scanner(System.in);
			System.out.println("Print you name");
			name =  nameScan.nextLine();
			nameScan.close();
		}
		System.out.println(name);
		Scanner lineScanner;
		
		Scanner transScanner = new Scanner(new File("C:\\JavaTransfer\\TransProcessor\\Tran1.txt"));
		
		PrintWriter outFile = new PrintWriter("D:\\TransData.txt");
		
		
		
		
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
		
		lineScanner.useDelimiter(Delimiter);
		//String word = lineScanner.next();
		//System.out.println(word);
		
		lineCounter++;

			
			while (lineScanner.hasNext())

			{
				String input = lineScanner.next();
				int loops;
				int lineNumber = 1;
				if(TransReader.ifOperator(input))
			switch(input) 
				{
			
				case "FRE":
					loops = lineScanner.nextInt();
					String loopInput = lineScanner.next() ;
					if(loopInput.substring(0,1).equals("\""))
					{for( int i = 0; i < loops; i++)
						System.out.println(loopInput);
					break;
					}
						else
							{System.out.println(lineNumber + "Invalid Parameter: " + input);
							break;
							}
				case "RDI":
					String num1 = lineScanner.next();
					String num2 = lineScanner.next();
					int int1;
					int int2;
					int1 = Integer.parseInt(num1);
					int2 = Integer.parseInt(num2);
					int randomNum = int1 + Gen.nextInt(int2);
					System.out.println(randomNum);
					break;
					
				case "MSR":
					  String input2 = lineScanner.next();
					  double Dub;
					 try
					 
					 {
					  Dub = Double.parseDouble(input2);
					 }
					 catch(NumberFormatException e) {
						 
						 System.out.println("Invalid Parameter " + input2);
						 break;
						 
					 }
					 {
						double sqrtNum = Math.sqrt(Dub);
						System.out.println(sqrtNum);
					}
					
				case "MDB":
					
				
				
				
				}		
				
			lineNumber++;
				
			}

		}
		
		
		
		
		
		// lineScanner.close();;
		outFile.close();
		transScanner.close();
	}

}
