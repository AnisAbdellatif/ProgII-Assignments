public class IntList {
	public static int countNumbers(int num) {
		if (num == 0) {
			return 1;
		}
		int count = 0;
		while (num > 0) {
			num = num / 10;
			count++;
		}
		return count;
	}

	public static void printList(int[] numbers) {
		System.out.print("[ ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println("]");
	}

	public static int[] intToList(int value) {
		int count = countNumbers(value);
		int[] list = new int[count];
		for (int i = 0; i < count; i++) {
			list[i] = (int) (value / Math.pow(10, (count - i - 1))); // Zunächst wird durch 10 hoch i -1 geteilt, d. h. die linke Ziffer wird ausgewählt.
			value %= (int) (Math.pow(10, (count - i - 1))); // Dann wird der Restwert berechnet, d. h. wir bringen die erste Ziffer heraus
		}
		return list;
	}

	public static int listToInt(int[] numbers) {
		int number = 0;
		for (int i = 0; i < numbers.length; i++) {
			number = number * 10 + numbers[i];
		}
		return number;
	}

	public static int[] addOne(int[] numbers) {
		int number = listToInt(numbers); // einfach die Liste in eine Zahl umwandeln
		number++; // dazu 1 addieren
		int[] list = intToList(number); // und dann noch die Zahl in eine Liste umwandeln
		return list;
	}

	public static void main(String[] args) {
		// Teilaufgabe 1 Tests:
		System.out.print("Count of 0: ");
		System.out.println(countNumbers(0));

		System.out.print("Count of 1234: ");
		System.out.println(countNumbers(1234));

		// Teilaufgabe 2 Tests:
		System.out.print("1234 to list: ");
		printList(intToList(1234));

		System.out.print("001 to list: ");
		printList(intToList(001));

		// Teilaufgabe 3 Tests:
		System.out.print("[1, 2, 3, 4] to int: ");
		System.out.println(listToInt(new int[] {1, 2, 3, 4}));

		System.out.print("[0, 0, 1] to int: ");
		System.out.println(listToInt(new int[] {0, 0, 1}));


		int number = 9999;
		System.out.println(number);
		int[] list = intToList(number);
		printList(list);
		int[] newList = addOne(list);
		printList(newList);
		int newNumber = listToInt(newList);
		System.out.println(newNumber);
	}
}
