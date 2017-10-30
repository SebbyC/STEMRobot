package com.chapter4.pa;

import java.io.File;

public class TransDriver
{

	public static void main(String[] args)
	{
		TransProj myTrans = new TransProj(new File("C:\\JavaTransfer\\TransProcessor\\Tran1.txt"));
				myTrans.TransProcessor();
	}

}
