import java.util.ArrayList;
import java.util.Scanner;

public class Money {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> moneyDeposits = new ArrayList<ArrayList<Integer>>();
		int tests = input.nextInt();
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
		int i = 0;
		for (i = 0; i < tests - 1; i++) {
			if (printAnswer(moneyDeposits.get(i))) {
				System.out.println("\n");
			}
		}
		printAnswer(moneyDeposits.get(i));
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

	public static boolean printAnswer(ArrayList<Integer> values) {
		boolean firstPrint = true;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) == Integer.MIN_VALUE) {
				if (firstPrint) {
					firstPrint = false;
				} else {
					System.out.println();
				}
				System.out.print(getMax(values, i--));
			}
		}
		return !firstPrint;
	}

}
