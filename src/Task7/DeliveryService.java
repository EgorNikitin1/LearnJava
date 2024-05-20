package Task7;

/**
 * Класс "Доставка"
 */
public class DeliveryService implements Observer {

    private int delivery = 0;
    Subject update;

    public DeliveryService(Subject update) {
        this.update = update;
        update.registerObserver(this);
    }

    public void updateItem(String item) {

    }

    public void updateIncome(int income) {
        delivery += income * 0.05;
        System.out.println("Стоимость доставки: " + delivery);
    }

}
