package debug.model;

import debug.Animal; //K: `Animal` wurde nicht importiert
public class Dog extends Animal{
    
  public Dog(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.getName(); //K: `name_` ist `private` in `Animal`; Getter `getName()` sollte verwendet werden
  }

  @Override
  public int getArms() {
    return 4;
  }

  @Override
  public int getLegs() {
    return 4;
  }

  @Override
  public String toString() {
                                                                //K: Reihenfolge der Argumente in `String.format()` ist falsch
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}

/*
  Zeile 3: `Animal` wurde nicht importiert:
  Fehlermeldung:
  **************
  error: cannot find symbol
  public class Dog extends Animal{
                          ^
    symbol: class Animal
  **************


  Zeile 13: `name_` ist `private` in `Animal`; Getter `getName()` sollte verwendet werden:
  Fehlermeldung:
  **************
  error: name_ has private access in Animal
    return super.name_;
                ^
  **************


  Zeile 28: Reihenfolge der Argumente in `String.format()` ist falsch:
 */