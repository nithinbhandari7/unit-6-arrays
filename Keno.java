import java.util.Arrays;
import java.util.Scanner;

public class Keno {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int temp;
		int bet;
		int balance = 100;
		int[] sevenAr = new int[7];
		int[] twentyAr = new int[20];
		String wantToPlay = "Y";
		boolean endGame = false;
		
		System.out.println("Welcome to the Casino");
		System.out.print("What is your name? ");
		name = sc.next();
		
		while(wantToPlay.equals("Y") && endGame == false){
		bet = 0;
		for(int i = 0; i < sevenAr.length; i++) {
			sevenAr[i] = 0;
		}
		System.out.print("How much would you like to bet? ");
		bet = sc.nextInt();
		while(bet < 1 || bet > balance) {
			System.out.print("Please enter a valid number, your balance is $" + balance + ": ");
			bet = sc.nextInt();
		}
		balance -= bet;
		System.out.println("Please enter 7 different number from 1 - 80.");
		computerNums(twentyAr);
		for(int i = 1; i < 8; i++) {
			System.out.print("Enter number " + i + ": ");
			temp = sc.nextInt();
			temp = check(sevenAr, temp);
			sevenAr[i-1] = temp;
		}
		System.out.println("You chose: " + Arrays.toString(sevenAr));
		System.out.println("The computer chose: " + Arrays.toString(twentyAr));
		System.out.println("You matched " + numMatched(sevenAr, twentyAr) + " numbers, you win $" + winAmount(numMatched(sevenAr, twentyAr), bet));
		balance += winAmount(numMatched(sevenAr, twentyAr), bet);
		if(balance == 0) {
			endGame = true;
			System.out.println("Sorry, you ran out of money.");
		}
		if(endGame == false) {
			System.out.print(name + ", you have $" + balance + ", would you like to continue playing? (Enter Y or N): ");
			wantToPlay = sc.next();
			while(!(wantToPlay.equals("Y") || wantToPlay.equals("N"))) {
				System.out.println("Please enter Y or N: ");
				wantToPlay = sc.next();
			}
		}
		}
		System.out.println("Thank you for playing.");
	}
	
	private static int winAmount(int numMatches, int bet) {
		if(numMatches == 7)
			return 12000 * bet;
		else if (numMatches == 6)
			return 200 * bet;
		else if (numMatches == 5)
			return 20 * bet;
		else if (numMatches == 4)
			return bet;
		else
			return 0;
	}
	
	private static int numMatched(int[] sevenAr, int[] twentyAr) {
		int count = 0;
		for(int i = 0; i < sevenAr.length; i++) {
			if(contains(sevenAr[i], twentyAr))
				count += 1;
		}
		return count;
	}
	
	private static boolean contains(int num, int[] ar) {
		boolean temp = false;
		for(int i = 0; i < ar.length; i++) {
			if(num == ar[i])
				temp = true;
		}
		return temp;
	}
	
	private static int check(int[] ar, int num) {
		Scanner sc = new Scanner(System.in);
		int temp = num;
		while(temp > 80 || temp < 1 || contains(temp, ar)){
			if(temp > 80 || temp < 1) {
				System.out.print("Sorry, that number is outisde of the range, please enter another number between 1 and 80: ");
				temp = sc.nextInt();
			} else if(contains(temp, ar)) {
				System.out.print("Sorry you have already entered that number, please choose a different number: ");
				temp = sc.nextInt();
			}
		}
		return temp;
	}
	
	private static void computerNums(int[] ar) {
		boolean temp = false;
		int temp2 = 0;
		for(int i = 0; i < ar.length; i++) {
			temp2 = ((int)(80*Math.random())) + 1;
			if(contains(temp2, ar)) {
				while(contains(temp2, ar))
					temp2 = ((int)(80*Math.random())) + 1;
			}
			ar[i] = temp2;
		}
	}
}
