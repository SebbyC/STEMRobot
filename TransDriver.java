package TransProcessor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class TransDriver
{

	public static void main(String[] parms) throws IOException
	{
		
		String NAME = "";
		Scanner scan = new Scanner(System.in);
		if (parms.length > 0)
			NAME = (parms[0]);
		else
		{System.out.println("Please enter your name: ");
		NAME = scan.nextLine();}
		System.out.println(NAME);
		TransProj myTrans = new TransProj(new File("C:\\JavaTransfer\\TransProcessor\\Tran1.txt"));
				myTrans.TransProcessor();
	scan.close();
	}

}
