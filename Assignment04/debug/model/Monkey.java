package debug.model;

import debug.Animal;

public class Monkey extends Animal {
  public Monkey(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.getName(); //K: `name_` ist `private` in `Animal`; Getter `getName()` sollte verwendet werden
  }

  @Override
  public int getArms() {
    return 2;
  }

  @Override
  public int getLegs() {
    return 2;
  }

  @Override
  public String toString() {
    return String.format("%s is a monkey with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}

/*
  Zeile 13: `name_` ist `private` in `Animal`; Getter `getName()` sollte verwendet werden:
  Fehlermeldung:
  **************
  ./debug/model/Monkey.java:13: error: name_ has private access in Animal
    return super.name_;
                ^
  **************
 */