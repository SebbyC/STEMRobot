package TransProject;

import java.io.File;
import java.io.IOException;

public class TransDriver
{

	public static void main(String[] args) throws IOException
	{
		boolean firstName = false;
		TransProj myTrans = new TransProj(new File("C:\\JavaTransfer\\TransProcessor\\TransCheck4M.txt"));

		for (int i = 0; i < args.length; i++)
		{
			String parm = args[i];
			if (parm.length() > 2 && parm.substring(0, 2).equalsIgnoreCase("/n"))
			{

				myTrans.firstName = parm.substring(2);
				firstName = true;

			}
			if (firstName)
			{
				myTrans.lastName = parm;
				firstName = false;
			}
		}

		myTrans.lineCounter();
		myTrans.TransProcessor();

	}

}
