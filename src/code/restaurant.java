package code;
import java.util.Scanner;
public class restaurant {
	
			static int orde(int chs){
				
				int price = 0 ;
				if (chs == 1){
					price = 250 ;
				}else if (chs == 2){
					price = 120 ;
				}else if (chs == 3){
					price = 45 ;
				}else if (chs == 4){
				price = 99 ;
				}
				return price;
			}
			static void menu(){
				System.out.println("\n---------- Welcome to SKE Restaurant ----------\n");
				System.out.printf("1.) Pizza\t\t250 Baht. \n");
				System.out.printf("2.) Chickens\t\t120 Baht.\n");
				System.out.printf("3.) Coke\t\t 45 Baht.\n");
				System.out.printf("4.) SKE Steak\t\t 99 Baht.\n");
				System.out.println("5.) Total");
				System.out.println("6.) CashIn & Exit\n");
			}
			static void enCh(){
				System.out.print("Enter Your Choice: ");
			}
			static void enQt(){
				System.out.print("Enter Quantity: ");
			}
			static void tb(){
				System.out.println("\n+------------------+---------+-----------+");
			}
			static void tk(){
				System.out.print("\n---------------- THANKYOU -----------------");

			}
			static void cash(double tot , double in){

				System.out.printf("Cash OUT\n");
				double money = in - tot;
				System.out.printf("Give Customer %.0f Baht.", money);
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

				int one = 0, two = 0, thr = 0, fou = 0;
				int pc1 = 0, pc2 = 0, pc3 = 0, pc4 = 0, count = 0;
				int total = 0;
				int b1 = 0, b2 = 0, b3 = 0, b4 = 0;

				Scanner sc = new Scanner(System.in);
				menu();

				do {
					enCh();
					int se = sc.nextInt();

					if (se == 1) {
						enQt();
						int qt = sc.nextInt();
						System.out.println();
						pc1 = pc1 + qt;
						one = one + qt;
						b1 = one * orde(se);
					}
					if (se == 2) {
						enQt();
						int qt = sc.nextInt();
						System.out.println();
						pc2 = pc2 + qt;
						two = two + qt;
						b2 = two * orde(se);
					}
					if (se == 3) {
						enQt();
						int qt = sc.nextInt();
						System.out.println();
						pc3 = pc3 + qt;
						thr = thr + qt;
						b3 = thr * orde(se);
					}
					if (se == 4) {
						enQt();
						int qt = sc.nextInt();
						System.out.println();
						pc4 = pc4 + qt;
						fou = fou + qt;
						b4 = fou * orde(se);
					}
					if (se == 5) {
						System.out.print("\n+------ Menu ------+-- Qty --+-- Price --+\n");
						if (one >= 1) {
							System.out.printf("| Pizza\t\t   |\t %3d |\t %7d |", pc1, b1);
							tb();
						}
						if (two >= 1) {
							System.out.printf("| Chicken\t   |\t %3d |\t %7d |", pc2, b2);
							tb();
						}
						if (thr >= 1) {
							System.out.printf("| Coke\t\t   |\t %3d |\t %7d |", pc3, b3);
							tb();
						}
						if (fou >= 1) {
							System.out.printf("| SKESteak         |\t %3d |\t %7d |", pc4, b4);
							tb();
						}
						total = b1 + b2 + b3 + b4;
						System.out.printf("| Total \t\t\t %7d |", total);
						tb();
						System.out.println();
					}
					if (se == 6) {
						total = b1 + b2 + b3 + b4;
						System.out.printf("Cash IN\t\t ");
						double in = sc.nextDouble();
						if (in < total) {
							System.out.printf("NOT ENOUGH MONEY!");
							count++;
						} else if (in == total) {
							System.out.print("\nNo Need To Change Back !\n");
							tk();
							count++;
						} else {
							cash(total , in);
							tk();
							count++;
						}
					}
				} while (count <= 0);
			}
}
