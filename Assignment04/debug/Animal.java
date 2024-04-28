package debug;

public class Animal {
  private String name_;
  private int legs_;
  private int arms_;


  Animal(String name, int legs, int arms) {
    this.name_ = name;
    this.legs_ = legs;
    this.arms_ = arms;
  }

  public Animal(String name) {//K: Konsruktor `Animal(String)` ist nicht `public`
    this(name, 0, 0);
  }


  public String getName() {
    return this.name_;
  }

  public int getArms() {
    return this.arms_;
  }

  public int getLegs() {
    return this.legs_;
  }

  @Override
  public String toString() {
    return String.format("%s is an animal with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}

/*
  Zeile 15: Konsruktor `Animal(String)` ist nicht `public`
  Fehlermeldung:
  **************
  error: constructor Animal in class Animal cannot be applied to given types;
    super(name);
    ^
  required: String
  found:    String
  reason: Animal(String) is not public in Animal; cannot be accessed from outside package
  **************
 */