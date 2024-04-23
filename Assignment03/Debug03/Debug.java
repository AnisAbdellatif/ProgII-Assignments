enum Operator {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

//Should not be instanciated with right_==0 and op_==DIVIDE
class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op){
    this.left_  = left;
    this.right_ = right;
    this.op_    = op;
  }

  double evaluate() {
    switch (this.op_) {
      case ADD:
        return this.left_ + this.right_;
      case SUBTRACT:
        return this.left_ - this.right_;
      case MULTIPLY:
        return this.left_ * this.right_;
      case DIVIDE:
        if (this.right_ == 0) { // K: prevent division by zero; throw exception if division by zero is attempted
          throw new ArithmeticException("Division by zero!");
        }
        return this.left_ / this.right_;
      default:
        return 0.0;
    }
  }
}

class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[4]; //K: 5 -> 4
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(i + 1, i, ops[i]);
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}

/*
    Zeile 18, 20 22, 24: cases sind keine Enum-Konstanten
    Fehlermeldung:
    **************
    Debug03/Debug.java:18: error: an enum switch case label must be the unqualified name of an enumeration constant
        case Operator.ADD:
                     ^
    Debug03/Debug.java:20: error: an enum switch case label must be the unqualified name of an enumeration constant
        case Operator.SUBTRACT:
                     ^
    Debug03/Debug.java:22: error: an enum switch case label must be the unqualified name of an enumeration constant
        case Operator.MULTIPLY:
                     ^
    Debug03/Debug.java:24: error: an enum switch case label must be the unqualified name of an enumeration constant
          case Operator.DIVIDE:
                       ^
    **************
    Wenn switch-case für eine Enum verwendet wird, sollten die Fälle Enum-Konstanten sein, d.h. die verschiedenen Werte der Aufzählung.

    ...

    Zeile 38: Es sind nur 4 Operatoren vorhanden, aber 5 werden erwartet
    Fehlermeldung:
    **************
    Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Operator.ordinal()" because "this.op_" is null
        at Expression.evaluate(Debug.java:17)
        at Debug.main(Debug.java:47)
    **************

    ...

    Zeile 25: Division durch Null verhindern.
 */