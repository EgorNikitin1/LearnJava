package Task7;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс "Склад"
 */
public class Warehouse implements Observer {

    Map<String, Integer> quantity = new HashMap<>();
    Subject update;

    public Warehouse(Subject update){
        this.update = update;
        quantity.put("стол", 10);
        quantity.put("шкаф", 5);
        quantity.put("кресло", 5);
        quantity.put("кухня", 2);
        quantity.put("диван", 3);
        quantity.put("кровать", 2);
        update.registerObserver(this);
    }

    public void updateItem(String item) throws Exception {
        int prevValue = quantity.get(item);
        System.out.println(item);
        if (prevValue == 0) {
            throw new Exception("Товар \"" + item + "\" закончился.");
        } else {
            System.out.println("Спасибо за покупку!");
            quantity.put(item, --prevValue);
        }
    }

    public void updateIncome(int newOrder) {

    }

    public void printWarehouse() {
        for (var pr: quantity.entrySet()) {
            System.out.println(pr + " шт.");
        }
    }

}
