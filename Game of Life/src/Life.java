
public class Life {
	
	int generation = 0;
	
	public void transferData(int table[][], int data[][]) {
		for(int row = 1; row < table.length - 1; row++) {
			for(int col = 1; col < table[row].length - 1; col++) {
				table[row][col] = data[row][col];
			}
		}
	}
	
	public void liveOrDie(int table[][], int data[][]) {
		for(int row = 1; row < table.length - 1; row++) {
			for(int col = 1; col < table[row].length - 1; col++) {
				int a, b;
				a = row;
				b = col;
				int sum = table[a-1][b-1] + table[a-1][b] + table[a-1][b+1] + table[a][b+1] + table[a+1][b+1] + table[a+1][b] + table[a+1][b-1] + table[a][b-1];
				data[row][col] = sum;
			}
		}
			for(int row1 = 1; row1 < table.length -1; row1++) {
				for(int col = 1; col < table[row1].length - 1; col++) {
					boolean isEmpty = false;
					if(table[row1][col] == 0) {
						isEmpty = true;
					}
					if(isEmpty && data[row1][col] == 3) {
						table[row1][col] = 1;
					} else if(data[row1][col] <= 1 || data[row1][col] >= 4) {
						table[row1][col] = 0;
					} else if(data[row1][col] == 2 || data[row1][col] == 3) {
						table[row1][col] = table[row1][col];
					}
				}
			}
		generation++;
	}
	
	public void countGen(int table[][]) {
		int sum = 0;
		for(int row = 0; row < table.length; row++) {
			for(int col = 0; col < table[row].length; col++) {
				if(table[row][col] == 1) {
					sum++;
				}
			}
		}
		System.out.println(sum + " living organisms" + "\n");
	}
	
	public void printGrid(int table[][]) {
		System.out.println("Generation: " + generation);
		System.out.printf("%2s", "");
		for(int i = 1; i < 10; i++) {	
				System.out.printf("%1s", i);
		}
		System.out.printf("%1s", 0);
		for(int j = 1; j < 10; j++) {
			System.out.print(j);
		}
		System.out.print("");
		for(int row = 0; row < table.length - 1; row++) {
			System.out.printf("%1s", row);
			for(int col = 0; col < table[row].length; col++)   {
				if(table[row][col] == 1) {
					System.out.printf("%1s", "*");
				} else {
					System.out.printf("%1s", " ");
				}
				
			}
			System.out.println("");
		}
		System.out.println("");
	}
}

