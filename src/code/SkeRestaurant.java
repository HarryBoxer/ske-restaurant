package code;

import java.util.Scanner;

/**
 * Main class for SKE Restaurarnt order taking application. It displays a menu
 * and accepts items to order. When done, it prints a receipt including the
 * order total.
 *
 * @author Sorrawit Tantharatana
 */

public class skerestaurant {

	static String[] menu = { "Pizza", "Chickens", "SKE Steak", "Coke" };
	static int[] price = { 250, 120, 99, 45 };
	static int[] quantity = { 0, 0, 0, 0 };
	static int[] bankMoney = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };

	static Scanner sc = new Scanner(System.in);

	static void pudMoney(double money, double tot) {

		for (int i = 0; i < bankMoney.length; i++) {
			if(i<5) {
				if ((int) Math.floor(money / bankMoney[i]) > 0) {
					System.out.printf("\t%d\tBaht banknotes\t= %d\n ", bankMoney[i], (int) Math.floor(money / bankMoney[i]));
					tot += Math.floor(money / bankMoney[i]);
					money = money % bankMoney[i];
				}
			}else {
				if ((int) Math.floor(money / bankMoney[i]) > 0) {
					System.out.printf("\t%d\tBaht coin\t= %d\n ", bankMoney[i],(int) Math.floor(money / bankMoney[i]));
					tot += Math.floor(money / bankMoney[i]);
					money = money % bankMoney[i];
				}
			}
		}
	}

	static void printMenu() {
		System.out.println("\n---------- Welcome to SKE Restaurant ----------\n");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d.) %s\t\t%d Baht. \n", i + 1, menu[i], price[i]);
		}
		System.out.printf("%d.) Total\n", menu.length + 1);
		System.out.printf("%d.) CashIn & Exit\n", menu.length + 2);
	}

	static int enterChoice() {
		System.out.print("Enter Your Choice: ");
		int chc = sc.nextInt();
		return chc;
	}

	static int enterQuantity() {
		System.out.print("Enter Quantity: ");
		int qty = sc.nextInt();
		return qty;
	}

	static void midTable() {
		System.out.println("\n+------------------+---------+-----------+");
	}

	static void thanks() {
		System.out.print("\n---------------- THANKYOU -----------------");
	}

	static void cash(double tot, double in) {

		System.out.printf("Cash OUT\n");
		double money = in - tot;
		System.out.printf("Changes %.0f Baht.", money);
		if (money == money) {
			System.out.println();
		}
		pudMoney(money, tot);
	}

	public static void main(String[] args) {
		int menuOne = 0, menuTwo = 0, menuThree = 0, menuFour = 0;
		int total = 0, count = 0;
		int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0;

		printMenu();

		do {
			System.out.println();
			int select = enterChoice();
			if (select == 1) {

				quantity[0] += enterQuantity();
				menuOne += quantity[0];
				counter1 = menuOne * price[0];
			}
			if (select == 2) {
				quantity[1] += enterQuantity();
				menuTwo += quantity[1];
				counter2 = menuTwo * price[1];
			}
			if (select == 3) {
				quantity[2] += enterQuantity();
				menuThree += quantity[2];
				counter3 = menuThree * price[2];
			}
			if (select == 4) {
				quantity[3] += enterQuantity();
				menuFour += quantity[3];
				counter4 = menuFour * price[3];
			}
			if (select == 5) {
				System.out.print("\n+------ Menu ------+-- Qty --+-- Price --+\n");
				if (menuOne >= 1) {
					System.out.printf("| Pizza\t\t   |\t %3d |\t %7d |", quantity[0], counter1);
					midTable();
				}
				if (menuTwo >= 1) {
					System.out.printf("| Chicken\t   |\t %3d |\t %7d |", quantity[1], counter2);
					midTable();
				}
				if (menuThree >= 1) {
					System.out.printf("| Coke\t\t   |\t %3d |\t %7d |", quantity[2], counter3);
					midTable();
				}
				if (menuFour >= 1) {
					System.out.printf("| SKESteak         |\t %3d |\t %7d |", quantity[3], counter4);
					midTable();
				}
				total = counter1 + counter2 + counter3 + counter4;
				System.out.printf("| Total \t\t\t\t %7d |", total);
				midTable();
				System.out.println();
			}
			if (select == 6) {
				total = counter1 + counter2 + counter3 + counter4;
				System.out.printf("Cash IN\t\t ");
				double in = sc.nextDouble();
				if (in < total) {
					System.out.printf("NOT ENOUGH MONEY!");
					count++;
				} else if (in == total) {
					System.out.print("\nNo Need To Change Back !\n");
					thanks();
					count++;
				} else {
					cash(total, in);
					thanks();
					count++;
				}
			}
		} while (count <= 0);
	}
}
