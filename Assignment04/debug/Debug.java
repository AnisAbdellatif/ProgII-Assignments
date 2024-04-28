package debug;

import debug.model.*;
import debug.Animal; //K: `Animal` wurde nicht importiert

public class Debug {
  public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Animal("Kangaroo Bob", 2, 2);
    animals[1] = new Dog("Barks");
    animals[2] = new Monkey("King Kong");
    for (int i = 0; i < animals.length; ++i) {
      System.out.println(animals[i]);
    }
  }
}

/*
  Zeile 4: `Animal` wurde nicht importiert:
  Fehlermeldung:
  **************
  Debug.java:7: error: cannot find symbol
    Animal[] animals = new Animal[3];
    ^
  symbol:   class Animal
  location: class Debug
  **************
 */