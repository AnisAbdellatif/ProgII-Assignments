package aufgabe3.data;

import java.lang.Math;

// This class is representing a cartesian coordinate in a 2d space with double coordinates.
public class DebugData { //K: class nicht als public definiert (class DebugData)
    private double x;
    private double y;
    
    public DebugData(double x, double y) { //K: x und y sind von double-Art und nicht von int-Art (int x, int y)
        this.x = x;
        this.y = y;
    }
    
    public double distance(DebugData other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)); //K: Wurzel ´sqrt´ statt potenzieren ´pow´ (Math.pow(...))
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y; //K: Soll this.y und nicht this.x sein (this.x)
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public String str() {
        return String.format("(%g, %g)", this.x, this.y);
    }
}

/*
    Zeile 6: class nicht als public definiert (class DebugData)
    Fehlermeldung:
    **************
    aufgabe3/DebugMain.java:2: error: DebugData is not public in aufgabe3.data; cannot be accessed from outside package
    import aufgabe3.data.DebugData;
                        ^
    **************
    DebugData class soll public sein, um es in einen anderen Datei zu importieren.

    Zeile 10: Die Parameter x und y sollen double sein (int)
    Fehlermeldung:
    **************
    aufgabe3/DebugMain.java:6: error: incompatible types: possible lossy conversion from double to int
        DebugData a = new DebugData(3.4, 5.6);
                                    ^
    **************
    Es wurde erwartet, dass x und y beide von Typ double sind.
    
    Zeile 15: Wurzel ´sqrt´ statt potenzieren ´pow´ (Math.pow(...))
    distance = sqrt(x²+y²)

    Zeile 24: Soll this.y und nicht this.x sein (this.x)
    Das is ein y-Getter
*/