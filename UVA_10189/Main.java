import java.io.*;
import java.util.*;

class Main {
	static String ReadLn(int maxLg) // utility function to read from stdin
	{
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg));
	}

	public static void main(String args[]) // entry point from OS
	{
		Main myWork = new Main(); // create a dinamic instance
		myWork.Begin(); // the true entry point
	}
	void Begin()    
	{
		String input;
		StringTokenizer idata;
		int n,m;
		int counter=0;

		while ((input = Main.ReadLn (255)) != null)
		{
			counter++;
			idata = new StringTokenizer (input);
			n = Integer.parseInt (idata.nextToken());
			m = Integer.parseInt (idata.nextToken());
			if(n==0&&m==0)
			{
				System.exit(0);
			}else if(counter==1)
			{
				int[][] numberArray = new int[n+2][m+2];

				Main.inputMineArray(n,m,numberArray);
				System.out.printf( "Field #%d:\n",counter );
				displayInput(n,m,numberArray);

			}else
			{
				int[][] numberArray = new int[n+2][m+2];

				inputMineArray(n,m,numberArray);
				System.out.printf( "\nField #%d:\n",counter );
				displayInput(n,m,numberArray);

			}
		}
	}
	private static void inputMineArray(int n, int m,int[][] numberArray)
	{
		String input;

		for(int count=1; count<=n;count++)
		{
			if((input = Main.ReadLn (255)) != null)
			{
				char[] charArr = input.toCharArray();
				for(int count2=1;count2<=m;count2++)
				{
					if(charArr[count2-1]=='*')
					{
						numberArray[count-1][count2-1]+=1;
						numberArray[count-1][count2]+=1;
						numberArray[count-1][count2+1]+=1;
						numberArray[count][count2-1]+=1;
						numberArray[count][count2]+=9;
						numberArray[count][count2+1]+=1;
						numberArray[count+1][count2-1]+=1;
						numberArray[count+1][count2]+=1;
						numberArray[count+1][count2+1]+=1;
					}
				}
			}
		}
	}


	private static void displayInput(int n, int m,int[][] numberArray)
	{
		if(n>0&&m>0)
		{

			for(int count=1; count<=n;count++)
			{
				for(int count2=1; count2<=m;count2++)
				{
					if(numberArray[count][count2]>=9)
					{
						System.out.printf( "*");
					}
					else
					{
						System.out.printf( "%d",numberArray[count][count2] );
					}
					if(count2==m)
						System.out.printf("\n");
				}
			}
		}
	} 
}