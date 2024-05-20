package Task7;

public interface Subject {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserversItem() throws Exception;
    void notifyObserversIncome();

}
