class Debug {  //K: class falsch geschrieben (ckass)
    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n < 2) { //K: n soll streng unterhalb von 2 sein (<=)
            return false;
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i++) { //K: i inkrementieren statt dekrementieren (i--)
            if (n % i == 0) {
                return false; //K: soll false zurückgeben (true)
            }
        }
        // If no prime factor was found, return true.
        return true;
    }


    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {  //K: laufen bis i streng unterhalb von arr.length ist (<=)
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }

	public static void main(String[] args) { //K: main-Method fehlt.
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		printPrime(arr);
	}

    

    // output should be as follows:
    // 2
    // 3
    // 5
    // 7
}

/*
	Zeile 1: class Keyword falsch geschrieben (ckass):
	Fehlermeldung:
	**************
	Debug.java:1: error: class, interface, enum, or record expected
	ckass Debug {
	^
	**************
	Der Compiler erwartet eines der drei oben angegebenen Keywords , hat aber nur das falsch geschriebene ckass bekommen.
	
	...

	Zeile 30: main-Methode fehlt.
	Fehlermeldung:
	**************
	Debug.java:30: error: invalid method declaration; return type required
	printPrime(arr);
	^
	Debug.java:30: error: <identifier> expected
	printPrime(arr);
				  ^
	**************
	der Compiler dachte, es handele sich um eine neue Deklaration der Methode printPrime, \
	in Wirklichkeit sollte printPrime innerhalb der main-Methode aufgerufen werden.

	...

	Zeile 5: n soll streng unterhalb von 2 sein (<=)
	Semantischer Fehler (Keine Fehlermeldung)
	falsch zurückgeben, nur wenn gleich 1, 0 oder negativ ist. 2 ist doch prime.

	...

	Zeile 10: i inkrementieren statt dekrementieren (i--)
	Semantischer Fehler (Keine Fehlermeldung)
	i inkrementieren, bis es n/2 erreicht.

	...

	Zeile 12: soll false zurückgeben (true)
	Semantischer Fehler (Keine Fehlermeldung)
	Wenn es ein prime factor gibt, falsh zurückgeben.

	...

	Zeile 22: laufen bis i streng unterhalb von arr.length ist (<=)
	Semantischer Fehler, Fehlermeldung:
	**************
	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
		at Debug.printPrime(Debug.java:23)
		at Debug.main(Debug.java:31)
	**************
	Das Array hat nur 10 Elemente, also gehen die Indizes von 0 bis 9. Es gibt kein 10.
*/