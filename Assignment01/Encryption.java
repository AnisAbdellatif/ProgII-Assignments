public class Encryption {

	public static int nextInt(int a, int b, int m, int x) {
		return (a * x + b) % m;
	}

	public static void printIntArray(int[] keys) {
		for (int i = 0; i < keys.length; i++) {
			System.out.print(((int) keys[i]));
			System.out.print(' ');
		}
		System.out.print('\n');
	}

	public static void printCharArray(char[] letters) {
		for (int i = 0; i < letters.length; i++) {
			System.out.print(((char) letters[i]));
		}
		System.out.print('\n');
	}

	public static int[] encrypt(char[] letters, int[] keys) {
		int[] encLetters;
		encLetters = new int[letters.length];

		for (int i = 0; i < letters.length; i++) {
			int char_as_int = ((int) letters[i]);
			if (i == 0) {
				encLetters[i] = char_as_int ^ keys[i];
			} else {
				encLetters[i] = char_as_int ^ keys[i] ^ encLetters[i - 1];
			}
		}

		return encLetters;
	}

	public static char[] decrypt(int[] letters, int[] keys) {
		char[] decLetters;
		decLetters = new char[letters.length];

		for (int i = 0; i < letters.length; i++) {
			if (i == 0) {
				decLetters[i] = (char) (letters[i] ^ keys[i]);
			} else {
				decLetters[i] = (char) (letters[i] ^ keys[i] ^ letters[i-1]);
			}
		}
		
		return decLetters;
	}

	public static void main(String[] args) {
		int a, b, m, x0;
		a = 7;
		b = 28;
		m = 256;
		x0 = 3;

		char[] letters = { 'H', 'A', 'L', 'L', 'O' };

		int[] keys;
		keys = new int[letters.length];
		for (int i = 0; i < keys.length; i++) {
			x0 = nextInt(a, b, m, x0);
			keys[i] = x0;
		}
		printIntArray(keys);

		int[] encLetters = encrypt(letters, keys);
		char[] decLetters = decrypt(encLetters, keys);

		printCharArray(letters);
		printIntArray(encLetters);
		printCharArray(decLetters);

	}
}