package TransProcessor;
import java.util.Scanner;


// 10 / 30 / 2017 Implented TransReader into a Class file.

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
	DecimalFormat DF = new DecimalFormat("#.###");
	String line = "";
	int lineCounter = 1;
	int lineNumber = 1;
	String Delimiter;
	String Name;
	
	PrintWriter outFile;
		
	
	
	public TransProj(File Myfile1) 
	{
	
		try
		{
			transScanner = new Scanner(Myfile1);
			outFile = new PrintWriter("D:\\TransData.txt");
			
		} catch (FileNotFoundException e)
		{
			System.out.println("Invalid File:");
			e.printStackTrace();
		}
		
			
		
		
		
		
		
	}
	
	
	public static boolean ifOperator(String Op)
	{
		
		for( Operators F : Operators.values())
		{
			if(Op.equals(F.toString()))
				return true;

		}
		return false;
		
		
			
	}
	
	
	
	
	
	
	
	public void TransProcessor() throws IOException

	{
//		PrintWriter outFile = new PrintWriter("D:\\TransData.txt");
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
							break;
						
						}
					loopInput = lineScanner.next();
					if(loopInput.substring(0,1).equals("\""))
					{
						for( int i = 0; i < loops; i++)
						System.out.println(loopInput);
					break;
					}
						else
							{
							outFile.println("Line : " + lineNumber + " \nInvalid Parameter: " + input);
							break;
							}
					
					
					
				case "RDI":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
							break;
						
						}
					String num1 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
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
					}
					//Added try and catch for num2 10/30/17
					try {
					int2 = Integer.parseInt(num2);
					}
					catch(NumberFormatException e) {
						outFile.println("Line : " + lineNumber);
						outFile.println("\tInvalid Parameter: " + num2);
					}
					int randomNum = int1 + Gen.nextInt(Math.abs(int2));
					System.out.println(randomNum);
					break;
					
				case "MSR":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
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
						 break;
						 
					 }
					 {
						double sqrtNum = Math.sqrt(Dub);
						System.out.println(sqrtNum);
						break;
					}
					
				case "MDB":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
							break;
						
						}
					String dub1 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
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
					}
					//Added try and catch for dub2 10/30/17
					try {
					input4 = Double.parseDouble(dub2);
					}
					
					catch(NumberFormatException e) {
						 
						outFile.println("Line : " + lineNumber);
						 outFile.println("\tInvalid Parameter " + dub2);
						 
					 }
					System.out.println(input3 * input4);
					break;
				case "CRP":
					char char1 = 'a';
					char char2 = 'b';
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
							break;						
					}
					try {
						char1 = lineScanner.next().charAt(1);
						}
					catch(InputMismatchException e) 
					{
						outFile.println("Line : " + lineNumber);
						outFile.println("\tError: No parameter");
					}
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
							break;						
					}
					try {
						 char1 = lineScanner.next().charAt(1);
							}
						catch(InputMismatchException e) 
						{
							outFile.println("Line : " + lineNumber);
							outFile.println("\tError: No parameter");
						}
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
							break;						
					}
					String strReplace = lineScanner.next();
					strReplace.toLowerCase();
				
					String strReplaced = strReplace.replace(char1, char2);
					System.out.println(strReplaced);
						break;
				case "MRI":
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
							break;						
					}
					String num3 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
							break;						
					}
					String num4 = lineScanner.next();
					if(!lineScanner.hasNext())
					{
						outFile.println("Line : " + lineNumber) ;
						outFile.println("\tError: No Parameter ");
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
					
					for (int i = 0; i < input7; i++)
					{	
						randomInt = (int)(Math.random() * input6) + input5;
						System.out.print(randomInt + " ");
					
					}
					System.out.println();
						break;

					
		}
  lineNumber++;
	}
		
		
} // ENDS TRANSREADER METHOD
		outFile.close();
}
	}
