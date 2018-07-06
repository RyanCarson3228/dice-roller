import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceRoller {

	public static void main(String[] args) {
		
		System.out.println("Please input your dice roll in \"xxdyy\" format.");
		System.out.println("For example, to roll four six-sided die you would input \"4d6\".");
		System.out.println("The program will show you both the total amount and individual dice rolls.");

		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		if(input.contains("d")) {
			
			String[] parts = input.split("d");

			String part0 = parts[0];
			int diceQuantity = Integer.parseInt(part0);

			String part1 = parts[1];
			int diceType = Integer.parseInt(part1);

			int diceTotal = 0;
			ArrayList<Integer> rollList = new ArrayList<>();

			for(int i = 1; i <= diceQuantity; i++) {
				rollList.add(ThreadLocalRandom.current().nextInt(1, diceType + 1));
				diceTotal = diceTotal + rollList.get(i- 1);
			}

			System.out.print(diceTotal + ":");

			for (int i = 0; i < rollList.size(); i++) {
				System.out.print(" " + rollList.get(i));
			}
			

		}else {
			throw new IllegalArgumentException("String " + input + " was input improperly. Please ensure you follow the directed format");
		}
	}
}
