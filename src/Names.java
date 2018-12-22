import java.util.Random;

public class Names {
	private static Random rand = new Random();
	private static int counter = 1;

	private static String[] fnames = { "Emma", "Ryan", "Sam", "Alex", "Taylor", "Morgan", "Sydney", "Jamie",
			"Cameron" };
	private static String[] lnames = { "Stone", "Smith", "Brown", "White", "Black", "Green", "Martin", "Lee",
			"Walker" };

	public static String getFName() {
		return getAtRandIndex(fnames);
	}

	public static String getLName() {
		return getAtRandIndex(lnames) + counter++;
	}

	private static String getAtRandIndex(String[] arr) {
		int len = arr.length;
		String randStr = arr[rand.nextInt(len)];
		return randStr;
	}
}
