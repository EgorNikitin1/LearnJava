package Task7;

import java.util.ArrayList;

public class Update implements Subject {

    private int newOrder;
    private String item;

    ArrayList<Observer> obsList = new ArrayList<>();

    public void registerObserver(Observer o) {obsList.add(o);}

    public void removeObserver(Observer o) {
        obsList.remove(o);
    }

    public void notifyObserversItem() throws Exception {
        for (Observer o:obsList) {o.updateItem(item);}
    }
    public void notifyObserversIncome() {
        for (Observer o:obsList) {o.updateIncome(newOrder);}
    }

    public void updateItem(String item) throws Exception {
        this.item = item;
        notifyObserversItem();
    }

    public void updateIncome(int newOrder) {
        this.newOrder = newOrder;
        notifyObserversIncome();
    }
}
