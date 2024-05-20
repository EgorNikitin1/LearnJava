package Task7;

/**
 * Класс "Бухгалтерия"
 */
public class Accounting implements Observer {

    private static Accounting uniqueInstance;
    private int income = 0;
    private final String PASSWORD = "admin";
    Subject update;

    private Accounting(Subject update) {
        this.update = update;
        update.registerObserver(this);
    }

    public static Accounting getInstance(Subject update) {
        if (uniqueInstance == null) {
            uniqueInstance = new Accounting(update);
        }
        return uniqueInstance;
    }

    public void getIncome(String psw){
        if (psw.equals(PASSWORD)) {System.out.println("Доход: " + income);}
        else {
            System.out.println("Неверный пароль");
        }
    }

    public void updateItem(String item) {

    }

    public void updateIncome(int newOrder) {
        income += newOrder;
    }

}
