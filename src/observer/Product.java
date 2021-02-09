package observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject{

    private String name;

    //observers are interested in this
    private String availability;

    private List<Observer> observerList;

    public Product(String name){
        this.name = name;
        this.observerList = new ArrayList<>();
    }

    /**
     * Set the product availability based on boolean value and notify all observers
     * @param available
     */
    public void setAvailability(boolean available) {
        availability = this.name + (available ? " Available": " Not available");
        notifyAllObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer:
             observerList) {
              observer.update(availability);
        }
    }
}
