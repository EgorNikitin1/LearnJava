package Task7;

import java.util.ArrayList;

/**
 * Класс "Бухгалтерия"
 */
public class Accounting implements Subject {

    private static Accounting uniqueInstance;
    private int income = 0;
    private final String PASSWORD = "admin";
    private String item;
    ArrayList<Observer> obsList = new ArrayList<>();

    public void registerObserver(Observer o) {obsList.add(o);}

    public void removeObserver(Observer o) {
        if (obsList.contains(o)) {obsList.remove(o);}
    }

    public void notifyObservers() {
        for (Observer o:obsList) {o.update(income, item);}
    }

    private Accounting() {

    }

    public static Accounting getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Accounting();
        }
        return uniqueInstance;
    }

    /**
     * Метод распечатывает доход по паролю
     * @param psw - пароль
     */
    public void getIncome(String psw){
        if (psw.equals(PASSWORD)) {System.out.println("Доход: " + income);}
        else {
            System.out.println("Неверный пароль");
        }
    }

    /**
     * Метод считает общий доход
     * @param newOrder - сумма нового заказа
     */
    public void update(int newOrder, String item){
        income += newOrder;
        this.item = item;
        notifyObservers();
    }

}
