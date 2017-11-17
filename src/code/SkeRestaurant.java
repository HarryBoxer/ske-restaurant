package code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class for SKE Restaurarnt order taking application. It displays a menu
 * and accepts items to order. When done, it prints a receipt including the
 * order total.
 *
 * @author Sorrawit Tantharatana
 */

public class SkeRestaurant {
	

	static String[] menu;
	static double[] price;

	static int[] bankMoney = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };

	static Scanner sc = new Scanner(System.in);

	public static int[] getSumQuantity(int choice, int[] sumQuantity, int qty) {
		if (choice >= 1 && choice <= menu.length) {
			sumQuantity[choice - 1] += qty;
		}
		return sumQuantity;
	}

	public static double[] getSumPrice(int choice, double[] sumPrice, int qty) {
		if (choice >= 1 && choice <= menu.length) {
			sumPrice[choice - 1] += qty * price[choice - 1];
		}
		return sumPrice;
	}

	public static double getTotal(int[] sumQuantity) {
		double total = 0.0;
		for (int x = 0; x < menu.length; x++) {
			total += sumQuantity[x] * price[x];
		}
		return total;
	}

	public static void pudMoney(double money, double tot) {

		for (int i = 0; i < bankMoney.length; i++) {
			if (i < 5) {
				if ((int) Math.floor(money / bankMoney[i]) > 0) {
					System.out.printf("\t%d\tBaht banknote\t= %d\n ", bankMoney[i],
							(int) Math.floor(money / bankMoney[i]));
					tot += Math.floor(money / bankMoney[i]);
					money = money % bankMoney[i];
				}
			} else {
				if ((int) Math.floor(money / bankMoney[i]) > 0) {
					System.out.printf("\t%d\tBaht coin\t= %d\n ", bankMoney[i], (int) Math.floor(money / bankMoney[i]));
					tot += Math.floor(money / bankMoney[i]);
					money = money % bankMoney[i];
				}
			}
		}
	}

	public static void printMenu() {
		System.out.println("\n---------- Welcome to SKE Restaurant ----------\n");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d.) %-24s%.2f\tBaht. \n", i + 1, menu[i], price[i]);
		}
		System.out.printf("%d.) Total\n", menu.length + 1);
		System.out.printf("%d.) CashIn & Exit\n", menu.length + 2);
		System.out.println("-----------------------------------------------");
	}

	public static int enterChoice() {
		System.out.print("Enter Your Choice: ");
		int chc = sc.nextInt();
		return chc;
	}

	public static int enterQuantity() {
		System.out.print("Enter Quantity: ");
		int qty = sc.nextInt();
		return qty;
	}

	public static void midTable() {
		System.out.println("\n+------------------+---------+-----------+");
	}

	public static void thanks() {
		System.out.print("\n---------------- THANKYOU -----------------");
	}

	public static void cash(double tot, double in) {

		System.out.printf("Cash OUT\n");
		double money = in - tot;
		System.out.printf("Changes %.0f Baht.", money);
		if (money == money) {
			System.out.println();
		}
		pudMoney(money, tot);
	}

	public static void main(String[] args) {
		RestaurantManager.readFile();
		menu = RestaurantManager.getMenuItems();
		price = RestaurantManager.getPrices();
		int[] sumQuantity = new int[menu.length];
		double[] sumPrice = new double[price.length];

		int qty = 0, select = 0;
		double total = 0;

		printMenu();

		while (true) {
			System.out.println();
			select = enterChoice();

			if (select >= 1 && select <= menu.length) {
				qty = enterQuantity();
				sumQuantity = getSumQuantity(select, sumQuantity, qty);
				sumPrice = getSumPrice(select, sumPrice, qty);
//				System.out.println(Arrays.toString(sumQuantity));
//				System.out.println(Arrays.toString(sumPrice));

			}
			if (select == menu.length + 1) {
				System.out.print("\n+------ Menu ------+-- Qty --+-- Price --+\n");
				for (int x = 0; x < menu.length; x++) {
					if (sumQuantity[x] >= 1) {
						System.out.printf("| %-17s|\t%3d  |\t %7.2f |", menu[x], sumQuantity[x], sumPrice[x]);
						midTable();
					}
				}
				total = getTotal(sumQuantity);
				System.out.printf("| Total \t\t\t\t %7.2f |", total);
				midTable();
				System.out.println();
			}
			if (select == menu.length + 2) {
				total = getTotal(sumQuantity);
				System.out.printf("\nCash IN\t\t ");
				double in = sc.nextDouble();
				if (in < total) {
					System.out.printf("NOT ENOUGH MONEY!");
					break;
				} else if (in == total) {
					System.out.print("\nNo Need To Change Back !\n");
					thanks();
					break;
				} else {
					cash(total, in);
					thanks();
					break;
				}
			}
		}
	}
}
