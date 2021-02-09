package observer;

public class Person implements Observer {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.printf("%s got new notification: %s%n", this.name, message);
    }
}
