package com.chapter4.pa;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Random;
public class TransProj
{
	Scanner transScanner;
	Scanner lineScanner;
	Random Gen = new Random();
	DecimalFormat DF = new DecimalFormat("#.###");
	String line = "";
	int lineCounter = 1;
	String Delimiter;
	
	
	
	public TransProj(File Myfile1) 
	{
	
		try
		{
			transScanner = new Scanner(Myfile1);
		} catch (FileNotFoundException e)
		{
			System.out.println("Invalid File:");
			e.printStackTrace();
		}
		
			
		
		
		
		
		
	}
	
	
	
	
	
	public void TransProcessor()

	{
		
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
			if (TransReader.ifOperator(input))
				switch (input) {

				case "FRE":
					loops = lineScanner.nextInt();
					String loopInput = lineScanner.next();
					if (loopInput.substring(0, 1).equals("\""))
					{
						for (int i = 0; i < loops; i++)
							System.out.println(loopInput);
						break;
					} else
					{
						System.out.println("Line : "+lineNumber + "\n\tError : Invalid Parameter: " + input);
						break;
					}
				case "RDI":
					String num1 = lineScanner.next();
					String num2 = lineScanner.next();
					int int1 = 0;
					int int2 = 0;
					try
					{
						int1 = Integer.parseInt(num1);
						int2 = Integer.parseInt(num2);
					} 
					catch (NumberFormatException e)
					{
						System.out.println("Line : "+lineNumber + "\n\tError: Invalid Parameter " + num1);
						break;

					}
					int randomNum = int1 + Gen.nextInt(Math.abs(int2));
					System.out.println(randomNum);
					break;

				case "MSR":
					String input2 = lineScanner.next();
					double Dub;
					try

					{
						Dub = Double.parseDouble(input2);
					} catch (NumberFormatException e)
					{

						System.out.println("Line : "+lineNumber + "\n\tError: Invalid Parameter " + input2);
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
}
	
}
