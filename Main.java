import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{	
		Langtons langtons = new Langtons(200, 200);
		
		boolean[][] langtonPlane = langtons.getPlane();
		
		for (int i = 0; i < 200; i++)
		{
			for (int y = 0; y < 200; y++)
			{
				System.out.print(langtonPlane[y][i] ? "B" : " ");
			}
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
	}
}
