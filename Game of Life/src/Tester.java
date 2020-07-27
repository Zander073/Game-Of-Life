import java.util.Scanner;
import java.io.*;

public class Tester {
	private static Scanner in;
	private static Scanner myObject;
	
	public static void main(String[] args) {
		
		int[][] table = new int[22][22];
		int[][] data = new int[22][22];
		String fileName = "life100.txt";
		int numGen = 0;
		
		myObject = new Scanner(System.in);
		while(true) {
			System.out.println("How many generations would you like to generate? (Must be at least 1 or greater)");
			numGen = myObject.nextInt();
			if(numGen >= 1) {
				break;
			}
		}
		
		Life x = new Life();
		loadData(fileName, table);
		x.printGrid(table);
		x.countGen(table);
		for(int i = 0; i < numGen; i++) {
			x.liveOrDie(table, data);
			x.printGrid(table);
			x.countGen(table);
		}
		
	}
		
	public static void loadData(String fileName, int table[][]) {
		try {
			in = new Scanner(new File(fileName));
			in.nextInt();
			while(in.hasNext()) {
				int row = in.nextInt() - 1;
				int col = in.nextInt() - 1;
				table[row + 1][col + 1]++;
			}
		} catch (IOException e) {
			System.out.println("Error" + e.getMessage());
		}
	}
}

