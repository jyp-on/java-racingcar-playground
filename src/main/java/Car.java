public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 1;
    }

    public void move() {
        this.location += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }
}
