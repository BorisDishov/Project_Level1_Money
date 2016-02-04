import java.util.ArrayList;
import java.util.Scanner;

public class Money {
	
	 static boolean veryFirstPrint = true;
	 static int tests;

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> moneyDeposits = new ArrayList<ArrayList<Integer>>();
		getInput(moneyDeposits);
		for (int i = 0; i < tests; i++) {
			printAnswer(moneyDeposits.get(i));
		}
	}

	public static int getMax(ArrayList<Integer> values, int endIndex) {
		int max = values.get(0);
		int indexToDelete = 0;
		for (int i = 1; i < endIndex; i++) {
			if (values.get(i) > max) {
				max = values.get(i);
				indexToDelete = i;
			}
		}
		return values.remove(indexToDelete);
	}

	public static void printAnswer(ArrayList<Integer> values) {
		boolean firstPrintOfTheTest = true;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) == Integer.MIN_VALUE) {
				if (firstPrintOfTheTest) {
					if (!veryFirstPrint) {
						System.out.println("\n");
					}
					veryFirstPrint = false;
					firstPrintOfTheTest = false;
				} else {
					System.out.println();
				}
				System.out.print(getMax(values, i--));
			}
		}
	}

	public static void getInput(ArrayList<ArrayList<Integer>> moneyDeposits) {
		Scanner input = new Scanner(System.in);
		tests = input.nextInt();
		for (int i = 0; i < tests; i++) {
			moneyDeposits.add(new ArrayList<Integer>());
			int deposits = input.nextInt();
			for (int j = 0; j < deposits; j++) {
				if (input.nextInt() == 1) {
					moneyDeposits.get(i).add(input.nextInt());
				} else {
					moneyDeposits.get(i).add(Integer.MIN_VALUE);
				}
			}
		}
		input.close();
	}

}
