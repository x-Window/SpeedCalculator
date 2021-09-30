public class Unit {
    private String name;
    private double speed;
    public Unit(String n, double s){
        name = n;
        speed = s;
    }
    public String toString(){
        return name;
    }
    public double getSpeed(){
        return speed;
    }
}

