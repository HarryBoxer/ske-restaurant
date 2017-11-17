package code;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RestaurantManager {

	private static ArrayList<String> menu = new ArrayList<>();
	private static ArrayList<Double> price = new ArrayList<>();

	public static void readFile() {

		String fileName = "data/Menu.txt";
		ClassLoader loader = RestaurantManager.class.getClassLoader();
		InputStream input = loader.getResourceAsStream(fileName);
		if (input == null) {
			System.out.println("Couldn't find file " + fileName);
			return;
		}
		Scanner sc = new Scanner(input);
		while (sc.hasNextLine()) {
			String check = sc.nextLine();
			if (check.startsWith("#")) {
				continue;
			}
			String[] list = check.split(";");
			menu.add(list[0].trim());
			price.add(Double.parseDouble(list[1]));
		}
		sc.close();
	}

	public static String[] getMenuItems() {
		String[] itemMenu = menu.toArray(new String[menu.size()]);
		return itemMenu;
	}
	
	public static double[] getPrices(){
		double[] priceMenu = new double[price.size()];
		for(int x = 0 ; x < priceMenu.length ; x++) {
			priceMenu [x] = price.get(x);
		}
		return priceMenu;
	}
}
