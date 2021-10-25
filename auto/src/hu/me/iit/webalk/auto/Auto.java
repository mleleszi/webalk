package hu.me.iit.webalk.auto;

public class Auto {

    private final Wheel[] wheels;
    private final Engine engine;
    private final String type;

    public Auto(Wheel[] wheels, Engine engine, String type) {
        this.wheels = wheels;
        this.engine = engine;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "wheels=" + wheels[0].toString() +
                ", engine=" + engine +
                ", type='" + type + '\'' +
                '}';
    }
}
