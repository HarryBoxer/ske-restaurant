package code;

import java.util.Scanner;

public class restaurantmethod {

	static String[] menu = { "Pizza" , "Chickens" , "SKE Steak" , "Coke" };
	static int[] price = { 250, 120, 99, 45 };
	static int[] quantity = { 0, 0, 0, 0 };

	static Scanner sc = new Scanner(System.in);

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
		if ((int) Math.floor(money / 1000) > 0) {
			System.out.println("\t1000\tBaht banknotes\t= " + (int) Math.floor(money / 1000));
			tot += Math.floor(money / 1000);
			money = money % 1000;
		}
		if ((int) Math.floor(money / 500) > 0) {
			System.out.println("\t500\tBaht banknotes\t= " + (int) Math.floor(money / 500));
			tot += Math.floor(money / 500);
			money = money % 500;
		}
		if ((int) Math.floor(money / 100) > 0) {
			System.out.println("\t100\tBaht banknotes\t= " + (int) Math.floor(money / 100));
			tot += Math.floor(money / 100);
			money = money % 100;
		}
		if ((int) Math.floor(money / 50) > 0) {
			System.out.println("\t50\tBaht banknotes\t= " + (int) Math.floor(money / 50));
			tot += Math.floor(money / 50);
			money = money % 50;
		}
		if ((int) Math.floor(money / 20) > 0) {
			System.out.println("\t20\tBaht banknotes\t= " + (int) Math.floor(money / 20));
			tot += Math.floor(money / 20);
			money = money % 20;
		}
		if ((int) Math.floor(money / 10) > 0) {
			System.out.println("\t10\tBaht coins\t= " + (int) Math.floor(money / 10));
			tot += Math.floor(money / 10);
			money = money % 10;
		}
		if ((int) Math.floor(money / 5) > 0) {
			System.out.println("\t5\tBaht coins\t= " + (int) Math.floor(money / 5));
			tot += Math.floor(money / 5);
			money = money % 5;
		}
		if ((int) Math.floor(money / 2) > 0) {
			System.out.println("\t2\tBaht coins\t= " + (int) Math.floor(money / 2));
			tot += Math.floor(money / 2);
			money = money % 2;
		}
		if ((int) Math.floor(money / 1) > 0) {
			System.out.println("\t1\tBaht coins\t= " + (int) Math.floor(money / 1));
			tot += Math.floor(money / 1);
			money = money % 1;
		}
		if ((int) Math.floor(money / 0.50) > 0) {
			System.out.println("\t50\tSatang coins\t= " + (int) Math.floor(money / 0.50));
			tot += Math.floor(money / 0.50);
			money = money % 0.50;
		}
		if ((int) Math.floor(money / 0.25) > 0) {
			System.out.println("\t25\tSatang coins\t= " + (int) Math.floor(money / 0.25));
			tot += Math.floor(money / 0.25);
			money = money % 0.25;
		}

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
				System.out.printf("| Total \t\t\t %7d |", total);
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
