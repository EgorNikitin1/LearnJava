package Task7;

/**
 * Класс "Доставка"
 */
public class DeliveryService implements Observer {
    Subject accounting;

    public DeliveryService(Subject accounting) {
        this.accounting = accounting;
        accounting.registerObserver(this);
    }

    public void update(int income, String item) {
        if (income < 20000) {
            System.out.println("Стоимость доставки: 1000");
        }
        else {
            System.out.println("Доставка бесплатная");
        }
    }
}
